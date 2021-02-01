package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private final List<cb> knQ = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.gcx = z;
        cVar.hasMore = aVar.hasMore();
        cVar.knL = aVar.cRX();
        cVar.knM = aVar.cRY();
        ArrayList<cb> cxb = aVar.cxb();
        if (z) {
            if (!y.isEmpty(cxb)) {
                this.knQ.clear();
                this.knQ.addAll(cxb);
            }
        } else if (!y.isEmpty(cxb)) {
            this.knQ.addAll(cxb);
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.knQ);
        a(arrayList, aVar.cRV());
        a(arrayList, aVar.cRW());
        a(arrayList, aVar.cRZ());
        a(arrayList, aVar.cSa());
        cVar.knK = aE(arrayList);
        return cVar;
    }

    private ArrayList<n> aE(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof cb) {
                cb cbVar = (cb) next;
                int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                if (cbVar.getType() == cb.eQm) {
                    ca caVar = new ca();
                    caVar.eJQ = cbVar;
                    caVar.position = i;
                    caVar.ePR = true;
                    arrayList2.add(caVar);
                    ca caVar2 = new ca();
                    caVar2.eJQ = cbVar;
                    caVar2.position = i;
                    if (cbVar.bpN()) {
                        caVar2.ePW = true;
                    } else if (cbVar.boX() == 1) {
                        caVar2.ePU = true;
                        caVar2.eQj = imageWidthAndHeight[0];
                        caVar2.eQk = imageWidthAndHeight[1];
                    } else if (cbVar.boX() >= 2) {
                        caVar2.ePV = true;
                    } else {
                        caVar2.ePS = true;
                    }
                    arrayList2.add(caVar2);
                    if (cbVar.bpW() != null) {
                        ca caVar3 = new ca();
                        caVar3.eQe = true;
                        caVar3.eJQ = cbVar;
                        caVar3.position = i;
                        arrayList2.add(caVar3);
                    }
                    if (!y.isEmpty(cbVar.bpZ()) || !y.isEmpty(cbVar.bqa())) {
                        ca caVar4 = new ca();
                        caVar4.eJQ = cbVar;
                        caVar4.position = i;
                        if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) == 1) {
                            caVar4.eQg = true;
                        } else if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) > 1) {
                            caVar4.eQh = true;
                        }
                        arrayList2.add(caVar4);
                    }
                    ca caVar5 = new ca();
                    caVar5.eQd = true;
                    caVar5.eJQ = cbVar;
                    caVar5.position = i;
                    arrayList2.add(caVar5);
                    ca caVar6 = new ca();
                    caVar6.ePX = true;
                    caVar6.eJQ = cbVar;
                    caVar6.position = i;
                    arrayList2.add(caVar6);
                } else if (cbVar.getType() == cb.eQK) {
                    ca caVar7 = new ca();
                    caVar7.eJQ = cbVar;
                    caVar7.position = i;
                    caVar7.ePR = true;
                    arrayList2.add(caVar7);
                    ca caVar8 = new ca();
                    caVar8.eJQ = cbVar;
                    caVar8.position = i;
                    caVar8.ePZ = true;
                    arrayList2.add(caVar8);
                    if (cbVar.bpW() != null) {
                        ca caVar9 = new ca();
                        caVar9.eQe = true;
                        caVar9.eJQ = cbVar;
                        caVar9.position = i;
                        arrayList2.add(caVar9);
                    }
                    ca caVar10 = new ca();
                    caVar10.eQd = true;
                    caVar10.eJQ = cbVar;
                    caVar10.position = i;
                    arrayList2.add(caVar10);
                    ca caVar11 = new ca();
                    caVar11.ePX = true;
                    caVar11.eJQ = cbVar;
                    caVar11.position = i;
                    arrayList2.add(caVar11);
                } else if (cbVar.getType() == cb.eQB && cbVar.bmx()) {
                    cbVar.position = i;
                    arrayList2.add(cbVar);
                } else if (j.ae(cbVar)) {
                    j jVar = new j(cbVar);
                    jVar.tid = cbVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    ca caVar12 = new ca();
                    caVar12.eJQ = cbVar;
                    caVar12.position = i;
                    arrayList2.add(caVar12);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.bj(arrayList2);
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
                if (!(arrayList.get(i3) instanceof cb)) {
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
        return (this.knQ == null || y.isEmpty(this.knQ)) ? false : true;
    }
}
