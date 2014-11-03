package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wz = jigsawAlbumActivity;
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
        jVar = this.Wz.Wk;
        int i2 = jVar.WB.get(i).type;
        uVar = this.Wz.Wm;
        uVar.removeAll();
        arrayList = this.Wz.Wi;
        if (i2 < arrayList.size()) {
            arrayList2 = this.Wz.Wh;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.type == i2) {
                    uVar3 = this.Wz.Wm;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.Wz.Wk;
            String str = jVar2.WB.get(i).path;
            arrayList3 = this.Wz.Wi;
            String substring = str.substring(((c) arrayList3.get(i)).path.lastIndexOf("/") + 1);
            uVar2 = this.Wz.Wm;
            uVar2.dK(substring);
        }
        z = this.Wz.Wu;
        if (!z) {
            this.Wz.startActivityForResult(new Intent(this.Wz, JigsawAlbumListActivity.class), 10);
            this.Wz.Wu = true;
        }
    }
}
