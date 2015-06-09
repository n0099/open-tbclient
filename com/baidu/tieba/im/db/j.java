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
    final /* synthetic */ ImDbShrinkStatic bfo;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.bfo = imDbShrinkStatic;
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
        LinkedList<ImMessageCenterPojo> Rz = k.Rw().Rz();
        if (Rz == null || Rz.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.bfm;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.bfm = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.bfm;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.bfn = 5000;
                } else {
                    j3 = ImDbShrinkStatic.bfm;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.bfn = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bfn = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.bfn;
        if (i < 1000) {
            ImDbShrinkStatic.bfn = 1000;
        }
        try {
            g.Rr().Rs();
            for (ImMessageCenterPojo imMessageCenterPojo : Rz) {
                if (isCancelled()) {
                    g.Rr().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c Rn = c.Rn();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.bfn;
                    Rn.v(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    n RC = n.RC();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.bfn;
                    RC.v(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    m RB = m.RB();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.bfn;
                    RB.v(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d Ro = d.Ro();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.bfn;
                    Ro.v(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.Rr().endTransaction();
        }
        return true;
    }
}
