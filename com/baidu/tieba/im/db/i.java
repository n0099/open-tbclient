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
    private static i eNH;
    private static long eNK = -1;
    private static int eNL = 0;
    private a eNI = new a();
    private b eNJ = null;

    public static i aQy() {
        if (eNH == null) {
            synchronized (i.class) {
                if (eNH == null) {
                    eNH = new i();
                }
            }
        }
        return eNH;
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
                    i.aQy().eNI.removeMessages(1);
                    i.aQy().execute();
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
                        i.this.eNI.sendMessageDelayed(i.this.eNI.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eNI.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eNJ != null) {
            this.eNJ.cancel();
            this.eNJ = null;
        }
        this.eNJ = new b();
        this.eNJ.setParallel(TiebaIMConfig.getParallel());
        this.eNJ.setPriority(4);
        this.eNJ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eNJ != null) {
            this.eNJ.cancel();
            this.eNJ = null;
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
            LinkedList<ImMessageCenterPojo> aQC = j.aQz().aQC();
            if (aQC == null || aQC.size() == 0) {
                return false;
            }
            if (i.eNK < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eNK = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eNK > 2147483648L) {
                        int unused2 = i.eNL = UIMsg.m_AppUI.MSG_APP_GPS;
                    } else if (i.eNK > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eNL = 3000;
                    } else {
                        int unused4 = i.eNL = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eNL < 1000) {
                int unused5 = i.eNL = 1000;
            }
            try {
                h.aQw().aQx();
                for (ImMessageCenterPojo imMessageCenterPojo : aQC) {
                    if (isCancelled()) {
                        h.aQw().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aQp().am(imMessageCenterPojo.getGid(), i.eNL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aQH().am(imMessageCenterPojo.getGid(), i.eNL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aQF().am(imMessageCenterPojo.getGid(), i.eNL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aQq().am(imMessageCenterPojo.getGid(), i.eNL);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aQw().endTransaction();
            }
            return true;
        }
    }
}
