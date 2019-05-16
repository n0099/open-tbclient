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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i gyp;
    private static long gys = -1;
    private static int gyt = 0;
    private a gyq = new a();
    private b gyr = null;

    public static i bzZ() {
        if (gyp == null) {
            synchronized (i.class) {
                if (gyp == null) {
                    gyp = new i();
                }
            }
        }
        return gyp;
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
                    i.bzZ().gyq.removeMessages(1);
                    i.bzZ().execute();
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
                        i.this.gyq.sendMessageDelayed(i.this.gyq.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.gyq.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.gyr != null) {
            this.gyr.cancel();
            this.gyr = null;
        }
        this.gyr = new b();
        this.gyr.setParallel(TiebaIMConfig.getParallel());
        this.gyr.setPriority(4);
        this.gyr.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.gyr != null) {
            this.gyr.cancel();
            this.gyr = null;
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
            LinkedList<ImMessageCenterPojo> bAd = j.bAa().bAd();
            if (bAd == null || bAd.size() == 0) {
                return false;
            }
            if (i.gys < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.gys = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.gys > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.gyt = UIMsg.m_AppUI.MSG_APP_GPS;
                    } else if (i.gys > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.gyt = 3000;
                    } else {
                        int unused4 = i.gyt = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.gyt < 1000) {
                int unused5 = i.gyt = 1000;
            }
            try {
                h.bzX().bzY();
                for (ImMessageCenterPojo imMessageCenterPojo : bAd) {
                    if (isCancelled()) {
                        h.bzX().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bzQ().aE(imMessageCenterPojo.getGid(), i.gyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bAi().aE(imMessageCenterPojo.getGid(), i.gyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bAg().aE(imMessageCenterPojo.getGid(), i.gyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bzR().aE(imMessageCenterPojo.getGid(), i.gyt);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bzX().endTransaction();
            }
            return true;
        }
    }
}
