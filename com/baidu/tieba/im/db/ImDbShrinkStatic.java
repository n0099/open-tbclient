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
    private static ImDbShrinkStatic cZc;
    private static long cZf = -1;
    private static int cZg = 0;
    private a cZd = new a(null);
    private b cZe = null;

    static {
        asl();
    }

    public static ImDbShrinkStatic asl() {
        if (cZc == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cZc == null) {
                    cZc = new ImDbShrinkStatic();
                }
            }
        }
        return cZc;
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
                    ImDbShrinkStatic.asl().cZd.removeMessages(1);
                    ImDbShrinkStatic.asl().execute();
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
        if (this.cZe != null) {
            this.cZe.cancel();
            this.cZe = null;
        }
        this.cZe = new b(this, null);
        this.cZe.setParallel(TiebaIMConfig.getParallel());
        this.cZe.setPriority(4);
        this.cZe.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cZe != null) {
            this.cZe.cancel();
            this.cZe = null;
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
            LinkedList<ImMessageCenterPojo> asr = i.aso().asr();
            if (asr == null || asr.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cZf < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cZf = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cZf > 2147483648L) {
                        ImDbShrinkStatic.cZg = 5000;
                    } else if (ImDbShrinkStatic.cZf > 1073741824) {
                        ImDbShrinkStatic.cZg = 3000;
                    } else {
                        ImDbShrinkStatic.cZg = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cZg < 1000) {
                ImDbShrinkStatic.cZg = 1000;
            }
            try {
                g.asj().ask();
                for (ImMessageCenterPojo imMessageCenterPojo : asr) {
                    if (isCancelled()) {
                        g.asj().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.asf().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cZg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.asu().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cZg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.ast().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cZg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.asg().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cZg);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.asj().endTransaction();
            }
            return true;
        }
    }
}
