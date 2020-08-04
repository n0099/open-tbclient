package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private final List<bv> iDG = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.eZg = z;
        cVar.hasMore = aVar.hasMore();
        cVar.iDB = aVar.cnV();
        cVar.iDC = aVar.cnW();
        ArrayList<bv> bWn = aVar.bWn();
        if (z) {
            if (!x.isEmpty(bWn)) {
                this.iDG.clear();
                this.iDG.addAll(bWn);
            }
        } else if (!x.isEmpty(bWn)) {
            this.iDG.addAll(bWn);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iDG);
        a(arrayList, aVar.cnT());
        a(arrayList, aVar.cnU());
        a(arrayList, aVar.cnX());
        a(arrayList, aVar.cnY());
        cVar.iDA = ay(arrayList);
        return cVar;
    }

    private ArrayList<q> ay(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bv bvVar = (bv) next;
                int[] imageWidthAndHeight = bvVar.getImageWidthAndHeight();
                if (bvVar.getType() == bv.dRx) {
                    bu buVar = new bu();
                    buVar.dLK = bvVar;
                    buVar.position = i;
                    buVar.dRe = true;
                    arrayList2.add(buVar);
                    bu buVar2 = new bu();
                    buVar2.dLK = bvVar;
                    buVar2.position = i;
                    if (bvVar.aYg()) {
                        buVar2.dRj = true;
                    } else if (bvVar.aXr() == 1) {
                        buVar2.dRh = true;
                        buVar2.dRu = imageWidthAndHeight[0];
                        buVar2.dRv = imageWidthAndHeight[1];
                    } else if (bvVar.aXr() >= 2) {
                        buVar2.dRi = true;
                    } else {
                        buVar2.dRf = true;
                    }
                    arrayList2.add(buVar2);
                    if (bvVar.aYo() != null) {
                        bu buVar3 = new bu();
                        buVar3.dRq = true;
                        buVar3.dLK = bvVar;
                        buVar3.position = i;
                        arrayList2.add(buVar3);
                    }
                    if (!x.isEmpty(bvVar.aYr())) {
                        bu buVar4 = new bu();
                        buVar4.dLK = bvVar;
                        buVar4.position = i;
                        if (x.getCount(bvVar.aYr()) == 1) {
                            buVar4.dRs = true;
                        } else {
                            buVar4.dRt = true;
                        }
                        arrayList2.add(buVar4);
                    }
                    bu buVar5 = new bu();
                    buVar5.dRp = true;
                    buVar5.dLK = bvVar;
                    buVar5.position = i;
                    arrayList2.add(buVar5);
                    bu buVar6 = new bu();
                    buVar6.dRk = true;
                    buVar6.dLK = bvVar;
                    buVar6.position = i;
                    arrayList2.add(buVar6);
                } else if (bvVar.getType() == bv.dRS) {
                    bu buVar7 = new bu();
                    buVar7.dLK = bvVar;
                    buVar7.position = i;
                    buVar7.dRe = true;
                    arrayList2.add(buVar7);
                    bu buVar8 = new bu();
                    buVar8.dLK = bvVar;
                    buVar8.position = i;
                    buVar8.dRm = true;
                    arrayList2.add(buVar8);
                    if (bvVar.aYo() != null) {
                        bu buVar9 = new bu();
                        buVar9.dRq = true;
                        buVar9.dLK = bvVar;
                        buVar9.position = i;
                        arrayList2.add(buVar9);
                    }
                    bu buVar10 = new bu();
                    buVar10.dRp = true;
                    buVar10.dLK = bvVar;
                    buVar10.position = i;
                    arrayList2.add(buVar10);
                    bu buVar11 = new bu();
                    buVar11.dRk = true;
                    buVar11.dLK = bvVar;
                    buVar11.position = i;
                    arrayList2.add(buVar11);
                } else if (bvVar.getType() == bv.dRK && bvVar.aUT()) {
                    bvVar.position = i;
                    arrayList2.add(bvVar);
                } else if (j.aa(bvVar)) {
                    j jVar = new j(bvVar);
                    jVar.tid = bvVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bu buVar12 = new bu();
                    buVar12.dLK = bvVar;
                    buVar12.position = i;
                    arrayList2.add(buVar12);
                }
            } else if (next instanceof b) {
                ((b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.aG(arrayList2);
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
                if (!(arrayList.get(i3) instanceof bv)) {
                    i2 = i4;
                } else if (i == i4) {
                    x.add(arrayList, i3, absThreadDataSupport);
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
        return (this.iDG == null || x.isEmpty(this.iDG)) ? false : true;
    }
}
