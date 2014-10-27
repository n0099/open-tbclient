package com.baidu.tieba.album;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements o {
    final /* synthetic */ m ahR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.ahR = mVar;
    }

    @Override // com.baidu.tieba.album.o
    public void hL() {
    }

    @Override // com.baidu.tieba.album.o
    public void x(List<a> list) {
        j jVar;
        p pVar;
        p pVar2;
        p pVar3;
        BdListView bdListView;
        com.baidu.tbadk.core.view.o oVar;
        BdListView bdListView2;
        com.baidu.tbadk.core.view.o oVar2;
        a aVar;
        a aVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        jVar = this.ahR.ahP;
        List<a> data = jVar.getData();
        pVar = this.ahR.ahk;
        if (pVar == null) {
            albumActivity = this.ahR.ahq;
            if (albumActivity != null) {
                m mVar = this.ahR;
                albumActivity2 = this.ahR.ahq;
                mVar.ahk = albumActivity2.xH();
            }
        }
        pVar2 = this.ahR.ahk;
        if (pVar2 != null) {
            pVar3 = this.ahR.ahk;
            String xU = pVar3.xU();
            if (xU != null) {
                if (data != null) {
                    for (a aVar3 : data) {
                        if (aVar3.getAlbumId().equals(xU)) {
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
                        if (aVar2.getAlbumId().equals(xU)) {
                            break;
                        }
                    }
                }
                aVar2 = null;
                if (aVar2 == null || aVar == null || !aVar2.xL().equals(aVar.xL())) {
                    q.xW().bk(false);
                }
            }
            if (list == null || list.size() == 0) {
                bdListView = this.ahR.vl;
                bdListView.setVisibility(8);
                oVar = this.ahR.ahO;
                oVar.setVisibility(0);
                return;
            }
            bdListView2 = this.ahR.vl;
            bdListView2.setVisibility(0);
            oVar2 = this.ahR.ahO;
            oVar2.setVisibility(8);
            this.ahR.setData(list);
        }
    }
}
