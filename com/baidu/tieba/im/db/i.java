package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private static i kqD;
    private static long kqG = -1;
    private static int kqH = 0;
    private a kqE = new a();
    private b kqF = null;

    public static i cVZ() {
        if (kqD == null) {
            synchronized (i.class) {
                if (kqD == null) {
                    kqD = new i();
                }
            }
        }
        return kqD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    i.cVZ().kqE.removeMessages(1);
                    i.cVZ().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.kqE.sendMessageDelayed(i.this.kqE.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kqE.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kqF != null) {
            this.kqF.cancel();
            this.kqF = null;
        }
        this.kqF = new b();
        this.kqF.setParallel(TiebaIMConfig.getParallel());
        this.kqF.setPriority(4);
        this.kqF.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kqF != null) {
            this.kqF.cancel();
            this.kqF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> cWd = j.cWa().cWd();
            if (cWd == null || cWd.size() == 0) {
                return false;
            }
            if (i.kqG < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kqG = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kqG > 2147483648L) {
                        int unused2 = i.kqH = 5000;
                    } else if (i.kqG > 1073741824) {
                        int unused3 = i.kqH = 3000;
                    } else {
                        int unused4 = i.kqH = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kqH < 1000) {
                int unused5 = i.kqH = 1000;
            }
            try {
                h.cVW().cVX();
                for (ImMessageCenterPojo imMessageCenterPojo : cWd) {
                    if (isCancelled()) {
                        h.cVW().cVY();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cVP().ba(imMessageCenterPojo.getGid(), i.kqH);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cWj().ba(imMessageCenterPojo.getGid(), i.kqH);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cWg().ba(imMessageCenterPojo.getGid(), i.kqH);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cVQ().ba(imMessageCenterPojo.getGid(), i.kqH);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cVW().cVY();
            }
            return true;
        }
    }
}
