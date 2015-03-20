package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Object, Boolean> {
    final /* synthetic */ ImDbShrinkStatic bct;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.bct = imDbShrinkStatic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImDbShrinkStatic imDbShrinkStatic, j jVar) {
        this(imDbShrinkStatic);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        LinkedList<ImMessageCenterPojo> PW = k.PT().PW();
        if (PW == null || PW.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.bcr;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.bcr = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.bcr;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.bcs = 5000;
                } else {
                    j3 = ImDbShrinkStatic.bcr;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.bcs = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bcs = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.bcs;
        if (i < 1000) {
            ImDbShrinkStatic.bcs = 1000;
        }
        try {
            g.PO().PP();
            for (ImMessageCenterPojo imMessageCenterPojo : PW) {
                if (isCancelled()) {
                    g.PO().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c PK = c.PK();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.bcs;
                    PK.v(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    n PZ = n.PZ();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.bcs;
                    PZ.v(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    m PY = m.PY();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.bcs;
                    PY.v(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d PL = d.PL();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.bcs;
                    PL.v(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.PO().endTransaction();
        }
        return true;
    }
}
