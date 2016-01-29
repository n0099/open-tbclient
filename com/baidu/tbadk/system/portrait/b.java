package com.baidu.tbadk.system.portrait;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCH = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        i = this.aCH.aCA;
        if (i != -1) {
            this.aCH.Gp();
            return;
        }
        this.aCH.setResult(0);
        this.aCH.finish();
    }
}
