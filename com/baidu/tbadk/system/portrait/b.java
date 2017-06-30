package com.baidu.tbadk.system.portrait;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aJP = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.aJP.aJI;
        if (i != -1) {
            this.aJP.showDialog();
            return;
        }
        this.aJP.setResult(0);
        this.aJP.finish();
    }
}
