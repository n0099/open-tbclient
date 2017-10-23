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
    private static h dsm;
    private static long dsp = -1;
    private static int dsq = 0;
    private a dsn = new a();
    private b dso = null;

    public static h avc() {
        if (dsm == null) {
            synchronized (h.class) {
                if (dsm == null) {
                    dsm = new h();
                }
            }
        }
        return dsm;
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
                    h.avc().dsn.removeMessages(1);
                    h.avc().execute();
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
                        h.this.dsn.sendMessageDelayed(h.this.dsn.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dsn.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dso != null) {
            this.dso.cancel();
            this.dso = null;
        }
        this.dso = new b();
        this.dso.setParallel(TiebaIMConfig.getParallel());
        this.dso.setPriority(4);
        this.dso.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dso != null) {
            this.dso.cancel();
            this.dso = null;
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
            LinkedList<ImMessageCenterPojo> avh = i.ave().avh();
            if (avh == null || avh.size() == 0) {
                return false;
            }
            if (h.dsp < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dsp = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dsp > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dsq = 5000;
                    } else if (h.dsp > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dsq = 3000;
                    } else {
                        int unused4 = h.dsq = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dsq < 1000) {
                int unused5 = h.dsq = 1000;
            }
            try {
                g.ava().avb();
                for (ImMessageCenterPojo imMessageCenterPojo : avh) {
                    if (isCancelled()) {
                        g.ava().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.auW().R(imMessageCenterPojo.getGid(), h.dsq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.avk().R(imMessageCenterPojo.getGid(), h.dsq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.avj().R(imMessageCenterPojo.getGid(), h.dsq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.auX().R(imMessageCenterPojo.getGid(), h.dsq);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.ava().endTransaction();
            }
            return true;
        }
    }
}
