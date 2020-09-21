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
    private static i juU;
    private static long juX = -1;
    private static int juY = 0;
    private a juV = new a();
    private b juW = null;

    public static i cHN() {
        if (juU == null) {
            synchronized (i.class) {
                if (juU == null) {
                    juU = new i();
                }
            }
        }
        return juU;
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
                    i.cHN().juV.removeMessages(1);
                    i.cHN().execute();
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
                        i.this.juV.sendMessageDelayed(i.this.juV.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.juV.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.juW != null) {
            this.juW.cancel();
            this.juW = null;
        }
        this.juW = new b();
        this.juW.setParallel(TiebaIMConfig.getParallel());
        this.juW.setPriority(4);
        this.juW.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.juW != null) {
            this.juW.cancel();
            this.juW = null;
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
            LinkedList<ImMessageCenterPojo> cHR = j.cHO().cHR();
            if (cHR == null || cHR.size() == 0) {
                return false;
            }
            if (i.juX < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.juX = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.juX > 2147483648L) {
                        int unused2 = i.juY = 5000;
                    } else if (i.juX > 1073741824) {
                        int unused3 = i.juY = 3000;
                    } else {
                        int unused4 = i.juY = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.juY < 1000) {
                int unused5 = i.juY = 1000;
            }
            try {
                h.cHK().cHL();
                for (ImMessageCenterPojo imMessageCenterPojo : cHR) {
                    if (isCancelled()) {
                        h.cHK().cHM();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cHD().aW(imMessageCenterPojo.getGid(), i.juY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cHX().aW(imMessageCenterPojo.getGid(), i.juY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cHU().aW(imMessageCenterPojo.getGid(), i.juY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cHE().aW(imMessageCenterPojo.getGid(), i.juY);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cHK().cHM();
            }
            return true;
        }
    }
}
