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
    private static i hyn;
    private static long hyq = -1;
    private static int hyr = 0;
    private a hyo = new a();
    private b hyp = null;

    public static i bUw() {
        if (hyn == null) {
            synchronized (i.class) {
                if (hyn == null) {
                    hyn = new i();
                }
            }
        }
        return hyn;
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
                    i.bUw().hyo.removeMessages(1);
                    i.bUw().execute();
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
                        i.this.hyo.sendMessageDelayed(i.this.hyo.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.hyo.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.hyp != null) {
            this.hyp.cancel();
            this.hyp = null;
        }
        this.hyp = new b();
        this.hyp.setParallel(TiebaIMConfig.getParallel());
        this.hyp.setPriority(4);
        this.hyp.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.hyp != null) {
            this.hyp.cancel();
            this.hyp = null;
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
            LinkedList<ImMessageCenterPojo> bUA = j.bUx().bUA();
            if (bUA == null || bUA.size() == 0) {
                return false;
            }
            if (i.hyq < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.hyq = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.hyq > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.hyr = 5000;
                    } else if (i.hyq > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.hyr = 3000;
                    } else {
                        int unused4 = i.hyr = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.hyr < 1000) {
                int unused5 = i.hyr = 1000;
            }
            try {
                h.bUt().bUu();
                for (ImMessageCenterPojo imMessageCenterPojo : bUA) {
                    if (isCancelled()) {
                        h.bUt().bUv();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bUm().aK(imMessageCenterPojo.getGid(), i.hyr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bUF().aK(imMessageCenterPojo.getGid(), i.hyr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bUD().aK(imMessageCenterPojo.getGid(), i.hyr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bUn().aK(imMessageCenterPojo.getGid(), i.hyr);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bUt().bUv();
            }
            return true;
        }
    }
}
