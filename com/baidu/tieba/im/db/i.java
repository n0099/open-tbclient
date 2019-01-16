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
    private static i eRk;
    private static long eRn = -1;
    private static int eRo = 0;
    private a eRl = new a();
    private b eRm = null;

    public static i aRL() {
        if (eRk == null) {
            synchronized (i.class) {
                if (eRk == null) {
                    eRk = new i();
                }
            }
        }
        return eRk;
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
                    i.aRL().eRl.removeMessages(1);
                    i.aRL().execute();
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
                        i.this.eRl.sendMessageDelayed(i.this.eRl.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eRl.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eRm != null) {
            this.eRm.cancel();
            this.eRm = null;
        }
        this.eRm = new b();
        this.eRm.setParallel(TiebaIMConfig.getParallel());
        this.eRm.setPriority(4);
        this.eRm.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eRm != null) {
            this.eRm.cancel();
            this.eRm = null;
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
            LinkedList<ImMessageCenterPojo> aRP = j.aRM().aRP();
            if (aRP == null || aRP.size() == 0) {
                return false;
            }
            if (i.eRn < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eRn = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eRn > 2147483648L) {
                        int unused2 = i.eRo = UIMsg.m_AppUI.MSG_APP_GPS;
                    } else if (i.eRn > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eRo = 3000;
                    } else {
                        int unused4 = i.eRo = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eRo < 1000) {
                int unused5 = i.eRo = 1000;
            }
            try {
                h.aRJ().aRK();
                for (ImMessageCenterPojo imMessageCenterPojo : aRP) {
                    if (isCancelled()) {
                        h.aRJ().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aRC().an(imMessageCenterPojo.getGid(), i.eRo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aRU().an(imMessageCenterPojo.getGid(), i.eRo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aRS().an(imMessageCenterPojo.getGid(), i.eRo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aRD().an(imMessageCenterPojo.getGid(), i.eRo);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aRJ().endTransaction();
            }
            return true;
        }
    }
}
