package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private final List<bw> jIM = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fNU = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jIH = aVar.cLN();
        cVar.jII = aVar.cLO();
        ArrayList<bw> csU = aVar.csU();
        if (z) {
            if (!y.isEmpty(csU)) {
                this.jIM.clear();
                this.jIM.addAll(csU);
            }
        } else if (!y.isEmpty(csU)) {
            this.jIM.addAll(csU);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jIM);
        a(arrayList, aVar.cLL());
        a(arrayList, aVar.cLM());
        a(arrayList, aVar.cLP());
        a(arrayList, aVar.cLQ());
        cVar.jIG = aH(arrayList);
        return cVar;
    }

    private ArrayList<q> aH(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bw) {
                bw bwVar = (bw) next;
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                if (bwVar.getType() == bw.eDA) {
                    bv bvVar = new bv();
                    bvVar.exA = bwVar;
                    bvVar.position = i;
                    bvVar.eDg = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.exA = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bov()) {
                        bvVar2.eDl = true;
                    } else if (bwVar.bnG() == 1) {
                        bvVar2.eDj = true;
                        bvVar2.eDx = imageWidthAndHeight[0];
                        bvVar2.eDy = imageWidthAndHeight[1];
                    } else if (bwVar.bnG() >= 2) {
                        bvVar2.eDk = true;
                    } else {
                        bvVar2.eDh = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.boD() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.eDs = true;
                        bvVar3.exA = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.boG()) || !y.isEmpty(bwVar.boH())) {
                        bv bvVar4 = new bv();
                        bvVar4.exA = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) == 1) {
                            bvVar4.eDu = true;
                        } else if (y.getCount(bwVar.boG()) + y.getCount(bwVar.boH()) > 1) {
                            bvVar4.eDv = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.eDr = true;
                    bvVar5.exA = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.eDm = true;
                    bvVar6.exA = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.eDW) {
                    bv bvVar7 = new bv();
                    bvVar7.exA = bwVar;
                    bvVar7.position = i;
                    bvVar7.eDg = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.exA = bwVar;
                    bvVar8.position = i;
                    bvVar8.eDo = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.boD() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.eDs = true;
                        bvVar9.exA = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.eDr = true;
                    bvVar10.exA = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.eDm = true;
                    bvVar11.exA = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.eDO && bwVar.bli()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.ab(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.exA = bwVar;
                    bvVar12.position = i;
                    arrayList2.add(bvVar12);
                }
            } else if (next instanceof b) {
                ((b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.be(arrayList2);
        return arrayList2;
    }

    private void a(ArrayList<q> arrayList, AbsThreadDataSupport absThreadDataSupport) {
        int i;
        int i2;
        if (absThreadDataSupport != null && arrayList != null && (i = absThreadDataSupport.floorPosition) > 0) {
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (!(arrayList.get(i3) instanceof bw)) {
                    i2 = i4;
                } else if (i == i4) {
                    y.add(arrayList, i3, absThreadDataSupport);
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
        return (this.jIM == null || y.isEmpty(this.jIM)) ? false : true;
    }
}
