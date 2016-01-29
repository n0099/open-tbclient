package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCH = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aCH.aCA;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aCH;
            arrayList = this.aCH.aCz;
            i2 = this.aCH.aCA;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
