package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAk = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aAk.aAd;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aAk;
            arrayList = this.aAk.aAc;
            i2 = this.aAk.aAd;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
