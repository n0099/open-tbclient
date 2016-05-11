package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic cfn;
    private static long cfq = -1;
    private static int cfr = 0;
    private a cfo = new a(null);
    private b cfp = null;

    static {
        aev();
    }

    public static ImDbShrinkStatic aev() {
        if (cfn == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cfn == null) {
                    cfn = new ImDbShrinkStatic();
                }
            }
        }
        return cfn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    ImDbShrinkStatic.aev().cfo.removeMessages(1);
                    ImDbShrinkStatic.aev().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.cfp != null) {
            this.cfp.cancel();
            this.cfp = null;
        }
        this.cfp = new b(this, null);
        this.cfp.setParallel(TiebaIMConfig.getParallel());
        this.cfp.setPriority(4);
        this.cfp.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cfp != null) {
            this.cfp.cancel();
            this.cfp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* synthetic */ b(ImDbShrinkStatic imDbShrinkStatic, b bVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> aeA = i.aex().aeA();
            if (aeA == null || aeA.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cfq < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cfq = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cfq > 2147483648L) {
                        ImDbShrinkStatic.cfr = 5000;
                    } else if (ImDbShrinkStatic.cfq > 1073741824) {
                        ImDbShrinkStatic.cfr = 3000;
                    } else {
                        ImDbShrinkStatic.cfr = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cfr < 1000) {
                ImDbShrinkStatic.cfr = 1000;
            }
            try {
                g.aet().aeu();
                for (ImMessageCenterPojo imMessageCenterPojo : aeA) {
                    if (isCancelled()) {
                        g.aet().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aep().S(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cfr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aeD().S(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cfr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aeC().S(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cfr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aeq().S(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cfr);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aet().endTransaction();
            }
            return true;
        }
    }
}
