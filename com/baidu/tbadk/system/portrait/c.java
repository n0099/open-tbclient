package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAF = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aAF.aAz;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aAF;
            arrayList = this.aAF.aAy;
            i2 = this.aAF.aAz;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
