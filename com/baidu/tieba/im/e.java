package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class e {
    private static final BdUniqueId aNe = BdUniqueId.gen();

    public static <T> void a(b<T> bVar, a<T> aVar) {
        if (bVar != null) {
            f fVar = new f(bVar, aVar);
            fVar.setParallel(TiebaIMConfig.getParallel());
            fVar.setTag(aNe);
            fVar.setPriority(4);
            fVar.execute(new String[0]);
        }
    }

    public static void Jk() {
        BdAsyncTask.removeAllTask(aNe);
    }
}
