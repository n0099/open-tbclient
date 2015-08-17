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
    private static ImDbShrinkStatic bsZ;
    private static long btc = -1;
    private static int btd = 0;
    private a bta = new a(null);
    private b btb = null;

    static {
        Tb();
    }

    public static ImDbShrinkStatic Tb() {
        if (bsZ == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bsZ == null) {
                    bsZ = new ImDbShrinkStatic();
                }
            }
        }
        return bsZ;
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
                    ImDbShrinkStatic.Tb().bta.removeMessages(1);
                    ImDbShrinkStatic.Tb().execute();
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
        if (this.btb != null) {
            this.btb.cancel();
            this.btb = null;
        }
        this.btb = new b(this, null);
        this.btb.setParallel(TiebaIMConfig.getParallel());
        this.btb.setPriority(4);
        this.btb.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.btb != null) {
            this.btb.cancel();
            this.btb = null;
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
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> Th = i.Te().Th();
            if (Th == null || Th.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.btc < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.btc = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.btc > 2147483648L) {
                        ImDbShrinkStatic.btd = 5000;
                    } else if (ImDbShrinkStatic.btc > 1073741824) {
                        ImDbShrinkStatic.btd = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.btd = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.btd < 1000) {
                ImDbShrinkStatic.btd = 1000;
            }
            try {
                g.SZ().Ta();
                for (ImMessageCenterPojo imMessageCenterPojo : Th) {
                    if (isCancelled()) {
                        g.SZ().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.SV().y(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.Tk().y(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.Tj().y(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btd);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.SW().y(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btd);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.SZ().endTransaction();
            }
            return true;
        }
    }
}
