package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayf = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.ayf.axY;
        if (arrayList != null) {
            arrayList2 = this.ayf.axY;
            if (arrayList2.size() > 0) {
                arrayList3 = this.ayf.axY;
                if (arrayList3.size() > i) {
                    arrayList4 = this.ayf.axY;
                    if (arrayList4.get(i) != null) {
                        this.ayf.axZ = i;
                        this.ayf.bv(true);
                        hVar = this.ayf.axX;
                        hVar.eB(i);
                        hVar2 = this.ayf.axX;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
