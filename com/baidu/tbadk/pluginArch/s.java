package com.baidu.tbadk.pluginArch;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class s {
    private static BdAsyncTaskParallel a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private String b;
    private Context c;
    private String d;
    private b e;

    public s(String str, String str2, b bVar) {
        this.b = str;
        this.d = str2;
        this.e = bVar;
    }

    public s(Context context, String str, b bVar) {
        this.c = context;
        this.d = str;
        this.e = bVar;
    }

    public synchronized void a() {
        t tVar = new t(this);
        tVar.setParallel(a);
        tVar.execute(new Void[0]);
    }
}
