package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBR = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aBR.aBJ;
        if (arrayList != null) {
            arrayList2 = this.aBR.aBJ;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aBR.aBJ;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aBR.aBJ;
                    if (arrayList4.get(i) != null) {
                        this.aBR.aBK = i;
                        this.aBR.bE(true);
                        hVar = this.aBR.aBI;
                        hVar.eJ(i);
                        hVar2 = this.aBR.aBI;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
