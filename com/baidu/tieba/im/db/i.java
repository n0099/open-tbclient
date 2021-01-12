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
    private static i kwN;
    private static long kwQ = -1;
    private static int kwR = 0;
    private a kwO = new a();
    private b kwP = null;

    public static i cTE() {
        if (kwN == null) {
            synchronized (i.class) {
                if (kwN == null) {
                    kwN = new i();
                }
            }
        }
        return kwN;
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
                    i.cTE().kwO.removeMessages(1);
                    i.cTE().execute();
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
                        i.this.kwO.sendMessageDelayed(i.this.kwO.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kwO.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kwP != null) {
            this.kwP.cancel();
            this.kwP = null;
        }
        this.kwP = new b();
        this.kwP.setParallel(TiebaIMConfig.getParallel());
        this.kwP.setPriority(4);
        this.kwP.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kwP != null) {
            this.kwP.cancel();
            this.kwP = null;
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
            LinkedList<ImMessageCenterPojo> cTI = j.cTF().cTI();
            if (cTI == null || cTI.size() == 0) {
                return false;
            }
            if (i.kwQ < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kwQ = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kwQ > KsMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.kwR = 5000;
                    } else if (i.kwQ > KsMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.kwR = 3000;
                    } else {
                        int unused4 = i.kwR = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kwR < 1000) {
                int unused5 = i.kwR = 1000;
            }
            try {
                h.cTB().cTC();
                for (ImMessageCenterPojo imMessageCenterPojo : cTI) {
                    if (isCancelled()) {
                        h.cTB().cTD();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cTu().bh(imMessageCenterPojo.getGid(), i.kwR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cTO().bh(imMessageCenterPojo.getGid(), i.kwR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cTL().bh(imMessageCenterPojo.getGid(), i.kwR);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cTv().bh(imMessageCenterPojo.getGid(), i.kwR);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cTB().cTD();
            }
            return true;
        }
    }
}
