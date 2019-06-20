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
    private static i gys;
    private static long gyv = -1;
    private static int gyw = 0;
    private a gyt = new a();
    private b gyu = null;

    public static i bAd() {
        if (gys == null) {
            synchronized (i.class) {
                if (gys == null) {
                    gys = new i();
                }
            }
        }
        return gys;
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
                    i.bAd().gyt.removeMessages(1);
                    i.bAd().execute();
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
                        i.this.gyt.sendMessageDelayed(i.this.gyt.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.gyt.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.gyu != null) {
            this.gyu.cancel();
            this.gyu = null;
        }
        this.gyu = new b();
        this.gyu.setParallel(TiebaIMConfig.getParallel());
        this.gyu.setPriority(4);
        this.gyu.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.gyu != null) {
            this.gyu.cancel();
            this.gyu = null;
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
            LinkedList<ImMessageCenterPojo> bAh = j.bAe().bAh();
            if (bAh == null || bAh.size() == 0) {
                return false;
            }
            if (i.gyv < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.gyv = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.gyv > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.gyw = UIMsg.m_AppUI.MSG_APP_GPS;
                    } else if (i.gyv > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.gyw = 3000;
                    } else {
                        int unused4 = i.gyw = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.gyw < 1000) {
                int unused5 = i.gyw = 1000;
            }
            try {
                h.bAb().bAc();
                for (ImMessageCenterPojo imMessageCenterPojo : bAh) {
                    if (isCancelled()) {
                        h.bAb().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bzU().aE(imMessageCenterPojo.getGid(), i.gyw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bAm().aE(imMessageCenterPojo.getGid(), i.gyw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bAk().aE(imMessageCenterPojo.getGid(), i.gyw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bzV().aE(imMessageCenterPojo.getGid(), i.gyw);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bAb().endTransaction();
            }
            return true;
        }
    }
}
