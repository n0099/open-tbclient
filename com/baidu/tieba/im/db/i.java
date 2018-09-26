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
    private static i exN;
    private static long exQ = -1;
    private static int exR = 0;
    private a exO = new a();
    private b exP = null;

    public static i aLU() {
        if (exN == null) {
            synchronized (i.class) {
                if (exN == null) {
                    exN = new i();
                }
            }
        }
        return exN;
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
                    i.aLU().exO.removeMessages(1);
                    i.aLU().execute();
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
                        i.this.exO.sendMessageDelayed(i.this.exO.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.exO.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.exP != null) {
            this.exP.cancel();
            this.exP = null;
        }
        this.exP = new b();
        this.exP.setParallel(TiebaIMConfig.getParallel());
        this.exP.setPriority(4);
        this.exP.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.exP != null) {
            this.exP.cancel();
            this.exP = null;
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
            LinkedList<ImMessageCenterPojo> aLY = j.aLV().aLY();
            if (aLY == null || aLY.size() == 0) {
                return false;
            }
            if (i.exQ < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.exQ = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.exQ > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.exR = 5000;
                    } else if (i.exQ > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.exR = 3000;
                    } else {
                        int unused4 = i.exR = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.exR < 1000) {
                int unused5 = i.exR = 1000;
            }
            try {
                h.aLS().aLT();
                for (ImMessageCenterPojo imMessageCenterPojo : aLY) {
                    if (isCancelled()) {
                        h.aLS().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aLL().ah(imMessageCenterPojo.getGid(), i.exR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aMd().ah(imMessageCenterPojo.getGid(), i.exR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aMb().ah(imMessageCenterPojo.getGid(), i.exR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aLM().ah(imMessageCenterPojo.getGid(), i.exR);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aLS().endTransaction();
            }
            return true;
        }
    }
}
