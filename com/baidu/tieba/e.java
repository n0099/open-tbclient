package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ AutoSkinActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AutoSkinActivity autoSkinActivity) {
        this.a = autoSkinActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b();
    }
}
