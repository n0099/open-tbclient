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
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static long hsA = -1;
    private static int hsB = 0;
    private static i hsx;
    private a hsy = new a();
    private b hsz = null;

    public static i bRJ() {
        if (hsx == null) {
            synchronized (i.class) {
                if (hsx == null) {
                    hsx = new i();
                }
            }
        }
        return hsx;
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
                    i.bRJ().hsy.removeMessages(1);
                    i.bRJ().execute();
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
                        i.this.hsy.sendMessageDelayed(i.this.hsy.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.hsy.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.hsz != null) {
            this.hsz.cancel();
            this.hsz = null;
        }
        this.hsz = new b();
        this.hsz.setParallel(TiebaIMConfig.getParallel());
        this.hsz.setPriority(4);
        this.hsz.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.hsz != null) {
            this.hsz.cancel();
            this.hsz = null;
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
            LinkedList<ImMessageCenterPojo> bRN = j.bRK().bRN();
            if (bRN == null || bRN.size() == 0) {
                return false;
            }
            if (i.hsA < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.hsA = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.hsA > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.hsB = 5000;
                    } else if (i.hsA > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.hsB = 3000;
                    } else {
                        int unused4 = i.hsB = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.hsB < 1000) {
                int unused5 = i.hsB = 1000;
            }
            try {
                h.bRG().bRH();
                for (ImMessageCenterPojo imMessageCenterPojo : bRN) {
                    if (isCancelled()) {
                        h.bRG().bRI();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bRz().aL(imMessageCenterPojo.getGid(), i.hsB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bRS().aL(imMessageCenterPojo.getGid(), i.hsB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bRQ().aL(imMessageCenterPojo.getGid(), i.hsB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bRA().aL(imMessageCenterPojo.getGid(), i.hsB);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bRG().bRI();
            }
            return true;
        }
    }
}
