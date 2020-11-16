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
    private static i kcX;
    private static long kda = -1;
    private static int kdb = 0;
    private a kcY = new a();
    private b kcZ = null;

    public static i cQK() {
        if (kcX == null) {
            synchronized (i.class) {
                if (kcX == null) {
                    kcX = new i();
                }
            }
        }
        return kcX;
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
                    i.cQK().kcY.removeMessages(1);
                    i.cQK().execute();
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
                        i.this.kcY.sendMessageDelayed(i.this.kcY.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kcY.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kcZ != null) {
            this.kcZ.cancel();
            this.kcZ = null;
        }
        this.kcZ = new b();
        this.kcZ.setParallel(TiebaIMConfig.getParallel());
        this.kcZ.setPriority(4);
        this.kcZ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kcZ != null) {
            this.kcZ.cancel();
            this.kcZ = null;
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
            LinkedList<ImMessageCenterPojo> cQO = j.cQL().cQO();
            if (cQO == null || cQO.size() == 0) {
                return false;
            }
            if (i.kda < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kda = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kda > 2147483648L) {
                        int unused2 = i.kdb = 5000;
                    } else if (i.kda > 1073741824) {
                        int unused3 = i.kdb = 3000;
                    } else {
                        int unused4 = i.kdb = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kdb < 1000) {
                int unused5 = i.kdb = 1000;
            }
            try {
                h.cQH().cQI();
                for (ImMessageCenterPojo imMessageCenterPojo : cQO) {
                    if (isCancelled()) {
                        h.cQH().cQJ();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cQA().aZ(imMessageCenterPojo.getGid(), i.kdb);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cQU().aZ(imMessageCenterPojo.getGid(), i.kdb);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cQR().aZ(imMessageCenterPojo.getGid(), i.kdb);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cQB().aZ(imMessageCenterPojo.getGid(), i.kdb);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cQH().cQJ();
            }
            return true;
        }
    }
}
