package com.baidu.tieba.album;

import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdListView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
final class n implements o {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.album.o
    public final void a(List<a> list) {
        j jVar;
        p pVar;
        p pVar2;
        p pVar3;
        BdListView bdListView;
        LinearLayout linearLayout;
        BdListView bdListView2;
        LinearLayout linearLayout2;
        a aVar;
        a aVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        jVar = this.a.f;
        List<a> a = jVar.a();
        pVar = this.a.i;
        if (pVar == null) {
            albumActivity = this.a.g;
            if (albumActivity != null) {
                m mVar = this.a;
                albumActivity2 = this.a.g;
                mVar.i = albumActivity2.f();
            }
        }
        pVar2 = this.a.i;
        if (pVar2 != null) {
            pVar3 = this.a.i;
            String e = pVar3.e();
            if (e != null) {
                if (a != null) {
                    for (a aVar3 : a) {
                        if (aVar3.a().equals(e)) {
                            aVar = aVar3;
                            break;
                        }
                    }
                }
                aVar = null;
                if (list != null) {
                    Iterator<a> it = list.iterator();
                    while (it.hasNext()) {
                        aVar2 = it.next();
                        if (aVar2.a().equals(e)) {
                            break;
                        }
                    }
                }
                aVar2 = null;
                if (aVar2 == null || aVar == null || !aVar2.c().equals(aVar.c())) {
                    q.a().a(false);
                }
            }
            if (list == null || list.size() == 0) {
                bdListView = this.a.b;
                bdListView.setVisibility(8);
                linearLayout = this.a.e;
                linearLayout.setVisibility(0);
                return;
            }
            bdListView2 = this.a.b;
            bdListView2.setVisibility(0);
            linearLayout2 = this.a.e;
            linearLayout2.setVisibility(8);
            this.a.a(list);
        }
    }
}
