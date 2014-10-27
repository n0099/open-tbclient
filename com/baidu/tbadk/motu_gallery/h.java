package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity Wv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wv = jigsawAlbumActivity;
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
        jVar = this.Wv.Wg;
        int i2 = jVar.Wx.get(i).type;
        uVar = this.Wv.Wi;
        uVar.removeAll();
        arrayList = this.Wv.We;
        if (i2 < arrayList.size()) {
            arrayList2 = this.Wv.Wd;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.type == i2) {
                    uVar3 = this.Wv.Wi;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.Wv.Wg;
            String str = jVar2.Wx.get(i).path;
            arrayList3 = this.Wv.We;
            String substring = str.substring(((c) arrayList3.get(i)).path.lastIndexOf("/") + 1);
            uVar2 = this.Wv.Wi;
            uVar2.dK(substring);
        }
        z = this.Wv.Wq;
        if (!z) {
            this.Wv.startActivityForResult(new Intent(this.Wv, JigsawAlbumListActivity.class), 10);
            this.Wv.Wq = true;
        }
    }
}
