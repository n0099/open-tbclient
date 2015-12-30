package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bQc;
    private static long bQf = -1;
    private static int bQg = 0;
    private a bQd = new a(null);
    private b bQe = null;

    static {
        Yo();
    }

    public static ImDbShrinkStatic Yo() {
        if (bQc == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bQc == null) {
                    bQc = new ImDbShrinkStatic();
                }
            }
        }
        return bQc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    ImDbShrinkStatic.Yo().bQd.removeMessages(1);
                    ImDbShrinkStatic.Yo().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.bQe != null) {
            this.bQe.cancel();
            this.bQe = null;
        }
        this.bQe = new b(this, null);
        this.bQe.setParallel(TiebaIMConfig.getParallel());
        this.bQe.setPriority(4);
        this.bQe.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bQe != null) {
            this.bQe.cancel();
            this.bQe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* synthetic */ b(ImDbShrinkStatic imDbShrinkStatic, b bVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> Yu = i.Yr().Yu();
            if (Yu == null || Yu.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bQf < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bQf = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bQf > 2147483648L) {
                        ImDbShrinkStatic.bQg = 5000;
                    } else if (ImDbShrinkStatic.bQf > 1073741824) {
                        ImDbShrinkStatic.bQg = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bQg = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bQg < 1000) {
                ImDbShrinkStatic.bQg = 1000;
            }
            try {
                g.Ym().Yn();
                for (ImMessageCenterPojo imMessageCenterPojo : Yu) {
                    if (isCancelled()) {
                        g.Ym().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.Yi().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bQg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.Yx().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bQg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.Yw().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bQg);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.Yj().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bQg);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.Ym().endTransaction();
            }
            return true;
        }
    }
}
