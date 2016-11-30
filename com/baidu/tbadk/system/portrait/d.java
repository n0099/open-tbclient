package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity aEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEM = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.aEM.aEE;
        if (arrayList != null) {
            arrayList2 = this.aEM.aEE;
            if (arrayList2.size() > 0) {
                arrayList3 = this.aEM.aEE;
                if (arrayList3.size() > i) {
                    arrayList4 = this.aEM.aEE;
                    if (arrayList4.get(i) != null) {
                        this.aEM.aEF = i;
                        this.aEM.cb(true);
                        hVar = this.aEM.aED;
                        hVar.fk(i);
                        hVar2 = this.aEM.aED;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
