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
    private static ImDbShrinkStatic ceH;
    private static long ceK = -1;
    private static int ceL = 0;
    private a ceI = new a(null);
    private b ceJ = null;

    static {
        aev();
    }

    public static ImDbShrinkStatic aev() {
        if (ceH == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (ceH == null) {
                    ceH = new ImDbShrinkStatic();
                }
            }
        }
        return ceH;
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
                    ImDbShrinkStatic.aev().ceI.removeMessages(1);
                    ImDbShrinkStatic.aev().execute();
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
        if (this.ceJ != null) {
            this.ceJ.cancel();
            this.ceJ = null;
        }
        this.ceJ = new b(this, null);
        this.ceJ.setParallel(TiebaIMConfig.getParallel());
        this.ceJ.setPriority(4);
        this.ceJ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.ceJ != null) {
            this.ceJ.cancel();
            this.ceJ = null;
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> aeB = i.aey().aeB();
            if (aeB == null || aeB.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.ceK < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.ceK = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.ceK > 2147483648L) {
                        ImDbShrinkStatic.ceL = 5000;
                    } else if (ImDbShrinkStatic.ceK > 1073741824) {
                        ImDbShrinkStatic.ceL = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.ceL = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.ceL < 1000) {
                ImDbShrinkStatic.ceL = 1000;
            }
            try {
                g.aet().aeu();
                for (ImMessageCenterPojo imMessageCenterPojo : aeB) {
                    if (isCancelled()) {
                        g.aet().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aep().O(imMessageCenterPojo.getGid(), ImDbShrinkStatic.ceL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aeE().O(imMessageCenterPojo.getGid(), ImDbShrinkStatic.ceL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aeD().O(imMessageCenterPojo.getGid(), ImDbShrinkStatic.ceL);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aeq().O(imMessageCenterPojo.getGid(), ImDbShrinkStatic.ceL);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aet().endTransaction();
            }
            return true;
        }
    }
}
