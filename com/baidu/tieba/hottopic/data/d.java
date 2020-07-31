package com.baidu.tieba.hottopic.data;

import android.support.annotation.NonNull;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes15.dex */
public class d extends bv {
    public List<com.baidu.tieba.card.data.c> eZc;
    public String iJV;
    public long lastId;
    public List<q> list = new ArrayList();
    public au pageData;
    public int sortType;

    public d() {
        this.sortType = 1;
        this.sortType = 1;
    }

    public d(int i) {
        this.sortType = 1;
        this.sortType = i;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.iJV = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.eZc = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bv bvVar = new bv();
                        bvVar.a(threadInfo);
                        bvVar.kZ(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (bvVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.dLK = bvVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.aa(bvVar)) {
                            kVar = new com.baidu.tieba.card.data.l(bvVar);
                        } else if (com.baidu.tieba.card.data.k.aa(bvVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.dLK = bvVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.EC("c10816");
                            this.eZc.add(kVar);
                        }
                    }
                }
                dk(this.eZc);
                dl(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new au();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void dk(List<com.baidu.tieba.card.data.c> list) {
        if (!x.isEmpty(list)) {
            com.baidu.tieba.card.data.c cVar = list.get(list.size() - 1);
            if (cVar.aTN() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(cVar.aTN().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.eZc = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bv bvVar = new bv();
                        bvVar.a(threadInfo);
                        bvVar.kZ(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.aa(bvVar)) {
                            lVar = new com.baidu.tieba.card.data.l(bvVar);
                        } else if (com.baidu.tieba.card.data.k.aa(bvVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.dLK = bvVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.EC("c10816");
                            this.eZc.add(lVar);
                        }
                    }
                }
                dk(this.eZc);
                dl(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new au();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dl(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bv bvVar = new bv();
            bvVar.a(threadInfo);
            bvVar.aVN();
            this.list.add(bvVar);
        }
    }

    private void a(ArrayList<q> arrayList, bi biVar) {
        int i;
        if (biVar != null && !x.isEmpty(biVar.aVr())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof bv)) {
                    i = i3;
                } else if (biVar.floorPosition == i3) {
                    x.add(arrayList, i2, biVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                x.add(arrayList, biVar);
            }
        }
    }

    public ArrayList<q> e(bi biVar) {
        ArrayList<q> arrayList = new ArrayList<>(this.list);
        a(arrayList, biVar);
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
                    bu buVar4 = new bu();
                    buVar4.dRp = true;
                    buVar4.dLK = bvVar;
                    buVar4.position = i;
                    arrayList2.add(buVar4);
                    bu buVar5 = new bu();
                    buVar5.dRk = true;
                    buVar5.dLK = bvVar;
                    buVar5.position = i;
                    arrayList2.add(buVar5);
                } else if (bvVar.getType() == bv.dRS) {
                    bu buVar6 = new bu();
                    buVar6.dLK = bvVar;
                    buVar6.position = i;
                    buVar6.dRe = true;
                    arrayList2.add(buVar6);
                    bu buVar7 = new bu();
                    buVar7.dLK = bvVar;
                    buVar7.position = i;
                    buVar7.dRm = true;
                    arrayList2.add(buVar7);
                    if (bvVar.aYo() != null) {
                        bu buVar8 = new bu();
                        buVar8.dRq = true;
                        buVar8.dLK = bvVar;
                        buVar8.position = i;
                        arrayList2.add(buVar8);
                    }
                    bu buVar9 = new bu();
                    buVar9.dRp = true;
                    buVar9.dLK = bvVar;
                    buVar9.position = i;
                    arrayList2.add(buVar9);
                    bu buVar10 = new bu();
                    buVar10.dRk = true;
                    buVar10.dLK = bvVar;
                    buVar10.position = i;
                    arrayList2.add(buVar10);
                } else if (bvVar.getType() == bv.dRK && bvVar.aUT()) {
                    bvVar.position = i;
                    arrayList2.add(bvVar);
                } else if (com.baidu.tieba.card.data.j.aa(bvVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(bvVar);
                    jVar.tid = bvVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bu buVar11 = new bu();
                    buVar11.dLK = bvVar;
                    buVar11.position = i;
                    arrayList2.add(buVar11);
                }
            } else if (next instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.aG(arrayList2);
        return arrayList2;
    }
}
