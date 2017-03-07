package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIs = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aIs.aIk;
        if (arrayList != null) {
            arrayList2 = this.aIs.aIk;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aIs.aIk;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aIs.aIk;
                    if (arrayList4.get(i) != null) {
                        this.aIs.aIl = i;
                        this.aIs.bZ(true);
                        hVar = this.aIs.aIj;
                        hVar.ff(i);
                        hVar2 = this.aIs.aIj;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
