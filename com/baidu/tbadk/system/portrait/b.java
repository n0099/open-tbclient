package com.baidu.tbadk.system.portrait;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.arP.arK;
        if (i != -1) {
            this.arP.showDialog();
            return;
        }
        this.arP.setResult(0);
        this.arP.finish();
    }
}
