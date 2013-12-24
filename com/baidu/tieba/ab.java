package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a();
        this.a.closeActivity();
    }
}
