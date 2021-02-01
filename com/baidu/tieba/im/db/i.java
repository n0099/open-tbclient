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
    private static i kET;
    private static long kEW = -1;
    private static int kEX = 0;
    private a kEU = new a();
    private b kEV = null;

    public static i cVC() {
        if (kET == null) {
            synchronized (i.class) {
                if (kET == null) {
                    kET = new i();
                }
            }
        }
        return kET;
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
                    i.cVC().kEU.removeMessages(1);
                    i.cVC().execute();
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
                        i.this.kEU.sendMessageDelayed(i.this.kEU.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kEU.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kEV != null) {
            this.kEV.cancel();
            this.kEV = null;
        }
        this.kEV = new b();
        this.kEV.setParallel(TiebaIMConfig.getParallel());
        this.kEV.setPriority(4);
        this.kEV.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kEV != null) {
            this.kEV.cancel();
            this.kEV = null;
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
            LinkedList<ImMessageCenterPojo> cVG = j.cVD().cVG();
            if (cVG == null || cVG.size() == 0) {
                return false;
            }
            if (i.kEW < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kEW = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kEW > KsMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.kEX = 5000;
                    } else if (i.kEW > KsMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.kEX = 3000;
                    } else {
                        int unused4 = i.kEX = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kEX < 1000) {
                int unused5 = i.kEX = 1000;
            }
            try {
                h.cVz().cVA();
                for (ImMessageCenterPojo imMessageCenterPojo : cVG) {
                    if (isCancelled()) {
                        h.cVz().cVB();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cVs().bi(imMessageCenterPojo.getGid(), i.kEX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cVM().bi(imMessageCenterPojo.getGid(), i.kEX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cVJ().bi(imMessageCenterPojo.getGid(), i.kEX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cVt().bi(imMessageCenterPojo.getGid(), i.kEX);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cVz().cVB();
            }
            return true;
        }
    }
}
