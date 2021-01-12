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
    private final List<bz> kfI = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.gae = z;
        cVar.hasMore = aVar.hasMore();
        cVar.kfD = aVar.cPY();
        cVar.kfE = aVar.cPZ();
        ArrayList<bz> cvP = aVar.cvP();
        if (z) {
            if (!x.isEmpty(cvP)) {
                this.kfI.clear();
                this.kfI.addAll(cvP);
            }
        } else if (!x.isEmpty(cvP)) {
            this.kfI.addAll(cvP);
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.kfI);
        a(arrayList, aVar.cPW());
        a(arrayList, aVar.cPX());
        a(arrayList, aVar.cQa());
        a(arrayList, aVar.cQb());
        cVar.kfC = aF(arrayList);
        return cVar;
    }

    private ArrayList<n> aF(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bz) {
                bz bzVar = (bz) next;
                int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                if (bzVar.getType() == bz.eOa) {
                    by byVar = new by();
                    byVar.eHK = bzVar;
                    byVar.position = i;
                    byVar.eNF = true;
                    arrayList2.add(byVar);
                    by byVar2 = new by();
                    byVar2.eHK = bzVar;
                    byVar2.position = i;
                    if (bzVar.bpv()) {
                        byVar2.eNK = true;
                    } else if (bzVar.boF() == 1) {
                        byVar2.eNI = true;
                        byVar2.eNX = imageWidthAndHeight[0];
                        byVar2.eNY = imageWidthAndHeight[1];
                    } else if (bzVar.boF() >= 2) {
                        byVar2.eNJ = true;
                    } else {
                        byVar2.eNG = true;
                    }
                    arrayList2.add(byVar2);
                    if (bzVar.bpE() != null) {
                        by byVar3 = new by();
                        byVar3.eNS = true;
                        byVar3.eHK = bzVar;
                        byVar3.position = i;
                        arrayList2.add(byVar3);
                    }
                    if (!x.isEmpty(bzVar.bpH()) || !x.isEmpty(bzVar.bpI())) {
                        by byVar4 = new by();
                        byVar4.eHK = bzVar;
                        byVar4.position = i;
                        if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) == 1) {
                            byVar4.eNU = true;
                        } else if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) > 1) {
                            byVar4.eNV = true;
                        }
                        arrayList2.add(byVar4);
                    }
                    by byVar5 = new by();
                    byVar5.eNR = true;
                    byVar5.eHK = bzVar;
                    byVar5.position = i;
                    arrayList2.add(byVar5);
                    by byVar6 = new by();
                    byVar6.eNL = true;
                    byVar6.eHK = bzVar;
                    byVar6.position = i;
                    arrayList2.add(byVar6);
                } else if (bzVar.getType() == bz.eOy) {
                    by byVar7 = new by();
                    byVar7.eHK = bzVar;
                    byVar7.position = i;
                    byVar7.eNF = true;
                    arrayList2.add(byVar7);
                    by byVar8 = new by();
                    byVar8.eHK = bzVar;
                    byVar8.position = i;
                    byVar8.eNN = true;
                    arrayList2.add(byVar8);
                    if (bzVar.bpE() != null) {
                        by byVar9 = new by();
                        byVar9.eNS = true;
                        byVar9.eHK = bzVar;
                        byVar9.position = i;
                        arrayList2.add(byVar9);
                    }
                    by byVar10 = new by();
                    byVar10.eNR = true;
                    byVar10.eHK = bzVar;
                    byVar10.position = i;
                    arrayList2.add(byVar10);
                    by byVar11 = new by();
                    byVar11.eNL = true;
                    byVar11.eHK = bzVar;
                    byVar11.position = i;
                    arrayList2.add(byVar11);
                } else if (bzVar.getType() == bz.eOp && bzVar.bme()) {
                    bzVar.position = i;
                    arrayList2.add(bzVar);
                } else if (j.ad(bzVar)) {
                    j jVar = new j(bzVar);
                    jVar.tid = bzVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    by byVar12 = new by();
                    byVar12.eHK = bzVar;
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
        return (this.kfI == null || x.isEmpty(this.kfI)) ? false : true;
    }
}
