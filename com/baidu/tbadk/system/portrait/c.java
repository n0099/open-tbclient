package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAB = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aAB.aAu;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aAB;
            arrayList = this.aAB.aAt;
            i2 = this.aAB.aAu;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
