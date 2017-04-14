package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aII = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aII.aIA;
        if (arrayList != null) {
            arrayList2 = this.aII.aIA;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aII.aIA;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aII.aIA;
                    if (arrayList4.get(i) != null) {
                        this.aII.aIB = i;
                        this.aII.cb(true);
                        hVar = this.aII.aIz;
                        hVar.fi(i);
                        hVar2 = this.aII.aIz;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
