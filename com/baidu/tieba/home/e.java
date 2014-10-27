package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aMc;
    private final /* synthetic */ String axl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aMc = createBarGuideActivity;
        this.axl = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CreateBarActivity.b(this.aMc, this.axl, true);
        this.aMc.finish();
    }
}
