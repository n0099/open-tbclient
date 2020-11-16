package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private final List<bx> jJx = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fNx = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jJs = aVar.cLu();
        cVar.jJt = aVar.cLv();
        ArrayList<bx> csx = aVar.csx();
        if (z) {
            if (!y.isEmpty(csx)) {
                this.jJx.clear();
                this.jJx.addAll(csx);
            }
        } else if (!y.isEmpty(csx)) {
            this.jJx.addAll(csx);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jJx);
        a(arrayList, aVar.cLs());
        a(arrayList, aVar.cLt());
        a(arrayList, aVar.cLw());
        a(arrayList, aVar.cLx());
        cVar.jJr = aI(arrayList);
        return cVar;
    }

    private ArrayList<q> aI(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bx) {
                bx bxVar = (bx) next;
                int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
                if (bxVar.getType() == bx.eBR) {
                    bw bwVar = new bw();
                    bwVar.evQ = bxVar;
                    bwVar.position = i;
                    bwVar.eBx = true;
                    arrayList2.add(bwVar);
                    bw bwVar2 = new bw();
                    bwVar2.evQ = bxVar;
                    bwVar2.position = i;
                    if (bxVar.bnz()) {
                        bwVar2.eBC = true;
                    } else if (bxVar.bmK() == 1) {
                        bwVar2.eBA = true;
                        bwVar2.eBO = imageWidthAndHeight[0];
                        bwVar2.eBP = imageWidthAndHeight[1];
                    } else if (bxVar.bmK() >= 2) {
                        bwVar2.eBB = true;
                    } else {
                        bwVar2.eBy = true;
                    }
                    arrayList2.add(bwVar2);
                    if (bxVar.bnH() != null) {
                        bw bwVar3 = new bw();
                        bwVar3.eBJ = true;
                        bwVar3.evQ = bxVar;
                        bwVar3.position = i;
                        arrayList2.add(bwVar3);
                    }
                    if (!y.isEmpty(bxVar.bnK()) || !y.isEmpty(bxVar.bnL())) {
                        bw bwVar4 = new bw();
                        bwVar4.evQ = bxVar;
                        bwVar4.position = i;
                        if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) == 1) {
                            bwVar4.eBL = true;
                        } else if (y.getCount(bxVar.bnK()) + y.getCount(bxVar.bnL()) > 1) {
                            bwVar4.eBM = true;
                        }
                        arrayList2.add(bwVar4);
                    }
                    bw bwVar5 = new bw();
                    bwVar5.eBI = true;
                    bwVar5.evQ = bxVar;
                    bwVar5.position = i;
                    arrayList2.add(bwVar5);
                    bw bwVar6 = new bw();
                    bwVar6.eBD = true;
                    bwVar6.evQ = bxVar;
                    bwVar6.position = i;
                    arrayList2.add(bwVar6);
                } else if (bxVar.getType() == bx.eCo) {
                    bw bwVar7 = new bw();
                    bwVar7.evQ = bxVar;
                    bwVar7.position = i;
                    bwVar7.eBx = true;
                    arrayList2.add(bwVar7);
                    bw bwVar8 = new bw();
                    bwVar8.evQ = bxVar;
                    bwVar8.position = i;
                    bwVar8.eBF = true;
                    arrayList2.add(bwVar8);
                    if (bxVar.bnH() != null) {
                        bw bwVar9 = new bw();
                        bwVar9.eBJ = true;
                        bwVar9.evQ = bxVar;
                        bwVar9.position = i;
                        arrayList2.add(bwVar9);
                    }
                    bw bwVar10 = new bw();
                    bwVar10.eBI = true;
                    bwVar10.evQ = bxVar;
                    bwVar10.position = i;
                    arrayList2.add(bwVar10);
                    bw bwVar11 = new bw();
                    bwVar11.eBD = true;
                    bwVar11.evQ = bxVar;
                    bwVar11.position = i;
                    arrayList2.add(bwVar11);
                } else if (bxVar.getType() == bx.eCg && bxVar.bkk()) {
                    bxVar.position = i;
                    arrayList2.add(bxVar);
                } else if (j.ad(bxVar)) {
                    j jVar = new j(bxVar);
                    jVar.tid = bxVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bw bwVar12 = new bw();
                    bwVar12.evQ = bxVar;
                    bwVar12.position = i;
                    arrayList2.add(bwVar12);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.be(arrayList2);
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
                if (!(arrayList.get(i3) instanceof bx)) {
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
        return (this.jJx == null || y.isEmpty(this.jJx)) ? false : true;
    }
}
