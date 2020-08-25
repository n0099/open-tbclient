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
/* loaded from: classes2.dex */
public class i {
    private static i jmk;
    private static long jmn = -1;
    private static int jmo = 0;
    private a jml = new a();
    private b jmm = null;

    public static i cEg() {
        if (jmk == null) {
            synchronized (i.class) {
                if (jmk == null) {
                    jmk = new i();
                }
            }
        }
        return jmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    i.cEg().jml.removeMessages(1);
                    i.cEg().execute();
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
                        i.this.jml.sendMessageDelayed(i.this.jml.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.jml.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.jmm != null) {
            this.jmm.cancel();
            this.jmm = null;
        }
        this.jmm = new b();
        this.jmm.setParallel(TiebaIMConfig.getParallel());
        this.jmm.setPriority(4);
        this.jmm.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.jmm != null) {
            this.jmm.cancel();
            this.jmm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> cEk = j.cEh().cEk();
            if (cEk == null || cEk.size() == 0) {
                return false;
            }
            if (i.jmn < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.jmn = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.jmn > 2147483648L) {
                        int unused2 = i.jmo = 5000;
                    } else if (i.jmn > 1073741824) {
                        int unused3 = i.jmo = 3000;
                    } else {
                        int unused4 = i.jmo = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.jmo < 1000) {
                int unused5 = i.jmo = 1000;
            }
            try {
                h.cEd().cEe();
                for (ImMessageCenterPojo imMessageCenterPojo : cEk) {
                    if (isCancelled()) {
                        h.cEd().cEf();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cDW().aW(imMessageCenterPojo.getGid(), i.jmo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cEq().aW(imMessageCenterPojo.getGid(), i.jmo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cEn().aW(imMessageCenterPojo.getGid(), i.jmo);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cDX().aW(imMessageCenterPojo.getGid(), i.jmo);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cEd().cEf();
            }
            return true;
        }
    }
}
