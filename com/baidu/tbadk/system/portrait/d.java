package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        i iVar;
        i iVar2;
        arrayList = this.arP.arJ;
        if (arrayList != null) {
            arrayList2 = this.arP.arJ;
            if (arrayList2.size() > 0) {
                arrayList3 = this.arP.arJ;
                if (arrayList3.size() > i) {
                    arrayList4 = this.arP.arJ;
                    if (arrayList4.get(i) != null) {
                        this.arP.arK = i;
                        this.arP.bm(true);
                        iVar = this.arP.arI;
                        iVar.ep(i);
                        iVar2 = this.arP.arI;
                        iVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
