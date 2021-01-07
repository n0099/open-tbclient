package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private final List<bz> kko = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.geO = z;
        cVar.hasMore = aVar.hasMore();
        cVar.kkj = aVar.cTQ();
        cVar.kkk = aVar.cTR();
        ArrayList<bz> czH = aVar.czH();
        if (z) {
            if (!x.isEmpty(czH)) {
                this.kko.clear();
                this.kko.addAll(czH);
            }
        } else if (!x.isEmpty(czH)) {
            this.kko.addAll(czH);
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.kko);
        a(arrayList, aVar.cTO());
        a(arrayList, aVar.cTP());
        a(arrayList, aVar.cTS());
        a(arrayList, aVar.cTT());
        cVar.kki = aK(arrayList);
        return cVar;
    }

    private ArrayList<n> aK(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bz) {
                bz bzVar = (bz) next;
                int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                if (bzVar.getType() == bz.eSL) {
                    by byVar = new by();
                    byVar.eMv = bzVar;
                    byVar.position = i;
                    byVar.eSq = true;
                    arrayList2.add(byVar);
                    by byVar2 = new by();
                    byVar2.eMv = bzVar;
                    byVar2.position = i;
                    if (bzVar.btp()) {
                        byVar2.eSv = true;
                    } else if (bzVar.bsz() == 1) {
                        byVar2.eSt = true;
                        byVar2.eSI = imageWidthAndHeight[0];
                        byVar2.eSJ = imageWidthAndHeight[1];
                    } else if (bzVar.bsz() >= 2) {
                        byVar2.eSu = true;
                    } else {
                        byVar2.eSr = true;
                    }
                    arrayList2.add(byVar2);
                    if (bzVar.bty() != null) {
                        by byVar3 = new by();
                        byVar3.eSD = true;
                        byVar3.eMv = bzVar;
                        byVar3.position = i;
                        arrayList2.add(byVar3);
                    }
                    if (!x.isEmpty(bzVar.btB()) || !x.isEmpty(bzVar.btC())) {
                        by byVar4 = new by();
                        byVar4.eMv = bzVar;
                        byVar4.position = i;
                        if (x.getCount(bzVar.btB()) + x.getCount(bzVar.btC()) == 1) {
                            byVar4.eSF = true;
                        } else if (x.getCount(bzVar.btB()) + x.getCount(bzVar.btC()) > 1) {
                            byVar4.eSG = true;
                        }
                        arrayList2.add(byVar4);
                    }
                    by byVar5 = new by();
                    byVar5.eSC = true;
                    byVar5.eMv = bzVar;
                    byVar5.position = i;
                    arrayList2.add(byVar5);
                    by byVar6 = new by();
                    byVar6.eSw = true;
                    byVar6.eMv = bzVar;
                    byVar6.position = i;
                    arrayList2.add(byVar6);
                } else if (bzVar.getType() == bz.eTj) {
                    by byVar7 = new by();
                    byVar7.eMv = bzVar;
                    byVar7.position = i;
                    byVar7.eSq = true;
                    arrayList2.add(byVar7);
                    by byVar8 = new by();
                    byVar8.eMv = bzVar;
                    byVar8.position = i;
                    byVar8.eSy = true;
                    arrayList2.add(byVar8);
                    if (bzVar.bty() != null) {
                        by byVar9 = new by();
                        byVar9.eSD = true;
                        byVar9.eMv = bzVar;
                        byVar9.position = i;
                        arrayList2.add(byVar9);
                    }
                    by byVar10 = new by();
                    byVar10.eSC = true;
                    byVar10.eMv = bzVar;
                    byVar10.position = i;
                    arrayList2.add(byVar10);
                    by byVar11 = new by();
                    byVar11.eSw = true;
                    byVar11.eMv = bzVar;
                    byVar11.position = i;
                    arrayList2.add(byVar11);
                } else if (bzVar.getType() == bz.eTa && bzVar.bpY()) {
                    bzVar.position = i;
                    arrayList2.add(bzVar);
                } else if (j.ad(bzVar)) {
                    j jVar = new j(bzVar);
                    jVar.tid = bzVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    by byVar12 = new by();
                    byVar12.eMv = bzVar;
                    byVar12.position = i;
                    arrayList2.add(byVar12);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.bo(arrayList2);
        return arrayList2;
    }

    private void a(ArrayList<n> arrayList, com.baidu.tbadk.core.data.a aVar) {
        int i;
        int i2;
        if (aVar != null && arrayList != null && (i = aVar.floorPosition) > 0) {
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(arrayList.get(i3) instanceof bz)) {
                    i2 = i4;
                } else if (i == i4) {
                    x.add(arrayList, i3, aVar);
                    return;
                } else {
                    i2 = i4 + 1;
                }
                i3++;
                i4 = i2;
            }
        }
    }

    public boolean hasData() {
        return (this.kko == null || x.isEmpty(this.kko)) ? false : true;
    }
}
