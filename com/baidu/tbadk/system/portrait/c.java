package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIN = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aIN.aIG;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aIN;
            arrayList = this.aIN.aIF;
            i2 = this.aIN.aIG;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
