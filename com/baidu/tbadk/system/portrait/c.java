package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayf = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.ayf.axZ;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.ayf;
            arrayList = this.ayf.axY;
            i2 = this.ayf.axZ;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
