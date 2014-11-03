package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Object, Boolean> {
    final /* synthetic */ ImDbShrinkStatic aVy;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.aVy = imDbShrinkStatic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImDbShrinkStatic imDbShrinkStatic, j jVar) {
        this(imDbShrinkStatic);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        LinkedList<ImMessageCenterPojo> MM = k.MJ().MM();
        if (MM == null || MM.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.aVw;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.aVw = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.aVw;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.aVx = 5000;
                } else {
                    j3 = ImDbShrinkStatic.aVw;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.aVx = 3000;
                    } else {
                        ImDbShrinkStatic.aVx = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.aVx;
        if (i < 1000) {
            ImDbShrinkStatic.aVx = 1000;
        }
        try {
            g.ME().MF();
            for (ImMessageCenterPojo imMessageCenterPojo : MM) {
                if (isCancelled()) {
                    g.ME().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c MA = c.MA();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.aVx;
                    MA.u(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    o MU = o.MU();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.aVx;
                    MU.u(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    n MT = n.MT();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.aVx;
                    MT.u(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d MB = d.MB();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.aVx;
                    MB.u(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.ME().endTransaction();
        }
        return true;
    }
}
