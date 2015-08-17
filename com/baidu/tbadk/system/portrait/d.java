package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChangeSystemPhotoActivity ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayX = changeSystemPhotoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        h hVar;
        h hVar2;
        arrayList = this.ayX.ayQ;
        if (arrayList != null) {
            arrayList2 = this.ayX.ayQ;
            if (arrayList2.size() > 0) {
                arrayList3 = this.ayX.ayQ;
                if (arrayList3.size() > i) {
                    arrayList4 = this.ayX.ayQ;
                    if (arrayList4.get(i) != null) {
                        this.ayX.ayR = i;
                        this.ayX.bn(true);
                        hVar = this.ayX.ayP;
                        hVar.eu(i);
                        hVar2 = this.ayX.ayP;
                        hVar2.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
