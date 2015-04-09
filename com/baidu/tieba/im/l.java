package com.baidu.tieba.im;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class l {
    private static final BdUniqueId aWn = BdUniqueId.gen();

    public static <T> void a(h<T> hVar, g<T> gVar) {
        if (hVar != null) {
            m mVar = new m(hVar, gVar);
            mVar.setParallel(TiebaIMConfig.getParallel());
            mVar.setTag(aWn);
            mVar.setPriority(4);
            mVar.execute(new String[0]);
        }
    }

    public static void NC() {
        BdAsyncTask.removeAllTask(aWn);
    }
}
