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
    private static long cNA = -1;
    private static int cNB = 0;
    private static ImDbShrinkStatic cNx;
    private a cNy = new a(null);
    private b cNz = null;

    static {
        anw();
    }

    public static ImDbShrinkStatic anw() {
        if (cNx == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cNx == null) {
                    cNx = new ImDbShrinkStatic();
                }
            }
        }
        return cNx;
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
                    ImDbShrinkStatic.anw().cNy.removeMessages(1);
                    ImDbShrinkStatic.anw().execute();
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
        if (this.cNz != null) {
            this.cNz.cancel();
            this.cNz = null;
        }
        this.cNz = new b(this, null);
        this.cNz.setParallel(TiebaIMConfig.getParallel());
        this.cNz.setPriority(4);
        this.cNz.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cNz != null) {
            this.cNz.cancel();
            this.cNz = null;
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
            LinkedList<ImMessageCenterPojo> anC = i.anz().anC();
            if (anC == null || anC.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cNA < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cNA = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cNA > 2147483648L) {
                        ImDbShrinkStatic.cNB = 5000;
                    } else if (ImDbShrinkStatic.cNA > 1073741824) {
                        ImDbShrinkStatic.cNB = 3000;
                    } else {
                        ImDbShrinkStatic.cNB = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cNB < 1000) {
                ImDbShrinkStatic.cNB = 1000;
            }
            try {
                g.anu().anv();
                for (ImMessageCenterPojo imMessageCenterPojo : anC) {
                    if (isCancelled()) {
                        g.anu().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.anq().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cNB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.anF().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cNB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.anE().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cNB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.anr().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cNB);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.anu().endTransaction();
            }
            return true;
        }
    }
}
