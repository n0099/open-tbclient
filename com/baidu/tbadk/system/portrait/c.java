package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azr = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.azr.azl;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.azr;
            arrayList = this.azr.azk;
            i2 = this.azr.azl;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
