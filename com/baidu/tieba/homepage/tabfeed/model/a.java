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
    private final List<bw> jqp = new ArrayList();

    public c a(boolean z, com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        c cVar = new c();
        cVar.fzJ = z;
        cVar.hasMore = aVar.hasMore();
        cVar.jqk = aVar.cGf();
        cVar.jql = aVar.cGg();
        ArrayList<bw> cnm = aVar.cnm();
        if (z) {
            if (!y.isEmpty(cnm)) {
                this.jqp.clear();
                this.jqp.addAll(cnm);
            }
        } else if (!y.isEmpty(cnm)) {
            this.jqp.addAll(cnm);
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jqp);
        a(arrayList, aVar.cGd());
        a(arrayList, aVar.cGe());
        a(arrayList, aVar.cGh());
        a(arrayList, aVar.cGi());
        cVar.jqj = aG(arrayList);
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
                if (bwVar.getType() == bw.epl) {
                    bv bvVar = new bv();
                    bvVar.eji = bwVar;
                    bvVar.position = i;
                    bvVar.eoR = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.eji = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bkc()) {
                        bvVar2.eoW = true;
                    } else if (bwVar.bjn() == 1) {
                        bvVar2.eoU = true;
                        bvVar2.epi = imageWidthAndHeight[0];
                        bvVar2.epj = imageWidthAndHeight[1];
                    } else if (bwVar.bjn() >= 2) {
                        bvVar2.eoV = true;
                    } else {
                        bvVar2.eoS = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bkk() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.epd = true;
                        bvVar3.eji = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    if (!y.isEmpty(bwVar.bkn()) || !y.isEmpty(bwVar.bko())) {
                        bv bvVar4 = new bv();
                        bvVar4.eji = bwVar;
                        bvVar4.position = i;
                        if (y.getCount(bwVar.bkn()) + y.getCount(bwVar.bko()) == 1) {
                            bvVar4.epf = true;
                        } else if (y.getCount(bwVar.bkn()) + y.getCount(bwVar.bko()) > 1) {
                            bvVar4.epg = true;
                        }
                        arrayList2.add(bvVar4);
                    }
                    bv bvVar5 = new bv();
                    bvVar5.epc = true;
                    bvVar5.eji = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                    bv bvVar6 = new bv();
                    bvVar6.eoX = true;
                    bvVar6.eji = bwVar;
                    bvVar6.position = i;
                    arrayList2.add(bvVar6);
                } else if (bwVar.getType() == bw.epH) {
                    bv bvVar7 = new bv();
                    bvVar7.eji = bwVar;
                    bvVar7.position = i;
                    bvVar7.eoR = true;
                    arrayList2.add(bvVar7);
                    bv bvVar8 = new bv();
                    bvVar8.eji = bwVar;
                    bvVar8.position = i;
                    bvVar8.eoZ = true;
                    arrayList2.add(bvVar8);
                    if (bwVar.bkk() != null) {
                        bv bvVar9 = new bv();
                        bvVar9.epd = true;
                        bvVar9.eji = bwVar;
                        bvVar9.position = i;
                        arrayList2.add(bvVar9);
                    }
                    bv bvVar10 = new bv();
                    bvVar10.epc = true;
                    bvVar10.eji = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                    bv bvVar11 = new bv();
                    bvVar11.eoX = true;
                    bvVar11.eji = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                } else if (bwVar.getType() == bw.epz && bwVar.bgP()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (k.ab(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar12 = new bv();
                    bvVar12.eji = bwVar;
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
        com.baidu.tbadk.a.a.a.aN(arrayList2);
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
        return (this.jqp == null || y.isEmpty(this.jqp)) ? false : true;
    }
}
