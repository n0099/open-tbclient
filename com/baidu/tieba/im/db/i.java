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
    private static i emE;
    private static long emH = -1;
    private static int emI = 0;
    private a emF = new a();
    private b emG = null;

    public static i aIH() {
        if (emE == null) {
            synchronized (i.class) {
                if (emE == null) {
                    emE = new i();
                }
            }
        }
        return emE;
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
                    i.aIH().emF.removeMessages(1);
                    i.aIH().execute();
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
                        i.this.emF.sendMessageDelayed(i.this.emF.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.emF.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.emG != null) {
            this.emG.cancel();
            this.emG = null;
        }
        this.emG = new b();
        this.emG.setParallel(TiebaIMConfig.getParallel());
        this.emG.setPriority(4);
        this.emG.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.emG != null) {
            this.emG.cancel();
            this.emG = null;
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
            LinkedList<ImMessageCenterPojo> aIL = j.aII().aIL();
            if (aIL == null || aIL.size() == 0) {
                return false;
            }
            if (i.emH < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.emH = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.emH > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.emI = 5000;
                    } else if (i.emH > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.emI = 3000;
                    } else {
                        int unused4 = i.emI = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.emI < 1000) {
                int unused5 = i.emI = 1000;
            }
            try {
                h.aIF().aIG();
                for (ImMessageCenterPojo imMessageCenterPojo : aIL) {
                    if (isCancelled()) {
                        h.aIF().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aIy().ag(imMessageCenterPojo.getGid(), i.emI);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aIQ().ag(imMessageCenterPojo.getGid(), i.emI);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aIO().ag(imMessageCenterPojo.getGid(), i.emI);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aIz().ag(imMessageCenterPojo.getGid(), i.emI);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aIF().endTransaction();
            }
            return true;
        }
    }
}
