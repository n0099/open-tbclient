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
    private static i jmr;
    private static long jmu = -1;
    private static int jmv = 0;
    private a jms = new a();
    private b jmt = null;

    public static i cEh() {
        if (jmr == null) {
            synchronized (i.class) {
                if (jmr == null) {
                    jmr = new i();
                }
            }
        }
        return jmr;
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
                    i.cEh().jms.removeMessages(1);
                    i.cEh().execute();
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
                        i.this.jms.sendMessageDelayed(i.this.jms.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.jms.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.jmt != null) {
            this.jmt.cancel();
            this.jmt = null;
        }
        this.jmt = new b();
        this.jmt.setParallel(TiebaIMConfig.getParallel());
        this.jmt.setPriority(4);
        this.jmt.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.jmt != null) {
            this.jmt.cancel();
            this.jmt = null;
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
            LinkedList<ImMessageCenterPojo> cEl = j.cEi().cEl();
            if (cEl == null || cEl.size() == 0) {
                return false;
            }
            if (i.jmu < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.jmu = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.jmu > 2147483648L) {
                        int unused2 = i.jmv = 5000;
                    } else if (i.jmu > 1073741824) {
                        int unused3 = i.jmv = 3000;
                    } else {
                        int unused4 = i.jmv = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.jmv < 1000) {
                int unused5 = i.jmv = 1000;
            }
            try {
                h.cEe().cEf();
                for (ImMessageCenterPojo imMessageCenterPojo : cEl) {
                    if (isCancelled()) {
                        h.cEe().cEg();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cDX().aW(imMessageCenterPojo.getGid(), i.jmv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cEr().aW(imMessageCenterPojo.getGid(), i.jmv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cEo().aW(imMessageCenterPojo.getGid(), i.jmv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cDY().aW(imMessageCenterPojo.getGid(), i.jmv);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cEe().cEg();
            }
            return true;
        }
    }
}
