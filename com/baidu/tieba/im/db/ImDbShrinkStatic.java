package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bxq;
    private static long bxt = -1;
    private static int bxu = 0;
    private a bxr = new a(null);
    private b bxs = null;

    static {
        Uc();
    }

    public static ImDbShrinkStatic Uc() {
        if (bxq == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bxq == null) {
                    bxq = new ImDbShrinkStatic();
                }
            }
        }
        return bxq;
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
                    ImDbShrinkStatic.Uc().bxr.removeMessages(1);
                    ImDbShrinkStatic.Uc().execute();
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
        if (this.bxs != null) {
            this.bxs.cancel();
            this.bxs = null;
        }
        this.bxs = new b(this, null);
        this.bxs.setParallel(TiebaIMConfig.getParallel());
        this.bxs.setPriority(4);
        this.bxs.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bxs != null) {
            this.bxs.cancel();
            this.bxs = null;
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> Ui = i.Uf().Ui();
            if (Ui == null || Ui.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bxt < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bxt = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bxt > 2147483648L) {
                        ImDbShrinkStatic.bxu = 5000;
                    } else if (ImDbShrinkStatic.bxt > 1073741824) {
                        ImDbShrinkStatic.bxu = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bxu = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bxu < 1000) {
                ImDbShrinkStatic.bxu = 1000;
            }
            try {
                g.Ua().Ub();
                for (ImMessageCenterPojo imMessageCenterPojo : Ui) {
                    if (isCancelled()) {
                        g.Ua().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.TW().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bxu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.Ul().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bxu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.Uk().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bxu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.TX().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bxu);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.Ua().endTransaction();
            }
            return true;
        }
    }
}
