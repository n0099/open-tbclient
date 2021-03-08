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
/* loaded from: classes7.dex */
public class d extends cb {
    public List<com.baidu.tieba.card.data.b> gdY;
    public String kwv;
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
            this.kwv = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.gdY = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        cb cbVar = new cb();
                        cbVar.a(threadInfo);
                        cbVar.nk(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (cbVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.eLr = cbVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                            kVar = new com.baidu.tieba.card.data.l(cbVar);
                        } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.eLr = cbVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.Ja("c10816");
                            this.gdY.add(kVar);
                        }
                    }
                }
                ej(this.gdY);
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
            if (bVar.blp() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(bVar.blp().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.gdY = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        cb cbVar = new cb();
                        cbVar.a(threadInfo);
                        cbVar.nk(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                            lVar = new com.baidu.tieba.card.data.l(cbVar);
                        } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.eLr = cbVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.Ja("c10816");
                            this.gdY.add(lVar);
                        }
                    }
                }
                ej(this.gdY);
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
            cbVar.bnu();
            this.list.add(cbVar);
        }
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, bo boVar) {
        int i;
        if (boVar != null && !y.isEmpty(boVar.bmY())) {
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
                    ca caVar4 = new ca();
                    caVar4.eRE = true;
                    caVar4.eLr = cbVar;
                    caVar4.position = i;
                    arrayList2.add(caVar4);
                    ca caVar5 = new ca();
                    caVar5.eRy = true;
                    caVar5.eLr = cbVar;
                    caVar5.position = i;
                    arrayList2.add(caVar5);
                } else if (cbVar.getType() == cb.eSl) {
                    ca caVar6 = new ca();
                    caVar6.eLr = cbVar;
                    caVar6.position = i;
                    caVar6.eRs = true;
                    arrayList2.add(caVar6);
                    ca caVar7 = new ca();
                    caVar7.eLr = cbVar;
                    caVar7.position = i;
                    caVar7.eRA = true;
                    arrayList2.add(caVar7);
                    if (cbVar.bpY() != null) {
                        ca caVar8 = new ca();
                        caVar8.eRF = true;
                        caVar8.eLr = cbVar;
                        caVar8.position = i;
                        arrayList2.add(caVar8);
                    }
                    ca caVar9 = new ca();
                    caVar9.eRE = true;
                    caVar9.eLr = cbVar;
                    caVar9.position = i;
                    arrayList2.add(caVar9);
                    ca caVar10 = new ca();
                    caVar10.eRy = true;
                    caVar10.eLr = cbVar;
                    caVar10.position = i;
                    arrayList2.add(caVar10);
                } else if (cbVar.getType() == cb.eSc && cbVar.bmz()) {
                    cbVar.position = i;
                    arrayList2.add(cbVar);
                } else if (com.baidu.tieba.card.data.j.ae(cbVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(cbVar);
                    jVar.tid = cbVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    ca caVar11 = new ca();
                    caVar11.eLr = cbVar;
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
