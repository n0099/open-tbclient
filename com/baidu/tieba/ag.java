package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class ag extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1113a;

    private ag(GuideActivity guideActivity) {
        this.f1113a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(GuideActivity guideActivity, ab abVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        boolean c;
        c = this.f1113a.c();
        return Boolean.valueOf(c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f1113a.b();
        }
    }
}
