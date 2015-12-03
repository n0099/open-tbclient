package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAk = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aAk.aAc;
        if (arrayList != null) {
            arrayList2 = this.aAk.aAc;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aAk.aAc;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aAk.aAc;
                    if (arrayList4.get(i) != null) {
                        this.aAk.aAd = i;
                        this.aAk.bE(true);
                        hVar = this.aAk.aAb;
                        hVar.eP(i);
                        hVar2 = this.aAk.aAb;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
