package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAF = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aAF.aAy;
        if (arrayList != null) {
            arrayList2 = this.aAF.aAy;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aAF.aAy;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aAF.aAy;
                    if (arrayList4.get(i) != null) {
                        this.aAF.aAz = i;
                        this.aAF.bu(true);
                        hVar = this.aAF.aAx;
                        hVar.eC(i);
                        hVar2 = this.aAF.aAx;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
