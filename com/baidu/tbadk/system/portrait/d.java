package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEf = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aEf.aDX;
        if (arrayList != null) {
            arrayList2 = this.aEf.aDX;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aEf.aDX;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aEf.aDX;
                    if (arrayList4.get(i) != null) {
                        this.aEf.aDY = i;
                        this.aEf.ca(true);
                        hVar = this.aEf.aDW;
                        hVar.fk(i);
                        hVar2 = this.aEf.aDW;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
