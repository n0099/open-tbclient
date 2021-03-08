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
    private final List<cb> kqg = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.gec = z;
        cVar.hasMore = aVar.hasMore();
        cVar.kqb = aVar.cSl();
        cVar.kqc = aVar.cSm();
        ArrayList<cb> cxo = aVar.cxo();
        if (z) {
            if (!y.isEmpty(cxo)) {
                this.kqg.clear();
                this.kqg.addAll(cxo);
            }
        } else if (!y.isEmpty(cxo)) {
            this.kqg.addAll(cxo);
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.kqg);
        a(arrayList, aVar.cSj());
        a(arrayList, aVar.cSk());
        a(arrayList, aVar.cSn());
        a(arrayList, aVar.cSo());
        cVar.kqa = aE(arrayList);
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
                if (cbVar.getType() == cb.eRN) {
                    ca caVar = new ca();
                    caVar.eLr = cbVar;
                    caVar.position = i;
                    caVar.eRs = true;
                    arrayList2.add(caVar);
                    ca caVar2 = new ca();
                    caVar2.eLr = cbVar;
                    caVar2.position = i;
                    if (cbVar.bpP()) {
                        caVar2.eRx = true;
                    } else if (cbVar.boZ() == 1) {
                        caVar2.eRv = true;
                        caVar2.eRK = imageWidthAndHeight[0];
                        caVar2.eRL = imageWidthAndHeight[1];
                    } else if (cbVar.boZ() >= 2) {
                        caVar2.eRw = true;
                    } else {
                        caVar2.eRt = true;
                    }
                    arrayList2.add(caVar2);
                    if (cbVar.bpY() != null) {
                        ca caVar3 = new ca();
                        caVar3.eRF = true;
                        caVar3.eLr = cbVar;
                        caVar3.position = i;
                        arrayList2.add(caVar3);
                    }
                    if (!y.isEmpty(cbVar.bqb()) || !y.isEmpty(cbVar.bqc())) {
                        ca caVar4 = new ca();
                        caVar4.eLr = cbVar;
                        caVar4.position = i;
                        if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) == 1) {
                            caVar4.eRH = true;
                        } else if (y.getCount(cbVar.bqb()) + y.getCount(cbVar.bqc()) > 1) {
                            caVar4.eRI = true;
                        }
                        arrayList2.add(caVar4);
                    }
                    ca caVar5 = new ca();
                    caVar5.eRE = true;
                    caVar5.eLr = cbVar;
                    caVar5.position = i;
                    arrayList2.add(caVar5);
                    ca caVar6 = new ca();
                    caVar6.eRy = true;
                    caVar6.eLr = cbVar;
                    caVar6.position = i;
                    arrayList2.add(caVar6);
                } else if (cbVar.getType() == cb.eSl) {
                    ca caVar7 = new ca();
                    caVar7.eLr = cbVar;
                    caVar7.position = i;
                    caVar7.eRs = true;
                    arrayList2.add(caVar7);
                    ca caVar8 = new ca();
                    caVar8.eLr = cbVar;
                    caVar8.position = i;
                    caVar8.eRA = true;
                    arrayList2.add(caVar8);
                    if (cbVar.bpY() != null) {
                        ca caVar9 = new ca();
                        caVar9.eRF = true;
                        caVar9.eLr = cbVar;
                        caVar9.position = i;
                        arrayList2.add(caVar9);
                    }
                    ca caVar10 = new ca();
                    caVar10.eRE = true;
                    caVar10.eLr = cbVar;
                    caVar10.position = i;
                    arrayList2.add(caVar10);
                    ca caVar11 = new ca();
                    caVar11.eRy = true;
                    caVar11.eLr = cbVar;
                    caVar11.position = i;
                    arrayList2.add(caVar11);
                } else if (cbVar.getType() == cb.eSc && cbVar.bmz()) {
                    cbVar.position = i;
                    arrayList2.add(cbVar);
                } else if (j.ae(cbVar)) {
                    j jVar = new j(cbVar);
                    jVar.tid = cbVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    ca caVar12 = new ca();
                    caVar12.eLr = cbVar;
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
        return (this.kqg == null || y.isEmpty(this.kqg)) ? false : true;
    }
}
