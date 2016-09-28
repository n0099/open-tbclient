package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDW = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aDW.aDP;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aDW;
            arrayList = this.aDW.aDO;
            i2 = this.aDW.aDP;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
