package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
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
        jVar = this.acF.acp;
        int i2 = jVar.mList.get(i).type;
        uVar = this.acF.acr;
        uVar.removeAll();
        arrayList = this.acF.acn;
        if (i2 < arrayList.size()) {
            arrayList2 = this.acF.acm;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.type == i2) {
                    uVar3 = this.acF.acr;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.acF.acp;
            String str = jVar2.mList.get(i).path;
            arrayList3 = this.acF.acn;
            String substring = str.substring(((c) arrayList3.get(i)).path.lastIndexOf("/") + 1);
            uVar2 = this.acF.acr;
            uVar2.ex(substring);
        }
        z = this.acF.acA;
        if (!z) {
            this.acF.startActivityForResult(new Intent(this.acF.getPageContext().getPageActivity(), JigsawAlbumListActivity.class), 10);
            this.acF.acA = true;
        }
    }
}
