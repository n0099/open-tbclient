package com.baidu.tbadk.system.portrait;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayf = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.ayf.axZ;
        if (i != -1) {
            this.ayf.showDialog();
            return;
        }
        this.ayf.setResult(0);
        this.ayf.finish();
    }
}
