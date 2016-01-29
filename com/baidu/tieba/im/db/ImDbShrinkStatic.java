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
    private static ImDbShrinkStatic bUe;
    private static long bUh = -1;
    private static int bUi = 0;
    private a bUf = new a(null);
    private b bUg = null;

    static {
        aaZ();
    }

    public static ImDbShrinkStatic aaZ() {
        if (bUe == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bUe == null) {
                    bUe = new ImDbShrinkStatic();
                }
            }
        }
        return bUe;
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
                    ImDbShrinkStatic.aaZ().bUf.removeMessages(1);
                    ImDbShrinkStatic.aaZ().execute();
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
        if (this.bUg != null) {
            this.bUg.cancel();
            this.bUg = null;
        }
        this.bUg = new b(this, null);
        this.bUg.setParallel(TiebaIMConfig.getParallel());
        this.bUg.setPriority(4);
        this.bUg.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bUg != null) {
            this.bUg.cancel();
            this.bUg = null;
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
            LinkedList<ImMessageCenterPojo> abf = i.abc().abf();
            if (abf == null || abf.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bUh < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bUh = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bUh > 2147483648L) {
                        ImDbShrinkStatic.bUi = 5000;
                    } else if (ImDbShrinkStatic.bUh > 1073741824) {
                        ImDbShrinkStatic.bUi = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bUi = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bUi < 1000) {
                ImDbShrinkStatic.bUi = 1000;
            }
            try {
                g.aaX().aaY();
                for (ImMessageCenterPojo imMessageCenterPojo : abf) {
                    if (isCancelled()) {
                        g.aaX().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aaT().H(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bUi);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.abi().H(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bUi);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.abh().H(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bUi);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aaU().H(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bUi);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aaX().endTransaction();
            }
            return true;
        }
    }
}
