package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBr = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aBr.aBj;
        if (arrayList != null) {
            arrayList2 = this.aBr.aBj;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aBr.aBj;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aBr.aBj;
                    if (arrayList4.get(i) != null) {
                        this.aBr.aBk = i;
                        this.aBr.bV(true);
                        hVar = this.aBr.aBi;
                        hVar.eU(i);
                        hVar2 = this.aBr.aBi;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
