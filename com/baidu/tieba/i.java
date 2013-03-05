package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.c.ai;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai.a(this.a, null, this.a.getResources().getString(R.string.share_app), null);
        this.a.a();
    }
}
