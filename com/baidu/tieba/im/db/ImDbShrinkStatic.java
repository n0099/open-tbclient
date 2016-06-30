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
    private static ImDbShrinkStatic cKH;
    private static long cKK = -1;
    private static int cKL = 0;
    private a cKI = new a(null);
    private b cKJ = null;

    static {
        amM();
    }

    public static ImDbShrinkStatic amM() {
        if (cKH == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cKH == null) {
                    cKH = new ImDbShrinkStatic();
                }
            }
        }
        return cKH;
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
                    ImDbShrinkStatic.amM().cKI.removeMessages(1);
                    ImDbShrinkStatic.amM().execute();
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
        if (this.cKJ != null) {
            this.cKJ.cancel();
            this.cKJ = null;
        }
        this.cKJ = new b(this, null);
        this.cKJ.setParallel(TiebaIMConfig.getParallel());
        this.cKJ.setPriority(4);
        this.cKJ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cKJ != null) {
            this.cKJ.cancel();
            this.cKJ = null;
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
            LinkedList<ImMessageCenterPojo> amR = i.amO().amR();
            if (amR == null || amR.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cKK < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cKK = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cKK > 2147483648L) {
                        ImDbShrinkStatic.cKL = 5000;
                    } else if (ImDbShrinkStatic.cKK > 1073741824) {
                        ImDbShrinkStatic.cKL = 3000;
                    } else {
                        ImDbShrinkStatic.cKL = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cKL < 1000) {
                ImDbShrinkStatic.cKL = 1000;
            }
            try {
                g.amK().amL();
                for (ImMessageCenterPojo imMessageCenterPojo : amR) {
                    if (isCancelled()) {
                        g.amK().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.amG().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cKL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.amU().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cKL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.amT().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cKL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.amH().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cKL);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.amK().endTransaction();
            }
            return true;
        }
    }
}
