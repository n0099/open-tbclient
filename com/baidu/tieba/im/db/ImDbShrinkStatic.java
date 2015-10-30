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
    private static ImDbShrinkStatic bwT;
    private static long bwW = -1;
    private static int bwX = 0;
    private a bwU = new a(null);
    private b bwV = null;

    static {
        TH();
    }

    public static ImDbShrinkStatic TH() {
        if (bwT == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bwT == null) {
                    bwT = new ImDbShrinkStatic();
                }
            }
        }
        return bwT;
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
                    ImDbShrinkStatic.TH().bwU.removeMessages(1);
                    ImDbShrinkStatic.TH().execute();
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
        if (this.bwV != null) {
            this.bwV.cancel();
            this.bwV = null;
        }
        this.bwV = new b(this, null);
        this.bwV.setParallel(TiebaIMConfig.getParallel());
        this.bwV.setPriority(4);
        this.bwV.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bwV != null) {
            this.bwV.cancel();
            this.bwV = null;
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
            LinkedList<ImMessageCenterPojo> TN = i.TK().TN();
            if (TN == null || TN.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bwW < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bwW = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bwW > 2147483648L) {
                        ImDbShrinkStatic.bwX = 5000;
                    } else if (ImDbShrinkStatic.bwW > 1073741824) {
                        ImDbShrinkStatic.bwX = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bwX = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bwX < 1000) {
                ImDbShrinkStatic.bwX = 1000;
            }
            try {
                g.TF().TG();
                for (ImMessageCenterPojo imMessageCenterPojo : TN) {
                    if (isCancelled()) {
                        g.TF().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.TB().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.TQ().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.TP().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwX);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.TC().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwX);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.TF().endTransaction();
            }
            return true;
        }
    }
}
