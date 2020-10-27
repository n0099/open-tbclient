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
/* loaded from: classes21.dex */
public class d extends bw {
    public List<com.baidu.tieba.card.data.c> fIa;
    public String jJe;
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
            this.jJe = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.fIa = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nY(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (bwVar.isShareThread) {
                            com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                            lVar2.erH = bwVar;
                            lVar = lVar2;
                        } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            lVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                            lVar3.erH = bwVar;
                            lVar = lVar3;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.IL("c10816");
                            this.fIa.add(lVar);
                        }
                    }
                }
                dL(this.fIa);
                dM(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new av();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void dL(List<com.baidu.tieba.card.data.c> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.c cVar = list.get(list.size() - 1);
            if (cVar.bhz() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(cVar.bhz().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.fIa = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nY(5);
                        com.baidu.tieba.card.data.m mVar = null;
                        if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            mVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
                            lVar.erH = bwVar;
                            mVar = lVar;
                        }
                        if (mVar != null && mVar.isValid()) {
                            mVar.IL("c10816");
                            this.fIa.add(mVar);
                        }
                    }
                }
                dL(this.fIa);
                dM(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new av();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dM(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.a(threadInfo);
            bwVar.bjC();
            this.list.add(bwVar);
        }
    }

    private void a(ArrayList<q> arrayList, bj bjVar) {
        int i;
        if (bjVar != null && !y.isEmpty(bjVar.bjg())) {
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
                if (bwVar.getType() == bw.exJ) {
                    bv bvVar = new bv();
                    bvVar.erH = bwVar;
                    bvVar.position = i;
                    bvVar.exo = true;
                    arrayList2.add(bvVar);
                    bv bvVar2 = new bv();
                    bvVar2.erH = bwVar;
                    bvVar2.position = i;
                    if (bwVar.blV()) {
                        bvVar2.exu = true;
                    } else if (bwVar.blg() == 1) {
                        bvVar2.exr = true;
                        bvVar2.exG = imageWidthAndHeight[0];
                        bvVar2.exH = imageWidthAndHeight[1];
                    } else if (bwVar.blg() >= 2) {
                        bvVar2.exs = true;
                    } else {
                        bvVar2.exp = true;
                    }
                    arrayList2.add(bvVar2);
                    if (bwVar.bmd() != null) {
                        bv bvVar3 = new bv();
                        bvVar3.exB = true;
                        bvVar3.erH = bwVar;
                        bvVar3.position = i;
                        arrayList2.add(bvVar3);
                    }
                    bv bvVar4 = new bv();
                    bvVar4.exA = true;
                    bvVar4.erH = bwVar;
                    bvVar4.position = i;
                    arrayList2.add(bvVar4);
                    bv bvVar5 = new bv();
                    bvVar5.exv = true;
                    bvVar5.erH = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                } else if (bwVar.getType() == bw.eyg) {
                    bv bvVar6 = new bv();
                    bvVar6.erH = bwVar;
                    bvVar6.position = i;
                    bvVar6.exo = true;
                    arrayList2.add(bvVar6);
                    bv bvVar7 = new bv();
                    bvVar7.erH = bwVar;
                    bvVar7.position = i;
                    bvVar7.exx = true;
                    arrayList2.add(bvVar7);
                    if (bwVar.bmd() != null) {
                        bv bvVar8 = new bv();
                        bvVar8.exB = true;
                        bvVar8.erH = bwVar;
                        bvVar8.position = i;
                        arrayList2.add(bvVar8);
                    }
                    bv bvVar9 = new bv();
                    bvVar9.exA = true;
                    bvVar9.erH = bwVar;
                    bvVar9.position = i;
                    arrayList2.add(bvVar9);
                    bv bvVar10 = new bv();
                    bvVar10.exv = true;
                    bvVar10.erH = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                } else if (bwVar.getType() == bw.exX && bwVar.biI()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (com.baidu.tieba.card.data.k.ab(bwVar)) {
                    com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar11 = new bv();
                    bvVar11.erH = bwVar;
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
        com.baidu.tbadk.a.a.a.aX(arrayList2);
        return arrayList2;
    }
}
