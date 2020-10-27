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
    private final List<bw> jCP = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fIe = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jCK = aVar.cJm();
        cVar.jCL = aVar.cJn();
        ArrayList<bw> cqt = aVar.cqt();
        if (z) {
            if (!y.isEmpty(cqt)) {
                this.jCP.clear();
                this.jCP.addAll(cqt);
            }
        } else if (!y.isEmpty(cqt)) {
            this.jCP.addAll(cqt);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jCP);
        a(arrayList, aVar.cJk());
        a(arrayList, aVar.cJl());
        a(arrayList, aVar.cJo());
        a(arrayList, aVar.cJp());
        cVar.jCJ = aH(arrayList);
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
                if (bwVar.getType() == bw.exJ) {
                    bv bvVar = new bv();
                    bvVar.erH = bwVar;
                    bvVar.position = i;
                    bvVar.exo = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.erH = bwVar;
                    bvVar2.position = i;
                    if (bwVar.blV()) {
                        bvVar2.exu = true;
                    } else if (bwVar.blg() == 1) {
                        bvVar2.exr = true;
                        bvVar2.exG = imageWidthAndHeight[0];
                        bvVar2.exH = imageWidthAndHeight[1];
                    } else if (bwVar.blg() >= 2) {
                        bvVar2.exs = true;
                    } else {
                        bvVar2.exp = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bmd() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.exB = true;
                        bvVar3.erH = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.bmg()) || !y.isEmpty(bwVar.bmh())) {
                        bv bvVar4 = new bv();
                        bvVar4.erH = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) == 1) {
                            bvVar4.exD = true;
                        } else if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) > 1) {
                            bvVar4.exE = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.exA = true;
                    bvVar5.erH = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.exv = true;
                    bvVar6.erH = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.eyg) {
                    bv bvVar7 = new bv();
                    bvVar7.erH = bwVar;
                    bvVar7.position = i;
                    bvVar7.exo = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.erH = bwVar;
                    bvVar8.position = i;
                    bvVar8.exx = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.bmd() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.exB = true;
                        bvVar9.erH = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.exA = true;
                    bvVar10.erH = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.exv = true;
                    bvVar11.erH = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.exX && bwVar.biI()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.ab(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.erH = bwVar;
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
        com.baidu.tbadk.a.a.a.aX(arrayList2);
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
        return (this.jCP == null || y.isEmpty(this.jCP)) ? false : true;
    }
}
