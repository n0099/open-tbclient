package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIs = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aIs.aIl;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aIs;
            arrayList = this.aIs.aIk;
            i2 = this.aIs.aIl;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
