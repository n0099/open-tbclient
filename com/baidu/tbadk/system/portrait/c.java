package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEM = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.aEM.aEF;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.aEM;
            arrayList = this.aEM.aEE;
            i2 = this.aEM.aEF;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
