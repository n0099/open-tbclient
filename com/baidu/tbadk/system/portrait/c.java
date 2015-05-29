package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.arP.arK;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.arP;
            arrayList = this.arP.arJ;
            i2 = this.arP.arK;
            changeSystemPhotoActivity.a((k) arrayList.get(i2));
        }
    }
}
