package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azg = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.azg.ayZ;
        if (arrayList != null) {
            arrayList2 = this.azg.ayZ;
            if (arrayList2.size() > 0) {
                arrayList3 = this.azg.ayZ;
                if (arrayList3.size() > i) {
                    arrayList4 = this.azg.ayZ;
                    if (arrayList4.get(i) != null) {
                        this.azg.aza = i;
                        this.azg.bs(true);
                        hVar = this.azg.ayY;
                        hVar.eD(i);
                        hVar2 = this.azg.ayY;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
