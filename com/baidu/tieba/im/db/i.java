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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.kwai.video.player.KsMediaMeta;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private static i kBs;
    private static long kBv = -1;
    private static int kBw = 0;
    private a kBt = new a();
    private b kBu = null;

    public static i cXv() {
        if (kBs == null) {
            synchronized (i.class) {
                if (kBs == null) {
                    kBs = new i();
                }
            }
        }
        return kBs;
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
                    i.cXv().kBt.removeMessages(1);
                    i.cXv().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.kBt.sendMessageDelayed(i.this.kBt.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kBt.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kBu != null) {
            this.kBu.cancel();
            this.kBu = null;
        }
        this.kBu = new b();
        this.kBu.setParallel(TiebaIMConfig.getParallel());
        this.kBu.setPriority(4);
        this.kBu.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kBu != null) {
            this.kBu.cancel();
            this.kBu = null;
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
            LinkedList<ImMessageCenterPojo> cXz = j.cXw().cXz();
            if (cXz == null || cXz.size() == 0) {
                return false;
            }
            if (i.kBv < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kBv = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kBv > KsMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.kBw = 5000;
                    } else if (i.kBv > KsMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.kBw = 3000;
                    } else {
                        int unused4 = i.kBw = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kBw < 1000) {
                int unused5 = i.kBw = 1000;
            }
            try {
                h.cXs().cXt();
                for (ImMessageCenterPojo imMessageCenterPojo : cXz) {
                    if (isCancelled()) {
                        h.cXs().cXu();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cXl().bh(imMessageCenterPojo.getGid(), i.kBw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cXF().bh(imMessageCenterPojo.getGid(), i.kBw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cXC().bh(imMessageCenterPojo.getGid(), i.kBw);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cXm().bh(imMessageCenterPojo.getGid(), i.kBw);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cXs().cXu();
            }
            return true;
        }
    }
}
