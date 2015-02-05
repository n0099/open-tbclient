package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity acZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acZ = jigsawAlbumActivity;
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
        jVar = this.acZ.acK;
        int i2 = jVar.mList.get(i).type;
        uVar = this.acZ.acM;
        uVar.removeAll();
        arrayList = this.acZ.acI;
        if (i2 < arrayList.size()) {
            arrayList2 = this.acZ.acH;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.type == i2) {
                    uVar3 = this.acZ.acM;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.acZ.acK;
            String str = jVar2.mList.get(i).path;
            arrayList3 = this.acZ.acI;
            String substring = str.substring(((c) arrayList3.get(i)).path.lastIndexOf("/") + 1);
            uVar2 = this.acZ.acM;
            uVar2.eu(substring);
        }
        z = this.acZ.acU;
        if (!z) {
            this.acZ.startActivityForResult(new Intent(this.acZ.getPageContext().getPageActivity(), JigsawAlbumListActivity.class), 10);
            this.acZ.acU = true;
        }
    }
}
