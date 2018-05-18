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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static long dXB = -1;
    private static int dXC = 0;
    private static i dXy;
    private a dXz = new a();
    private b dXA = null;

    public static i aDf() {
        if (dXy == null) {
            synchronized (i.class) {
                if (dXy == null) {
                    dXy = new i();
                }
            }
        }
        return dXy;
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
                    i.aDf().dXz.removeMessages(1);
                    i.aDf().execute();
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
                        i.this.dXz.sendMessageDelayed(i.this.dXz.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.dXz.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dXA != null) {
            this.dXA.cancel();
            this.dXA = null;
        }
        this.dXA = new b();
        this.dXA.setParallel(TiebaIMConfig.getParallel());
        this.dXA.setPriority(4);
        this.dXA.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dXA != null) {
            this.dXA.cancel();
            this.dXA = null;
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
            LinkedList<ImMessageCenterPojo> aDj = j.aDg().aDj();
            if (aDj == null || aDj.size() == 0) {
                return false;
            }
            if (i.dXB < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.dXB = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.dXB > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.dXC = 5000;
                    } else if (i.dXB > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.dXC = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = i.dXC = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.dXC < 1000) {
                int unused5 = i.dXC = 1000;
            }
            try {
                h.aDd().aDe();
                for (ImMessageCenterPojo imMessageCenterPojo : aDj) {
                    if (isCancelled()) {
                        h.aDd().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aCW().ae(imMessageCenterPojo.getGid(), i.dXC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aDo().ae(imMessageCenterPojo.getGid(), i.dXC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aDm().ae(imMessageCenterPojo.getGid(), i.dXC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aCX().ae(imMessageCenterPojo.getGid(), i.dXC);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aDd().endTransaction();
            }
            return true;
        }
    }
}
