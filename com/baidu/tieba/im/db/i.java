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
    private static i hxZ;
    private static long hyc = -1;
    private static int hyd = 0;
    private a hya = new a();
    private b hyb = null;

    public static i bUt() {
        if (hxZ == null) {
            synchronized (i.class) {
                if (hxZ == null) {
                    hxZ = new i();
                }
            }
        }
        return hxZ;
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
                    i.bUt().hya.removeMessages(1);
                    i.bUt().execute();
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
                        i.this.hya.sendMessageDelayed(i.this.hya.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.hya.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.hyb != null) {
            this.hyb.cancel();
            this.hyb = null;
        }
        this.hyb = new b();
        this.hyb.setParallel(TiebaIMConfig.getParallel());
        this.hyb.setPriority(4);
        this.hyb.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.hyb != null) {
            this.hyb.cancel();
            this.hyb = null;
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
            LinkedList<ImMessageCenterPojo> bUx = j.bUu().bUx();
            if (bUx == null || bUx.size() == 0) {
                return false;
            }
            if (i.hyc < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.hyc = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.hyc > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.hyd = 5000;
                    } else if (i.hyc > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.hyd = 3000;
                    } else {
                        int unused4 = i.hyd = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.hyd < 1000) {
                int unused5 = i.hyd = 1000;
            }
            try {
                h.bUq().bUr();
                for (ImMessageCenterPojo imMessageCenterPojo : bUx) {
                    if (isCancelled()) {
                        h.bUq().bUs();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bUj().aK(imMessageCenterPojo.getGid(), i.hyd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bUC().aK(imMessageCenterPojo.getGid(), i.hyd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bUA().aK(imMessageCenterPojo.getGid(), i.hyd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bUk().aK(imMessageCenterPojo.getGid(), i.hyd);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bUq().bUs();
            }
            return true;
        }
    }
}
