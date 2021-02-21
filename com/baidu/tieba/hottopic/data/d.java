package com.baidu.tieba.hottopic.data;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d extends cb {
    public List<com.baidu.tieba.card.data.b> gcy;
    public String kut;
    public long lastId;
    public List<com.baidu.adp.widget.ListView.n> list = new ArrayList();
    public az pageData;
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
            this.kut = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.gcy = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        cb cbVar = new cb();
                        cbVar.a(threadInfo);
                        cbVar.nj(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (cbVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.eJQ = cbVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                            kVar = new com.baidu.tieba.card.data.l(cbVar);
                        } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.eJQ = cbVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.IR("c10816");
                            this.gcy.add(kVar);
                        }
                    }
                }
                ej(this.gcy);
                ek(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new az();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void ej(List<com.baidu.tieba.card.data.b> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.b bVar = list.get(list.size() - 1);
            if (bVar.bln() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(bVar.bln().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.gcy = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        cb cbVar = new cb();
                        cbVar.a(threadInfo);
                        cbVar.nj(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                            lVar = new com.baidu.tieba.card.data.l(cbVar);
                        } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.eJQ = cbVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.IR("c10816");
                            this.gcy.add(lVar);
                        }
                    }
                }
                ej(this.gcy);
                ek(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new az();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void ek(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            cb cbVar = new cb();
            cbVar.a(threadInfo);
            cbVar.bns();
            this.list.add(cbVar);
        }
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, bo boVar) {
        int i;
        if (boVar != null && !y.isEmpty(boVar.bmW())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof cb)) {
                    i = i3;
                } else if (boVar.floorPosition == i3) {
                    y.add(arrayList, i2, boVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                y.add(arrayList, boVar);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> e(bo boVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(this.list);
        a(arrayList, boVar);
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
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
                    ca caVar4 = new ca();
                    caVar4.eQd = true;
                    caVar4.eJQ = cbVar;
                    caVar4.position = i;
                    arrayList2.add(caVar4);
                    ca caVar5 = new ca();
                    caVar5.ePX = true;
                    caVar5.eJQ = cbVar;
                    caVar5.position = i;
                    arrayList2.add(caVar5);
                } else if (cbVar.getType() == cb.eQK) {
                    ca caVar6 = new ca();
                    caVar6.eJQ = cbVar;
                    caVar6.position = i;
                    caVar6.ePR = true;
                    arrayList2.add(caVar6);
                    ca caVar7 = new ca();
                    caVar7.eJQ = cbVar;
                    caVar7.position = i;
                    caVar7.ePZ = true;
                    arrayList2.add(caVar7);
                    if (cbVar.bpW() != null) {
                        ca caVar8 = new ca();
                        caVar8.eQe = true;
                        caVar8.eJQ = cbVar;
                        caVar8.position = i;
                        arrayList2.add(caVar8);
                    }
                    ca caVar9 = new ca();
                    caVar9.eQd = true;
                    caVar9.eJQ = cbVar;
                    caVar9.position = i;
                    arrayList2.add(caVar9);
                    ca caVar10 = new ca();
                    caVar10.ePX = true;
                    caVar10.eJQ = cbVar;
                    caVar10.position = i;
                    arrayList2.add(caVar10);
                } else if (cbVar.getType() == cb.eQB && cbVar.bmx()) {
                    cbVar.position = i;
                    arrayList2.add(cbVar);
                } else if (com.baidu.tieba.card.data.j.ae(cbVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(cbVar);
                    jVar.tid = cbVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    ca caVar11 = new ca();
                    caVar11.eJQ = cbVar;
                    caVar11.position = i;
                    arrayList2.add(caVar11);
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
}
