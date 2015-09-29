package com.baidu.tbadk.system.portrait;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azg = changeSystemPhotoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ArrayList arrayList;
        int i2;
        i = this.azg.aza;
        if (i != -1) {
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.azg;
            arrayList = this.azg.ayZ;
            i2 = this.azg.aza;
            changeSystemPhotoActivity.a((i) arrayList.get(i2));
        }
    }
}
