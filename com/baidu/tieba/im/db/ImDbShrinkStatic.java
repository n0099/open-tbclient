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
    private static ImDbShrinkStatic bwI;
    private static long bwL = -1;
    private static int bwM = 0;
    private a bwJ = new a(null);
    private b bwK = null;

    static {
        TL();
    }

    public static ImDbShrinkStatic TL() {
        if (bwI == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bwI == null) {
                    bwI = new ImDbShrinkStatic();
                }
            }
        }
        return bwI;
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
                    ImDbShrinkStatic.TL().bwJ.removeMessages(1);
                    ImDbShrinkStatic.TL().execute();
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
        if (this.bwK != null) {
            this.bwK.cancel();
            this.bwK = null;
        }
        this.bwK = new b(this, null);
        this.bwK.setParallel(TiebaIMConfig.getParallel());
        this.bwK.setPriority(4);
        this.bwK.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bwK != null) {
            this.bwK.cancel();
            this.bwK = null;
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
            LinkedList<ImMessageCenterPojo> TR = i.TO().TR();
            if (TR == null || TR.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bwL < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bwL = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bwL > 2147483648L) {
                        ImDbShrinkStatic.bwM = 5000;
                    } else if (ImDbShrinkStatic.bwL > 1073741824) {
                        ImDbShrinkStatic.bwM = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bwM = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bwM < 1000) {
                ImDbShrinkStatic.bwM = 1000;
            }
            try {
                g.TJ().TK();
                for (ImMessageCenterPojo imMessageCenterPojo : TR) {
                    if (isCancelled()) {
                        g.TJ().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.TF().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwM);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.TU().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwM);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.TT().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwM);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.TG().B(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bwM);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.TJ().endTransaction();
            }
            return true;
        }
    }
}
