package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
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
        jVar = this.a.i;
        int i2 = jVar.a.get(i).a;
        uVar = this.a.k;
        uVar.c();
        arrayList = this.a.f;
        if (i2 < arrayList.size()) {
            arrayList2 = this.a.e;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.a == i2) {
                    uVar3 = this.a.k;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.a.i;
            String str = jVar2.a.get(i).b;
            arrayList3 = this.a.f;
            String substring = str.substring(((c) arrayList3.get(i)).b.lastIndexOf("/") + 1);
            uVar2 = this.a.k;
            uVar2.a(substring);
        }
        z = this.a.t;
        if (!z) {
            this.a.startActivityForResult(new Intent(this.a, JigsawAlbumListActivity.class), 10);
            this.a.t = true;
        }
    }
}
