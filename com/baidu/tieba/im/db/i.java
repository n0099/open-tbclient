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
    private static i dWu;
    private static long dWx = -1;
    private static int dWy = 0;
    private a dWv = new a();
    private b dWw = null;

    public static i aDh() {
        if (dWu == null) {
            synchronized (i.class) {
                if (dWu == null) {
                    dWu = new i();
                }
            }
        }
        return dWu;
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
                    i.aDh().dWv.removeMessages(1);
                    i.aDh().execute();
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
                        i.this.dWv.sendMessageDelayed(i.this.dWv.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.dWv.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dWw != null) {
            this.dWw.cancel();
            this.dWw = null;
        }
        this.dWw = new b();
        this.dWw.setParallel(TiebaIMConfig.getParallel());
        this.dWw.setPriority(4);
        this.dWw.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dWw != null) {
            this.dWw.cancel();
            this.dWw = null;
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
            LinkedList<ImMessageCenterPojo> aDl = j.aDi().aDl();
            if (aDl == null || aDl.size() == 0) {
                return false;
            }
            if (i.dWx < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.dWx = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.dWx > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.dWy = 5000;
                    } else if (i.dWx > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.dWy = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = i.dWy = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.dWy < 1000) {
                int unused5 = i.dWy = 1000;
            }
            try {
                h.aDf().aDg();
                for (ImMessageCenterPojo imMessageCenterPojo : aDl) {
                    if (isCancelled()) {
                        h.aDf().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aCY().ae(imMessageCenterPojo.getGid(), i.dWy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aDq().ae(imMessageCenterPojo.getGid(), i.dWy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aDo().ae(imMessageCenterPojo.getGid(), i.dWy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aCZ().ae(imMessageCenterPojo.getGid(), i.dWy);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aDf().endTransaction();
            }
            return true;
        }
    }
}
