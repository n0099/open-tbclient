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
    private static i hzN;
    private static long hzQ = -1;
    private static int hzR = 0;
    private a hzO = new a();
    private b hzP = null;

    public static i bUO() {
        if (hzN == null) {
            synchronized (i.class) {
                if (hzN == null) {
                    hzN = new i();
                }
            }
        }
        return hzN;
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
                    i.bUO().hzO.removeMessages(1);
                    i.bUO().execute();
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
                        i.this.hzO.sendMessageDelayed(i.this.hzO.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.hzO.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.hzP != null) {
            this.hzP.cancel();
            this.hzP = null;
        }
        this.hzP = new b();
        this.hzP.setParallel(TiebaIMConfig.getParallel());
        this.hzP.setPriority(4);
        this.hzP.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.hzP != null) {
            this.hzP.cancel();
            this.hzP = null;
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
            LinkedList<ImMessageCenterPojo> bUS = j.bUP().bUS();
            if (bUS == null || bUS.size() == 0) {
                return false;
            }
            if (i.hzQ < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.hzQ = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.hzQ > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.hzR = 5000;
                    } else if (i.hzQ > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.hzR = 3000;
                    } else {
                        int unused4 = i.hzR = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.hzR < 1000) {
                int unused5 = i.hzR = 1000;
            }
            try {
                h.bUL().bUM();
                for (ImMessageCenterPojo imMessageCenterPojo : bUS) {
                    if (isCancelled()) {
                        h.bUL().bUN();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bUE().aK(imMessageCenterPojo.getGid(), i.hzR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bUX().aK(imMessageCenterPojo.getGid(), i.hzR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bUV().aK(imMessageCenterPojo.getGid(), i.hzR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bUF().aK(imMessageCenterPojo.getGid(), i.hzR);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bUL().bUN();
            }
            return true;
        }
    }
}
