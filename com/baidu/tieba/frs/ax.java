package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FrsActivity a;
    private final String b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(String... strArr) {
        return Boolean.valueOf(FrsActivity.h(this.a, this.b));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.a.showToast(com.baidu.tieba.a.k.shortcut_has_add);
        } else {
            FrsActivity.i(this.a, this.b);
        }
    }

    public ax(FrsActivity frsActivity, String str) {
        this.a = frsActivity;
        this.b = str;
    }
}
