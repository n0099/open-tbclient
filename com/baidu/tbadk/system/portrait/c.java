package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayX = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.ayX.ayR;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.ayX;
            arrayList = this.ayX.ayQ;
            i2 = this.ayX.ayR;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
