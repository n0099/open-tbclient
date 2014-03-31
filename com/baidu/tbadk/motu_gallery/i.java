package com.baidu.tbadk.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
final class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.a = dVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        w wVar;
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        k kVar2;
        ArrayList arrayList3;
        w wVar2;
        w wVar3;
        kVar = this.a.i;
        int i2 = kVar.a.get(i).a;
        wVar = this.a.k;
        wVar.c();
        arrayList = this.a.f;
        if (i2 < arrayList.size()) {
            arrayList2 = this.a.e;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.a == i2) {
                    wVar3 = this.a.k;
                    wVar3.a(cVar);
                }
            }
            kVar2 = this.a.i;
            String str = kVar2.a.get(i).b;
            arrayList3 = this.a.f;
            String substring = str.substring(((c) arrayList3.get(i)).b.lastIndexOf("/") + 1);
            wVar2 = this.a.k;
            wVar2.a(substring);
        }
        z = this.a.t;
        if (!z) {
            this.a.startActivityForResult(new Intent(this.a, n.class), 10);
            this.a.t = true;
        }
    }
}
