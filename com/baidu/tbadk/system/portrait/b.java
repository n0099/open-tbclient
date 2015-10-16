package com.baidu.tbadk.system.portrait;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azr = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.azr.azl;
        if (i != -1) {
            this.azr.showDialog();
            return;
        }
        this.azr.setResult(0);
        this.azr.finish();
    }
}
