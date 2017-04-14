package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aII = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aII.aIB;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aII;
            arrayList = this.aII.aIA;
            i2 = this.aII.aIB;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
