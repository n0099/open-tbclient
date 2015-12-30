package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBR = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aBR.aBK;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aBR;
            arrayList = this.aBR.aBJ;
            i2 = this.aBR.aBK;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
