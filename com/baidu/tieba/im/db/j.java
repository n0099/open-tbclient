package com.baidu.tieba.im.db;

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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        LinkedList<ImMessageCenterPojo> c = k.a().c();
        if (c != null) {
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            } finally {
                g.a().c();
            }
            if (c.size() != 0) {
                g.a().b();
                for (ImMessageCenterPojo imMessageCenterPojo : c) {
                    if (isCancelled()) {
                        g.a().c();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.a().f(imMessageCenterPojo.getGid());
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        o.c().f(imMessageCenterPojo.getGid());
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        n.c().f(imMessageCenterPojo.getGid());
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.a().d(imMessageCenterPojo.getGid());
                    }
                }
                return true;
            }
        }
        return false;
    }
}
