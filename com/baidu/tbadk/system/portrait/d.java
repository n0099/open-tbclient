package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azJ = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.azJ.azB;
        if (arrayList != null) {
            arrayList2 = this.azJ.azB;
            if (arrayList2.size() > 0) {
                arrayList3 = this.azJ.azB;
                if (arrayList3.size() > i) {
                    arrayList4 = this.azJ.azB;
                    if (arrayList4.get(i) != null) {
                        this.azJ.azC = i;
                        this.azJ.bT(true);
                        hVar = this.azJ.azA;
                        hVar.eQ(i);
                        hVar2 = this.azJ.azA;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
