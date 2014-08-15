package com.baidu.tbadk.pluginArch;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class r {
    private static BdAsyncTaskParallel a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private String b;
    private Context c;
    private String d;
    private b e;

    public r(String str, String str2, b bVar) {
        this.b = str;
        this.d = str2;
        this.e = bVar;
    }

    public r(Context context, String str, b bVar) {
        this.c = context;
        this.d = str;
        this.e = bVar;
    }

    public synchronized void a() {
        s sVar = new s(this);
        sVar.setParallel(a);
        sVar.execute(new Void[0]);
    }
}
