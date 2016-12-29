package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEf = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aEf.aDY;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aEf;
            arrayList = this.aEf.aDX;
            i2 = this.aEf.aDY;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
