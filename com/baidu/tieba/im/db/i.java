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
    private static i kqB;
    private static long kqE = -1;
    private static int kqF = 0;
    private a kqC = new a();
    private b kqD = null;

    public static i cVY() {
        if (kqB == null) {
            synchronized (i.class) {
                if (kqB == null) {
                    kqB = new i();
                }
            }
        }
        return kqB;
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
                    i.cVY().kqC.removeMessages(1);
                    i.cVY().execute();
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
                        i.this.kqC.sendMessageDelayed(i.this.kqC.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kqC.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kqD != null) {
            this.kqD.cancel();
            this.kqD = null;
        }
        this.kqD = new b();
        this.kqD.setParallel(TiebaIMConfig.getParallel());
        this.kqD.setPriority(4);
        this.kqD.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kqD != null) {
            this.kqD.cancel();
            this.kqD = null;
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
            LinkedList<ImMessageCenterPojo> cWc = j.cVZ().cWc();
            if (cWc == null || cWc.size() == 0) {
                return false;
            }
            if (i.kqE < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kqE = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kqE > 2147483648L) {
                        int unused2 = i.kqF = 5000;
                    } else if (i.kqE > 1073741824) {
                        int unused3 = i.kqF = 3000;
                    } else {
                        int unused4 = i.kqF = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kqF < 1000) {
                int unused5 = i.kqF = 1000;
            }
            try {
                h.cVV().cVW();
                for (ImMessageCenterPojo imMessageCenterPojo : cWc) {
                    if (isCancelled()) {
                        h.cVV().cVX();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cVO().ba(imMessageCenterPojo.getGid(), i.kqF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cWi().ba(imMessageCenterPojo.getGid(), i.kqF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cWf().ba(imMessageCenterPojo.getGid(), i.kqF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cVP().ba(imMessageCenterPojo.getGid(), i.kqF);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cVV().cVX();
            }
            return true;
        }
    }
}
