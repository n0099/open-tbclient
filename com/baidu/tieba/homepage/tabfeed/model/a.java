package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private final List<by> jXc = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fVi = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jWX = aVar.cQJ();
        cVar.jWY = aVar.cQK();
        ArrayList<by> cwN = aVar.cwN();
        if (z) {
            if (!y.isEmpty(cwN)) {
                this.jXc.clear();
                this.jXc.addAll(cwN);
            }
        } else if (!y.isEmpty(cwN)) {
            this.jXc.addAll(cwN);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jXc);
        a(arrayList, aVar.cQH());
        a(arrayList, aVar.cQI());
        a(arrayList, aVar.cQL());
        a(arrayList, aVar.cQM());
        cVar.jWW = aK(arrayList);
        return cVar;
    }

    private ArrayList<q> aK(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof by) {
                by byVar = (by) next;
                int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                if (byVar.getType() == by.eIS) {
                    bx bxVar = new bx();
                    bxVar.eCR = byVar;
                    bxVar.position = i;
                    bxVar.eIy = true;
                    arrayList2.add(bxVar);
                    bx bxVar2 = new bx();
                    bxVar2.eCR = byVar;
                    bxVar2.position = i;
                    if (byVar.bqM()) {
                        bxVar2.eID = true;
                    } else if (byVar.bpX() == 1) {
                        bxVar2.eIB = true;
                        bxVar2.eIP = imageWidthAndHeight[0];
                        bxVar2.eIQ = imageWidthAndHeight[1];
                    } else if (byVar.bpX() >= 2) {
                        bxVar2.eIC = true;
                    } else {
                        bxVar2.eIz = true;
                    }
                    arrayList2.add(bxVar2);
                    if (byVar.bqV() != null) {
                        bx bxVar3 = new bx();
                        bxVar3.eIK = true;
                        bxVar3.eCR = byVar;
                        bxVar3.position = i;
                        arrayList2.add(bxVar3);
                    }
                    if (!y.isEmpty(byVar.bqY()) || !y.isEmpty(byVar.bqZ())) {
                        bx bxVar4 = new bx();
                        bxVar4.eCR = byVar;
                        bxVar4.position = i;
                        if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) == 1) {
                            bxVar4.eIM = true;
                        } else if (y.getCount(byVar.bqY()) + y.getCount(byVar.bqZ()) > 1) {
                            bxVar4.eIN = true;
                        }
                        arrayList2.add(bxVar4);
                    }
                    bx bxVar5 = new bx();
                    bxVar5.eIJ = true;
                    bxVar5.eCR = byVar;
                    bxVar5.position = i;
                    arrayList2.add(bxVar5);
                    bx bxVar6 = new bx();
                    bxVar6.eIE = true;
                    bxVar6.eCR = byVar;
                    bxVar6.position = i;
                    arrayList2.add(bxVar6);
                } else if (byVar.getType() == by.eJq) {
                    bx bxVar7 = new bx();
                    bxVar7.eCR = byVar;
                    bxVar7.position = i;
                    bxVar7.eIy = true;
                    arrayList2.add(bxVar7);
                    bx bxVar8 = new bx();
                    bxVar8.eCR = byVar;
                    bxVar8.position = i;
                    bxVar8.eIG = true;
                    arrayList2.add(bxVar8);
                    if (byVar.bqV() != null) {
                        bx bxVar9 = new bx();
                        bxVar9.eIK = true;
                        bxVar9.eCR = byVar;
                        bxVar9.position = i;
                        arrayList2.add(bxVar9);
                    }
                    bx bxVar10 = new bx();
                    bxVar10.eIJ = true;
                    bxVar10.eCR = byVar;
                    bxVar10.position = i;
                    arrayList2.add(bxVar10);
                    bx bxVar11 = new bx();
                    bxVar11.eIE = true;
                    bxVar11.eCR = byVar;
                    bxVar11.position = i;
                    arrayList2.add(bxVar11);
                } else if (byVar.getType() == by.eJh && byVar.bnx()) {
                    byVar.position = i;
                    arrayList2.add(byVar);
                } else if (j.ad(byVar)) {
                    j jVar = new j(byVar);
                    jVar.tid = byVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bx bxVar12 = new bx();
                    bxVar12.eCR = byVar;
                    bxVar12.position = i;
                    arrayList2.add(bxVar12);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.bh(arrayList2);
        return arrayList2;
    }

    private void a(ArrayList<q> arrayList, com.baidu.tbadk.core.data.a aVar) {
        int i;
        int i2;
        if (aVar != null && arrayList != null && (i = aVar.floorPosition) > 0) {
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(arrayList.get(i3) instanceof by)) {
                    i2 = i4;
                } else if (i == i4) {
                    y.add(arrayList, i3, aVar);
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
        return (this.jXc == null || y.isEmpty(this.jXc)) ? false : true;
    }
}
