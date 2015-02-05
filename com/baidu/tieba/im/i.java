package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class i {
    private static final BdUniqueId aQK = BdUniqueId.gen();

    public static <T> void a(h<T> hVar, g<T> gVar) {
        if (hVar != null) {
            j jVar = new j(hVar, gVar);
            jVar.setParallel(TiebaIMConfig.getParallel());
            jVar.setTag(aQK);
            jVar.setPriority(4);
            jVar.execute(new String[0]);
        }
    }

    public static void JY() {
        BdAsyncTask.removeAllTask(aQK);
    }
}
