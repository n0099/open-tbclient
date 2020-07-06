package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.homepage.tabfeed.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private final List<bu> ixA = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.eSL = z;
        cVar.hasMore = aVar.hasMore();
        cVar.ixv = aVar.ckv();
        cVar.ixw = aVar.ckw();
        ArrayList<bu> bSW = aVar.bSW();
        if (z) {
            if (!w.isEmpty(bSW)) {
                this.ixA.clear();
                this.ixA.addAll(bSW);
            }
        } else if (!w.isEmpty(bSW)) {
            this.ixA.addAll(bSW);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.ixA);
        a(arrayList, aVar.ckt());
        a(arrayList, aVar.cku());
        a(arrayList, aVar.ckx());
        a(arrayList, aVar.cky());
        cVar.ixu = ax(arrayList);
        return cVar;
    }

    private ArrayList<q> ax(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bu) {
                bu buVar = (bu) next;
                int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                if (buVar.getType() == bu.dLm) {
                    bt btVar = new bt();
                    btVar.dLi = buVar;
                    btVar.position = i;
                    btVar.dKS = true;
                    arrayList2.add(btVar);
                    bt btVar2 = new bt();
                    btVar2.dLi = buVar;
                    btVar2.position = i;
                    if (buVar.aUl()) {
                        btVar2.dKX = true;
                    } else if (buVar.aTv() == 1) {
                        btVar2.dKV = true;
                        btVar2.dLj = imageWidthAndHeight[0];
                        btVar2.dLk = imageWidthAndHeight[1];
                    } else if (buVar.aTv() >= 2) {
                        btVar2.dKW = true;
                    } else {
                        btVar2.dKT = true;
                    }
                    arrayList2.add(btVar2);
                    if (buVar.aUu() != null) {
                        bt btVar3 = new bt();
                        btVar3.dLe = true;
                        btVar3.dLi = buVar;
                        btVar3.position = i;
                        arrayList2.add(btVar3);
                    }
                    if (!w.isEmpty(buVar.aUx())) {
                        bt btVar4 = new bt();
                        btVar4.dLi = buVar;
                        btVar4.position = i;
                        if (w.getCount(buVar.aUx()) == 1) {
                            btVar4.dLg = true;
                        } else {
                            btVar4.dLh = true;
                        }
                        arrayList2.add(btVar4);
                    }
                    bt btVar5 = new bt();
                    btVar5.dLd = true;
                    btVar5.dLi = buVar;
                    btVar5.position = i;
                    arrayList2.add(btVar5);
                    bt btVar6 = new bt();
                    btVar6.dKY = true;
                    btVar6.dLi = buVar;
                    btVar6.position = i;
                    arrayList2.add(btVar6);
                } else if (buVar.getType() == bu.dLH) {
                    bt btVar7 = new bt();
                    btVar7.dLi = buVar;
                    btVar7.position = i;
                    btVar7.dKS = true;
                    arrayList2.add(btVar7);
                    bt btVar8 = new bt();
                    btVar8.dLi = buVar;
                    btVar8.position = i;
                    btVar8.dLa = true;
                    arrayList2.add(btVar8);
                    if (buVar.aUu() != null) {
                        bt btVar9 = new bt();
                        btVar9.dLe = true;
                        btVar9.dLi = buVar;
                        btVar9.position = i;
                        arrayList2.add(btVar9);
                    }
                    bt btVar10 = new bt();
                    btVar10.dLd = true;
                    btVar10.dLi = buVar;
                    btVar10.position = i;
                    arrayList2.add(btVar10);
                    bt btVar11 = new bt();
                    btVar11.dKY = true;
                    btVar11.dLi = buVar;
                    btVar11.position = i;
                    arrayList2.add(btVar11);
                } else if (buVar.getType() == bu.dLz && buVar.aQX()) {
                    buVar.position = i;
                    arrayList2.add(buVar);
                } else if (j.ad(buVar)) {
                    j jVar = new j(buVar);
                    jVar.tid = buVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bt btVar12 = new bt();
                    btVar12.dLi = buVar;
                    btVar12.position = i;
                    arrayList2.add(btVar12);
                }
            } else if (next instanceof b) {
                ((b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
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
                if (!(arrayList.get(i3) instanceof bu)) {
                    i2 = i4;
                } else if (i == i4) {
                    w.add(arrayList, i3, absThreadDataSupport);
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
        return (this.ixA == null || w.isEmpty(this.ixA)) ? false : true;
    }
}
