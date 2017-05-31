package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIA = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aIA.aIt;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aIA;
            arrayList = this.aIA.aIs;
            i2 = this.aIA.aIt;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
