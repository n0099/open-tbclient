package com.baidu.tieba;

import android.os.AsyncTask;
/* loaded from: classes.dex */
class i extends AsyncTask {
    final /* synthetic */ GuideActivity a;

    private i(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(GuideActivity guideActivity, i iVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(GuideActivity.d(this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.e(this.a);
        }
    }
}
