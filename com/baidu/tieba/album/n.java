package com.baidu.tieba.album;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements o {
    final /* synthetic */ m apo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.apo = mVar;
    }

    @Override // com.baidu.tieba.album.o
    public void jH() {
    }

    @Override // com.baidu.tieba.album.o
    public void C(List<a> list) {
        j jVar;
        p pVar;
        p pVar2;
        p pVar3;
        BdListView bdListView;
        com.baidu.tbadk.core.view.x xVar;
        BdListView bdListView2;
        com.baidu.tbadk.core.view.x xVar2;
        a aVar;
        a aVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        jVar = this.apo.apm;
        List<a> data = jVar.getData();
        pVar = this.apo.aoJ;
        if (pVar == null) {
            albumActivity = this.apo.aoO;
            if (albumActivity != null) {
                m mVar = this.apo;
                albumActivity2 = this.apo.aoO;
                mVar.aoJ = albumActivity2.Bc();
            }
        }
        pVar2 = this.apo.aoJ;
        if (pVar2 != null) {
            pVar3 = this.apo.aoJ;
            String Bp = pVar3.Bp();
            if (Bp != null) {
                if (data != null) {
                    for (a aVar3 : data) {
                        if (aVar3.getAlbumId().equals(Bp)) {
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
                        if (aVar2.getAlbumId().equals(Bp)) {
                            break;
                        }
                    }
                }
                aVar2 = null;
                if (aVar2 == null || aVar == null || !aVar2.Bg().equals(aVar.Bg())) {
                    q.Br().bj(false);
                }
            }
            if (list == null || list.size() == 0) {
                bdListView = this.apo.mListView;
                bdListView.setVisibility(8);
                xVar = this.apo.mNoDataView;
                xVar.setVisibility(0);
                return;
            }
            bdListView2 = this.apo.mListView;
            bdListView2.setVisibility(0);
            xVar2 = this.apo.mNoDataView;
            xVar2.setVisibility(8);
            this.apo.setData(list);
        }
    }
}
