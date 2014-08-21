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
    final /* synthetic */ ImDbShrinkStatic a;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.a = imDbShrinkStatic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImDbShrinkStatic imDbShrinkStatic, j jVar) {
        this(imDbShrinkStatic);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        LinkedList<ImMessageCenterPojo> c = k.a().c();
        if (c == null || c.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.d;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.d = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.d;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.e = 5000;
                } else {
                    j3 = ImDbShrinkStatic.d;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.e = 3000;
                    } else {
                        ImDbShrinkStatic.e = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.e;
        if (i < 1000) {
            ImDbShrinkStatic.e = 1000;
        }
        try {
            g.a().b();
            for (ImMessageCenterPojo imMessageCenterPojo : c) {
                if (isCancelled()) {
                    g.a().c();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c a = c.a();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.e;
                    a.a(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    o c2 = o.c();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.e;
                    c2.a(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    n c3 = n.c();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.e;
                    c3.a(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d a2 = d.a();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.e;
                    a2.c(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.a().c();
        }
        return true;
    }
}
