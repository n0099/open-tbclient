package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIA = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aIA.aIs;
        if (arrayList != null) {
            arrayList2 = this.aIA.aIs;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aIA.aIs;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aIA.aIs;
                    if (arrayList4.get(i) != null) {
                        this.aIA.aIt = i;
                        this.aIA.bZ(true);
                        hVar = this.aIA.aIr;
                        hVar.ff(i);
                        hVar2 = this.aIA.aIr;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
