package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDW = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aDW.aDO;
        if (arrayList != null) {
            arrayList2 = this.aDW.aDO;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aDW.aDO;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aDW.aDO;
                    if (arrayList4.get(i) != null) {
                        this.aDW.aDP = i;
                        this.aDW.bW(true);
                        hVar = this.aDW.aDN;
                        hVar.fh(i);
                        hVar2 = this.aDW.aDN;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
