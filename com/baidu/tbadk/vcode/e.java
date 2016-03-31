package com.baidu.tbadk.vcode;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aEz.finish();
    }
}
