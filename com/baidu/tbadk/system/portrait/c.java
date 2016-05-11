package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azJ = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.azJ.azC;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.azJ;
            arrayList = this.azJ.azB;
            i2 = this.azJ.azC;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
