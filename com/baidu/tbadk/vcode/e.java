package com.baidu.tbadk.vcode;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CommonVcodeActivity aAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonVcodeActivity commonVcodeActivity) {
        this.aAJ = commonVcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aAJ.finish();
    }
}
