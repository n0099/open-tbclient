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
/* loaded from: classes16.dex */
public class a {
    private final List<bw> iSK = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fkC = z;
        cVar.hasMore = aVar.hasMore();
        cVar.iSF = aVar.cyP();
        cVar.iSG = aVar.cyQ();
        ArrayList<bw> cgB = aVar.cgB();
        if (z) {
            if (!y.isEmpty(cgB)) {
                this.iSK.clear();
                this.iSK.addAll(cgB);
            }
        } else if (!y.isEmpty(cgB)) {
            this.iSK.addAll(cgB);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iSK);
        a(arrayList, aVar.cyN());
        a(arrayList, aVar.cyO());
        a(arrayList, aVar.cyR());
        a(arrayList, aVar.cyS());
        cVar.iSE = aE(arrayList);
        return cVar;
    }

    private ArrayList<q> aE(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bw) {
                bw bwVar = (bw) next;
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                if (bwVar.getType() == bw.eaW) {
                    bv bvVar = new bv();
                    bvVar.dUW = bwVar;
                    bvVar.position = i;
                    bvVar.eaC = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.dUW = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bgz()) {
                        bvVar2.eaH = true;
                    } else if (bwVar.bfK() == 1) {
                        bvVar2.eaF = true;
                        bvVar2.eaT = imageWidthAndHeight[0];
                        bvVar2.eaU = imageWidthAndHeight[1];
                    } else if (bwVar.bfK() >= 2) {
                        bvVar2.eaG = true;
                    } else {
                        bvVar2.eaD = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bgH() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.eaO = true;
                        bvVar3.dUW = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) {
                        bv bvVar4 = new bv();
                        bvVar4.dUW = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                            bvVar4.eaQ = true;
                        } else if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) > 1) {
                            bvVar4.eaR = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.eaN = true;
                    bvVar5.dUW = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.eaI = true;
                    bvVar6.dUW = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.ebs) {
                    bv bvVar7 = new bv();
                    bvVar7.dUW = bwVar;
                    bvVar7.position = i;
                    bvVar7.eaC = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.dUW = bwVar;
                    bvVar8.position = i;
                    bvVar8.eaK = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.bgH() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.eaO = true;
                        bvVar9.dUW = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.eaN = true;
                    bvVar10.dUW = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.eaI = true;
                    bvVar11.dUW = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.ebk && bwVar.bdm()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.aa(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.dUW = bwVar;
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
        return (this.iSK == null || y.isEmpty(this.iSK)) ? false : true;
    }
}
