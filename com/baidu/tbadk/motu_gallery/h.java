package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity adc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.adc = jigsawAlbumActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        u uVar;
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        j jVar2;
        ArrayList arrayList3;
        u uVar2;
        u uVar3;
        jVar = this.adc.acN;
        int i2 = jVar.mList.get(i).type;
        uVar = this.adc.acP;
        uVar.removeAll();
        arrayList = this.adc.acL;
        if (i2 < arrayList.size()) {
            arrayList2 = this.adc.acK;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.type == i2) {
                    uVar3 = this.adc.acP;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.adc.acN;
            String str = jVar2.mList.get(i).path;
            arrayList3 = this.adc.acL;
            String substring = str.substring(((c) arrayList3.get(i)).path.lastIndexOf("/") + 1);
            uVar2 = this.adc.acP;
            uVar2.ex(substring);
        }
        z = this.adc.acX;
        if (!z) {
            this.adc.startActivityForResult(new Intent(this.adc.getPageContext().getPageActivity(), JigsawAlbumListActivity.class), 10);
            this.adc.acX = true;
        }
    }
}
