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
/* loaded from: classes21.dex */
public class a {
    private final List<bw> jbq = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fnv = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jbl = aVar.cCw();
        cVar.jbm = aVar.cCx();
        ArrayList<bw> cjQ = aVar.cjQ();
        if (z) {
            if (!y.isEmpty(cjQ)) {
                this.jbq.clear();
                this.jbq.addAll(cjQ);
            }
        } else if (!y.isEmpty(cjQ)) {
            this.jbq.addAll(cjQ);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jbq);
        a(arrayList, aVar.cCu());
        a(arrayList, aVar.cCv());
        a(arrayList, aVar.cCy());
        a(arrayList, aVar.cCz());
        cVar.jbk = aG(arrayList);
        return cVar;
    }

    private ArrayList<q> aG(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bw) {
                bw bwVar = (bw) next;
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                if (bwVar.getType() == bw.edg) {
                    bv bvVar = new bv();
                    bvVar.dXg = bwVar;
                    bvVar.position = i;
                    bvVar.ecM = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.dXg = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bht()) {
                        bvVar2.ecR = true;
                    } else if (bwVar.bgE() == 1) {
                        bvVar2.ecP = true;
                        bvVar2.edd = imageWidthAndHeight[0];
                        bvVar2.ede = imageWidthAndHeight[1];
                    } else if (bwVar.bgE() >= 2) {
                        bvVar2.ecQ = true;
                    } else {
                        bvVar2.ecN = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bhB() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.ecY = true;
                        bvVar3.dXg = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.bhE()) || !y.isEmpty(bwVar.bhF())) {
                        bv bvVar4 = new bv();
                        bvVar4.dXg = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) == 1) {
                            bvVar4.eda = true;
                        } else if (y.getCount(bwVar.bhE()) + y.getCount(bwVar.bhF()) > 1) {
                            bvVar4.edb = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.ecX = true;
                    bvVar5.dXg = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.ecS = true;
                    bvVar6.dXg = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.edC) {
                    bv bvVar7 = new bv();
                    bvVar7.dXg = bwVar;
                    bvVar7.position = i;
                    bvVar7.ecM = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.dXg = bwVar;
                    bvVar8.position = i;
                    bvVar8.ecU = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.bhB() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.ecY = true;
                        bvVar9.dXg = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.ecX = true;
                    bvVar10.dXg = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.ecS = true;
                    bvVar11.dXg = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.edu && bwVar.beg()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.ab(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.dXg = bwVar;
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
        com.baidu.tbadk.a.a.a.aK(arrayList2);
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
        return (this.jbq == null || y.isEmpty(this.jbq)) ? false : true;
    }
}
