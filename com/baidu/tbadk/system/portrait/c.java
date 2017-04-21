package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIK = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aIK.aID;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aIK;
            arrayList = this.aIK.aIC;
            i2 = this.aIK.aID;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
