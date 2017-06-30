package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aJP = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aJP.aJH;
        if (arrayList != null) {
            arrayList2 = this.aJP.aJH;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aJP.aJH;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aJP.aJH;
                    if (arrayList4.get(i) != null) {
                        this.aJP.aJI = i;
                        this.aJP.cb(true);
                        hVar = this.aJP.aJG;
                        hVar.fh(i);
                        hVar2 = this.aJP.aJG;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
