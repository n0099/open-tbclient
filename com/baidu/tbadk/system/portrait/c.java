package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCV = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aCV.aCO;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aCV;
            arrayList = this.aCV.aCN;
            i2 = this.aCV.aCO;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
