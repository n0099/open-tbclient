package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDF = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aDF.aDy;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aDF;
            arrayList = this.aDF.aDx;
            i2 = this.aDF.aDy;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
