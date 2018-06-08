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
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i eiL;
    private static long eiO = -1;
    private static int eiP = 0;
    private a eiM = new a();
    private b eiN = null;

    public static i aIa() {
        if (eiL == null) {
            synchronized (i.class) {
                if (eiL == null) {
                    eiL = new i();
                }
            }
        }
        return eiL;
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
                    i.aIa().eiM.removeMessages(1);
                    i.aIa().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.eiM.sendMessageDelayed(i.this.eiM.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eiM.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eiN != null) {
            this.eiN.cancel();
            this.eiN = null;
        }
        this.eiN = new b();
        this.eiN.setParallel(TiebaIMConfig.getParallel());
        this.eiN.setPriority(4);
        this.eiN.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eiN != null) {
            this.eiN.cancel();
            this.eiN = null;
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
            LinkedList<ImMessageCenterPojo> aIe = j.aIb().aIe();
            if (aIe == null || aIe.size() == 0) {
                return false;
            }
            if (i.eiO < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eiO = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eiO > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.eiP = 5000;
                    } else if (i.eiO > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eiP = 3000;
                    } else {
                        int unused4 = i.eiP = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eiP < 1000) {
                int unused5 = i.eiP = 1000;
            }
            try {
                h.aHY().aHZ();
                for (ImMessageCenterPojo imMessageCenterPojo : aIe) {
                    if (isCancelled()) {
                        h.aHY().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aHR().ah(imMessageCenterPojo.getGid(), i.eiP);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aIj().ah(imMessageCenterPojo.getGid(), i.eiP);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aIh().ah(imMessageCenterPojo.getGid(), i.eiP);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aHS().ah(imMessageCenterPojo.getGid(), i.eiP);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aHY().endTransaction();
            }
            return true;
        }
    }
}
