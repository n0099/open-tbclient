package com.baidu.tieba.guide;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewGuideActivity f1133a;

    private c(NewGuideActivity newGuideActivity) {
        this.f1133a = newGuideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(NewGuideActivity newGuideActivity, c cVar) {
        this(newGuideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        return Boolean.valueOf(NewGuideActivity.a(this.f1133a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            NewGuideActivity.b(this.f1133a);
        }
    }
}
