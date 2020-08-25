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
    private final List<bw> iSE = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fky = z;
        cVar.hasMore = aVar.hasMore();
        cVar.iSz = aVar.cyO();
        cVar.iSA = aVar.cyP();
        ArrayList<bw> cgA = aVar.cgA();
        if (z) {
            if (!y.isEmpty(cgA)) {
                this.iSE.clear();
                this.iSE.addAll(cgA);
            }
        } else if (!y.isEmpty(cgA)) {
            this.iSE.addAll(cgA);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iSE);
        a(arrayList, aVar.cyM());
        a(arrayList, aVar.cyN());
        a(arrayList, aVar.cyQ());
        a(arrayList, aVar.cyR());
        cVar.iSy = aE(arrayList);
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
                if (bwVar.getType() == bw.eaS) {
                    bv bvVar = new bv();
                    bvVar.dUS = bwVar;
                    bvVar.position = i;
                    bvVar.eay = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.dUS = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bgz()) {
                        bvVar2.eaD = true;
                    } else if (bwVar.bfK() == 1) {
                        bvVar2.eaB = true;
                        bvVar2.eaP = imageWidthAndHeight[0];
                        bvVar2.eaQ = imageWidthAndHeight[1];
                    } else if (bwVar.bfK() >= 2) {
                        bvVar2.eaC = true;
                    } else {
                        bvVar2.eaz = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bgH() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.eaK = true;
                        bvVar3.dUS = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) {
                        bv bvVar4 = new bv();
                        bvVar4.dUS = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                            bvVar4.eaM = true;
                        } else if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) > 1) {
                            bvVar4.eaN = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.eaJ = true;
                    bvVar5.dUS = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.eaE = true;
                    bvVar6.dUS = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.ebo) {
                    bv bvVar7 = new bv();
                    bvVar7.dUS = bwVar;
                    bvVar7.position = i;
                    bvVar7.eay = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.dUS = bwVar;
                    bvVar8.position = i;
                    bvVar8.eaG = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.bgH() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.eaK = true;
                        bvVar9.dUS = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.eaJ = true;
                    bvVar10.dUS = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.eaE = true;
                    bvVar11.dUS = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.ebg && bwVar.bdm()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.aa(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.dUS = bwVar;
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
        return (this.iSE == null || y.isEmpty(this.iSE)) ? false : true;
    }
}
