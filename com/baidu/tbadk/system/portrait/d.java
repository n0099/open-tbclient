package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDF = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aDF.aDx;
        if (arrayList != null) {
            arrayList2 = this.aDF.aDx;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aDF.aDx;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aDF.aDx;
                    if (arrayList4.get(i) != null) {
                        this.aDF.aDy = i;
                        this.aDF.bN(true);
                        hVar = this.aDF.aDw;
                        hVar.fl(i);
                        hVar2 = this.aDF.aDw;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
