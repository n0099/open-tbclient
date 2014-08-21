package com.baidu.tbadk.pluginArch;

import android.os.SystemClock;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, ConfigInfos> {
    final /* synthetic */ v a;
    private com.baidu.tbadk.core.util.ae b;

    private x(v vVar) {
        this.a = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(v vVar, x xVar) {
        this(vVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ConfigInfos doInBackground(Void... voidArr) {
        String str;
        SystemClock.sleep(1500L);
        str = v.a;
        this.b = new com.baidu.tbadk.core.util.ae(str);
        this.b.a("client_version", TbConfig.getVersion());
        return ConfigInfos.parse(this.b.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ConfigInfos configInfos) {
        w wVar;
        this.a.d = false;
        this.a.b = configInfos;
        wVar = this.a.c;
        wVar.a(configInfos);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.a.d = false;
        this.b.f();
        this.b = null;
    }
}
