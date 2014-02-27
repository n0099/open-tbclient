package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FrsActivity a;
    private String b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(String... strArr) {
        return Boolean.valueOf(FrsActivity.g(this.a, this.b));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.a.showToast(R.string.shortcut_has_add);
        } else {
            FrsActivity.h(this.a, this.b);
        }
    }

    public aj(FrsActivity frsActivity, String str) {
        this.a = frsActivity;
        this.b = str;
    }
}
