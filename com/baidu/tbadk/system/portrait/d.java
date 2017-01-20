package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCV = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aCV.aCN;
        if (arrayList != null) {
            arrayList2 = this.aCV.aCN;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aCV.aCN;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aCV.aCN;
                    if (arrayList4.get(i) != null) {
                        this.aCV.aCO = i;
                        this.aCV.ca(true);
                        hVar = this.aCV.aCM;
                        hVar.fl(i);
                        hVar2 = this.aCV.aCM;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
