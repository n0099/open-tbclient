package com.baidu.tieba.hottopic.data;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class d extends bz {
    public List<com.baidu.tieba.card.data.b> gaa;
    public String klY;
    public long lastId;
    public List<com.baidu.adp.widget.ListView.n> list = new ArrayList();
    public ax pageData;
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
            this.klY = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.gaa = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bz bzVar = new bz();
                        bzVar.a(threadInfo);
                        bzVar.ng(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (bzVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.eHK = bzVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ad(bzVar)) {
                            kVar = new com.baidu.tieba.card.data.l(bzVar);
                        } else if (com.baidu.tieba.card.data.k.ad(bzVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.eHK = bzVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.If("c10816");
                            this.gaa.add(kVar);
                        }
                    }
                }
                el(this.gaa);
                em(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new ax();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void el(List<com.baidu.tieba.card.data.b> list) {
        if (!x.isEmpty(list)) {
            com.baidu.tieba.card.data.b bVar = list.get(list.size() - 1);
            if (bVar.bkV() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(bVar.bkV().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.gaa = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bz bzVar = new bz();
                        bzVar.a(threadInfo);
                        bzVar.ng(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ad(bzVar)) {
                            lVar = new com.baidu.tieba.card.data.l(bzVar);
                        } else if (com.baidu.tieba.card.data.k.ad(bzVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.eHK = bzVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.If("c10816");
                            this.gaa.add(lVar);
                        }
                    }
                }
                el(this.gaa);
                em(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new ax();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void em(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bz bzVar = new bz();
            bzVar.a(threadInfo);
            bzVar.bmZ();
            this.list.add(bzVar);
        }
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, bm bmVar) {
        int i;
        if (bmVar != null && !x.isEmpty(bmVar.bmD())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof bz)) {
                    i = i3;
                } else if (bmVar.floorPosition == i3) {
                    x.add(arrayList, i2, bmVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                x.add(arrayList, bmVar);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> e(bm bmVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(this.list);
        a(arrayList, bmVar);
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if (next instanceof bz) {
                bz bzVar = (bz) next;
                int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                if (bzVar.getType() == bz.eOa) {
                    by byVar = new by();
                    byVar.eHK = bzVar;
                    byVar.position = i;
                    byVar.eNF = true;
                    arrayList2.add(byVar);
                    by byVar2 = new by();
                    byVar2.eHK = bzVar;
                    byVar2.position = i;
                    if (bzVar.bpv()) {
                        byVar2.eNK = true;
                    } else if (bzVar.boF() == 1) {
                        byVar2.eNI = true;
                        byVar2.eNX = imageWidthAndHeight[0];
                        byVar2.eNY = imageWidthAndHeight[1];
                    } else if (bzVar.boF() >= 2) {
                        byVar2.eNJ = true;
                    } else {
                        byVar2.eNG = true;
                    }
                    arrayList2.add(byVar2);
                    if (bzVar.bpE() != null) {
                        by byVar3 = new by();
                        byVar3.eNS = true;
                        byVar3.eHK = bzVar;
                        byVar3.position = i;
                        arrayList2.add(byVar3);
                    }
                    by byVar4 = new by();
                    byVar4.eNR = true;
                    byVar4.eHK = bzVar;
                    byVar4.position = i;
                    arrayList2.add(byVar4);
                    by byVar5 = new by();
                    byVar5.eNL = true;
                    byVar5.eHK = bzVar;
                    byVar5.position = i;
                    arrayList2.add(byVar5);
                } else if (bzVar.getType() == bz.eOy) {
                    by byVar6 = new by();
                    byVar6.eHK = bzVar;
                    byVar6.position = i;
                    byVar6.eNF = true;
                    arrayList2.add(byVar6);
                    by byVar7 = new by();
                    byVar7.eHK = bzVar;
                    byVar7.position = i;
                    byVar7.eNN = true;
                    arrayList2.add(byVar7);
                    if (bzVar.bpE() != null) {
                        by byVar8 = new by();
                        byVar8.eNS = true;
                        byVar8.eHK = bzVar;
                        byVar8.position = i;
                        arrayList2.add(byVar8);
                    }
                    by byVar9 = new by();
                    byVar9.eNR = true;
                    byVar9.eHK = bzVar;
                    byVar9.position = i;
                    arrayList2.add(byVar9);
                    by byVar10 = new by();
                    byVar10.eNL = true;
                    byVar10.eHK = bzVar;
                    byVar10.position = i;
                    arrayList2.add(byVar10);
                } else if (bzVar.getType() == bz.eOp && bzVar.bme()) {
                    bzVar.position = i;
                    arrayList2.add(bzVar);
                } else if (com.baidu.tieba.card.data.j.ad(bzVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(bzVar);
                    jVar.tid = bzVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    by byVar11 = new by();
                    byVar11.eHK = bzVar;
                    byVar11.position = i;
                    arrayList2.add(byVar11);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.bo(arrayList2);
        return arrayList2;
    }
}
