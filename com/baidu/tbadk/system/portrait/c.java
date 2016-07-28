package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBr = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aBr.aBk;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aBr;
            arrayList = this.aBr.aBj;
            i2 = this.aBr.aBk;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
