package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCH = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aCH.aCz;
        if (arrayList != null) {
            arrayList2 = this.aCH.aCz;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aCH.aCz;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aCH.aCz;
                    if (arrayList4.get(i) != null) {
                        this.aCH.aCA = i;
                        this.aCH.bF(true);
                        hVar = this.aCH.aCy;
                        hVar.fe(i);
                        hVar2 = this.aCH.aCy;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
