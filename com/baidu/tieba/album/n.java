package com.baidu.tieba.album;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements o {
    final /* synthetic */ m aia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aia = mVar;
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
        jVar = this.aia.ahY;
        List<a> data = jVar.getData();
        pVar = this.aia.aht;
        if (pVar == null) {
            albumActivity = this.aia.ahz;
            if (albumActivity != null) {
                m mVar = this.aia;
                albumActivity2 = this.aia.ahz;
                mVar.aht = albumActivity2.xJ();
            }
        }
        pVar2 = this.aia.aht;
        if (pVar2 != null) {
            pVar3 = this.aia.aht;
            String xW = pVar3.xW();
            if (xW != null) {
                if (data != null) {
                    for (a aVar3 : data) {
                        if (aVar3.getAlbumId().equals(xW)) {
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
                        if (aVar2.getAlbumId().equals(xW)) {
                            break;
                        }
                    }
                }
                aVar2 = null;
                if (aVar2 == null || aVar == null || !aVar2.xN().equals(aVar.xN())) {
                    q.xY().bk(false);
                }
            }
            if (list == null || list.size() == 0) {
                bdListView = this.aia.vl;
                bdListView.setVisibility(8);
                oVar = this.aia.ahX;
                oVar.setVisibility(0);
                return;
            }
            bdListView2 = this.aia.vl;
            bdListView2.setVisibility(0);
            oVar2 = this.aia.ahX;
            oVar2.setVisibility(8);
            this.aia.setData(list);
        }
    }
}
