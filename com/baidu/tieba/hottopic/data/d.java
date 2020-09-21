package com.baidu.tieba.hottopic.data;

import android.support.annotation.NonNull;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class d extends bw {
    public List<com.baidu.tieba.card.data.c> fnr;
    public String jhG;
    public long lastId;
    public List<q> list = new ArrayList();
    public av pageData;
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
            this.jhG = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.fnr = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nq(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (bwVar.isShareThread) {
                            com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                            lVar2.dXg = bwVar;
                            lVar = lVar2;
                        } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            lVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                            lVar3.dXg = bwVar;
                            lVar = lVar3;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.Hz("c10816");
                            this.fnr.add(lVar);
                        }
                    }
                }
                dz(this.fnr);
                dA(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new av();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void dz(List<com.baidu.tieba.card.data.c> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.c cVar = list.get(list.size() - 1);
            if (cVar.bcY() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(cVar.bcY().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.fnr = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nq(5);
                        com.baidu.tieba.card.data.m mVar = null;
                        if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            mVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
                            lVar.dXg = bwVar;
                            mVar = lVar;
                        }
                        if (mVar != null && mVar.isValid()) {
                            mVar.Hz("c10816");
                            this.fnr.add(mVar);
                        }
                    }
                }
                dz(this.fnr);
                dA(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new av();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dA(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.a(threadInfo);
            bwVar.bfa();
            this.list.add(bwVar);
        }
    }

    private void a(ArrayList<q> arrayList, bj bjVar) {
        int i;
        if (bjVar != null && !y.isEmpty(bjVar.beE())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof bw)) {
                    i = i3;
                } else if (bjVar.floorPosition == i3) {
                    y.add(arrayList, i2, bjVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                y.add(arrayList, bjVar);
            }
        }
    }

    public ArrayList<q> e(bj bjVar) {
        ArrayList<q> arrayList = new ArrayList<>(this.list);
        a(arrayList, bjVar);
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bw) {
                bw bwVar = (bw) next;
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                if (bwVar.getType() == bw.edg) {
                    bv bvVar = new bv();
                    bvVar.dXg = bwVar;
                    bvVar.position = i;
                    bvVar.ecM = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.dXg = bwVar;
                    bvVar2.position = i;
                    if (bwVar.bht()) {
                        bvVar2.ecR = true;
                    } else if (bwVar.bgE() == 1) {
                        bvVar2.ecP = true;
                        bvVar2.edd = imageWidthAndHeight[0];
                        bvVar2.ede = imageWidthAndHeight[1];
                    } else if (bwVar.bgE() >= 2) {
                        bvVar2.ecQ = true;
                    } else {
                        bvVar2.ecN = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bhB() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.ecY = true;
                        bvVar3.dXg = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    bv bvVar4 = new bv();
                    bvVar4.ecX = true;
                    bvVar4.dXg = bwVar;
                    bvVar4.position = i;
                    arrayList2.add(bvVar4);
                    bv bvVar5 = new bv();
                    bvVar5.ecS = true;
                    bvVar5.dXg = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                } else if (bwVar.getType() == bw.edC) {
                    bv bvVar6 = new bv();
                    bvVar6.dXg = bwVar;
                    bvVar6.position = i;
                    bvVar6.ecM = true;
                    arrayList2.add(bvVar6);
                    bv bvVar7 = new bv();
                    bvVar7.dXg = bwVar;
                    bvVar7.position = i;
                    bvVar7.ecU = true;
                    arrayList2.add(bvVar7);
                    if (bwVar.bhB() != null) {
                        bv bvVar8 = new bv();
                        bvVar8.ecY = true;
                        bvVar8.dXg = bwVar;
                        bvVar8.position = i;
                        arrayList2.add(bvVar8);
                    }
                    bv bvVar9 = new bv();
                    bvVar9.ecX = true;
                    bvVar9.dXg = bwVar;
                    bvVar9.position = i;
                    arrayList2.add(bvVar9);
                    bv bvVar10 = new bv();
                    bvVar10.ecS = true;
                    bvVar10.dXg = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                } else if (bwVar.getType() == bw.edu && bwVar.beg()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (com.baidu.tieba.card.data.k.ab(bwVar)) {
                    com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar11 = new bv();
                    bvVar11.dXg = bwVar;
                    bvVar11.position = i;
                    arrayList2.add(bvVar11);
                }
            } else if (next instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.aK(arrayList2);
        return arrayList2;
    }
}
