package com.baidu.tieba.home;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aMq;
    private final /* synthetic */ String axu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aMq = createBarGuideActivity;
        this.axu = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CreateBarActivity.b(this.aMq, this.axu, true);
        this.aMq.finish();
    }
}
