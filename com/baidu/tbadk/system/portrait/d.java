package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIN = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aIN.aIF;
        if (arrayList != null) {
            arrayList2 = this.aIN.aIF;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aIN.aIF;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aIN.aIF;
                    if (arrayList4.get(i) != null) {
                        this.aIN.aIG = i;
                        this.aIN.cc(true);
                        hVar = this.aIN.aIE;
                        hVar.fe(i);
                        hVar2 = this.aIN.aIE;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
