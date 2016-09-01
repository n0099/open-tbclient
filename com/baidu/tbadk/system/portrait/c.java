package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEy = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aEy.aEr;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aEy;
            arrayList = this.aEy.aEq;
            i2 = this.aEy.aEr;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
