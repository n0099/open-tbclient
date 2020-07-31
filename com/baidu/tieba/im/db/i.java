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
/* loaded from: classes.dex */
public class i {
    private static i iXk;
    private static long iXn = -1;
    private static int iXo = 0;
    private a iXl = new a();
    private b iXm = null;

    public static i ctp() {
        if (iXk == null) {
            synchronized (i.class) {
                if (iXk == null) {
                    iXk = new i();
                }
            }
        }
        return iXk;
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
                    i.ctp().iXl.removeMessages(1);
                    i.ctp().execute();
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
                        i.this.iXl.sendMessageDelayed(i.this.iXl.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.iXl.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.iXm != null) {
            this.iXm.cancel();
            this.iXm = null;
        }
        this.iXm = new b();
        this.iXm.setParallel(TiebaIMConfig.getParallel());
        this.iXm.setPriority(4);
        this.iXm.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.iXm != null) {
            this.iXm.cancel();
            this.iXm = null;
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
            LinkedList<ImMessageCenterPojo> ctt = j.ctq().ctt();
            if (ctt == null || ctt.size() == 0) {
                return false;
            }
            if (i.iXn < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.iXn = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.iXn > 2147483648L) {
                        int unused2 = i.iXo = 5000;
                    } else if (i.iXn > 1073741824) {
                        int unused3 = i.iXo = 3000;
                    } else {
                        int unused4 = i.iXo = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.iXo < 1000) {
                int unused5 = i.iXo = 1000;
            }
            try {
                h.ctm().ctn();
                for (ImMessageCenterPojo imMessageCenterPojo : ctt) {
                    if (isCancelled()) {
                        h.ctm().cto();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.ctf().aT(imMessageCenterPojo.getGid(), i.iXo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.ctz().aT(imMessageCenterPojo.getGid(), i.iXo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.ctw().aT(imMessageCenterPojo.getGid(), i.iXo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.ctg().aT(imMessageCenterPojo.getGid(), i.iXo);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.ctm().cto();
            }
            return true;
        }
    }
}
