package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEy = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aEy.aEq;
        if (arrayList != null) {
            arrayList2 = this.aEy.aEq;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aEy.aEq;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aEy.aEq;
                    if (arrayList4.get(i) != null) {
                        this.aEy.aEr = i;
                        this.aEy.bX(true);
                        hVar = this.aEy.aEp;
                        hVar.fi(i);
                        hVar2 = this.aEy.aEp;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
