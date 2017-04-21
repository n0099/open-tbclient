package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIK = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aIK.aIC;
        if (arrayList != null) {
            arrayList2 = this.aIK.aIC;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aIK.aIC;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aIK.aIC;
                    if (arrayList4.get(i) != null) {
                        this.aIK.aID = i;
                        this.aIK.cb(true);
                        hVar = this.aIK.aIB;
                        hVar.fi(i);
                        hVar2 = this.aIK.aIB;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
