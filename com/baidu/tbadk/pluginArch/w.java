package com.baidu.tbadk.pluginArch;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Void, Void, ConfigInfos> {
    final /* synthetic */ u a;
    private ae b;

    private w(u uVar) {
        this.a = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(u uVar, w wVar) {
        this(uVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ConfigInfos doInBackground(Void... voidArr) {
        String str;
        str = u.a;
        this.b = new ae(str);
        this.b.a("client_version", TbConfig.getVersion());
        return ConfigInfos.parse(this.b.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ConfigInfos configInfos) {
        v vVar;
        this.a.d = false;
        this.a.b = configInfos;
        vVar = this.a.c;
        vVar.a(configInfos);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.a.d = false;
        this.b.f();
        this.b = null;
    }
}
