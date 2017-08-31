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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class h {
    private static h dvo;
    private static long dvr = -1;
    private static int dvs = 0;
    private a dvp = new a();
    private b dvq = null;

    public static h awl() {
        if (dvo == null) {
            synchronized (h.class) {
                if (dvo == null) {
                    dvo = new h();
                }
            }
        }
        return dvo;
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
                    h.awl().dvp.removeMessages(1);
                    h.awl().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private h() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        h.this.dvp.sendMessageDelayed(h.this.dvp.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dvp.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dvq != null) {
            this.dvq.cancel();
            this.dvq = null;
        }
        this.dvq = new b();
        this.dvq.setParallel(TiebaIMConfig.getParallel());
        this.dvq.setPriority(4);
        this.dvq.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dvq != null) {
            this.dvq.cancel();
            this.dvq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [179=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> awq = i.awn().awq();
            if (awq == null || awq.size() == 0) {
                return false;
            }
            if (h.dvr < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dvr = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dvr > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dvs = 5000;
                    } else if (h.dvr > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dvs = 3000;
                    } else {
                        int unused4 = h.dvs = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dvs < 1000) {
                int unused5 = h.dvs = 1000;
            }
            try {
                g.awj().awk();
                for (ImMessageCenterPojo imMessageCenterPojo : awq) {
                    if (isCancelled()) {
                        g.awj().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.awf().S(imMessageCenterPojo.getGid(), h.dvs);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.awt().S(imMessageCenterPojo.getGid(), h.dvs);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aws().S(imMessageCenterPojo.getGid(), h.dvs);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.awg().S(imMessageCenterPojo.getGid(), h.dvs);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.awj().endTransaction();
            }
            return true;
        }
    }
}
