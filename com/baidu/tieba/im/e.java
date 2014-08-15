package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.k;
/* loaded from: classes.dex */
public class e {
    private static final BdUniqueId a = BdUniqueId.gen();

    public static <T> void a(b<T> bVar, a<T> aVar) {
        if (bVar != null) {
            f fVar = new f(bVar, aVar);
            fVar.setParallel(k.b());
            fVar.setTag(a);
            fVar.setPriority(4);
            fVar.execute(new String[0]);
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(a);
    }
}
