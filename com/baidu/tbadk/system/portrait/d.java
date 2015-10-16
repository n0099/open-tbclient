package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azr = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.azr.azk;
        if (arrayList != null) {
            arrayList2 = this.azr.azk;
            if (arrayList2.size() > 0) {
                arrayList3 = this.azr.azk;
                if (arrayList3.size() > i) {
                    arrayList4 = this.azr.azk;
                    if (arrayList4.get(i) != null) {
                        this.azr.azl = i;
                        this.azr.bs(true);
                        hVar = this.azr.azj;
                        hVar.eD(i);
                        hVar2 = this.azr.azj;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
