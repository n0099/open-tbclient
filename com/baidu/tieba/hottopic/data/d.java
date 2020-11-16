package com.baidu.tieba.hottopic.data;

import android.support.annotation.NonNull;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class d extends bx {
    public List<com.baidu.tieba.card.data.b> fNt;
    public String jPM;
    public long lastId;
    public List<q> list = new ArrayList();
    public aw pageData;
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
            this.jPM = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.fNt = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bx bxVar = new bx();
                        bxVar.a(threadInfo);
                        bxVar.oe(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (bxVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.evQ = bxVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ad(bxVar)) {
                            kVar = new com.baidu.tieba.card.data.l(bxVar);
                        } else if (com.baidu.tieba.card.data.k.ad(bxVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.evQ = bxVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.ID("c10816");
                            this.fNt.add(kVar);
                        }
                    }
                }
                dT(this.fNt);
                dU(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new aw();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void dT(List<com.baidu.tieba.card.data.b> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.b bVar = list.get(list.size() - 1);
            if (bVar.bjd() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(bVar.bjd().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.fNt = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bx bxVar = new bx();
                        bxVar.a(threadInfo);
                        bxVar.oe(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ad(bxVar)) {
                            lVar = new com.baidu.tieba.card.data.l(bxVar);
                        } else if (com.baidu.tieba.card.data.k.ad(bxVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.evQ = bxVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.ID("c10816");
                            this.fNt.add(lVar);
                        }
                    }
                }
                dT(this.fNt);
                dU(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new aw();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dU(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bx bxVar = new bx();
            bxVar.a(threadInfo);
            bxVar.ble();
            this.list.add(bxVar);
        }
    }

    private void a(ArrayList<q> arrayList, bk bkVar) {
        int i;
        if (bkVar != null && !y.isEmpty(bkVar.bkI())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof bx)) {
                    i = i3;
                } else if (bkVar.floorPosition == i3) {
                    y.add(arrayList, i2, bkVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                y.add(arrayList, bkVar);
            }
        }
    }

    public ArrayList<q> e(bk bkVar) {
        ArrayList<q> arrayList = new ArrayList<>(this.list);
        a(arrayList, bkVar);
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bx) {
                bx bxVar = (bx) next;
                int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
                if (bxVar.getType() == bx.eBR) {
                    bw bwVar = new bw();
                    bwVar.evQ = bxVar;
                    bwVar.position = i;
                    bwVar.eBx = true;
                    arrayList2.add(bwVar);
                    bw bwVar2 = new bw();
                    bwVar2.evQ = bxVar;
                    bwVar2.position = i;
                    if (bxVar.bnz()) {
                        bwVar2.eBC = true;
                    } else if (bxVar.bmK() == 1) {
                        bwVar2.eBA = true;
                        bwVar2.eBO = imageWidthAndHeight[0];
                        bwVar2.eBP = imageWidthAndHeight[1];
                    } else if (bxVar.bmK() >= 2) {
                        bwVar2.eBB = true;
                    } else {
                        bwVar2.eBy = true;
                    }
                    arrayList2.add(bwVar2);
                    if (bxVar.bnH() != null) {
                        bw bwVar3 = new bw();
                        bwVar3.eBJ = true;
                        bwVar3.evQ = bxVar;
                        bwVar3.position = i;
                        arrayList2.add(bwVar3);
                    }
                    bw bwVar4 = new bw();
                    bwVar4.eBI = true;
                    bwVar4.evQ = bxVar;
                    bwVar4.position = i;
                    arrayList2.add(bwVar4);
                    bw bwVar5 = new bw();
                    bwVar5.eBD = true;
                    bwVar5.evQ = bxVar;
                    bwVar5.position = i;
                    arrayList2.add(bwVar5);
                } else if (bxVar.getType() == bx.eCo) {
                    bw bwVar6 = new bw();
                    bwVar6.evQ = bxVar;
                    bwVar6.position = i;
                    bwVar6.eBx = true;
                    arrayList2.add(bwVar6);
                    bw bwVar7 = new bw();
                    bwVar7.evQ = bxVar;
                    bwVar7.position = i;
                    bwVar7.eBF = true;
                    arrayList2.add(bwVar7);
                    if (bxVar.bnH() != null) {
                        bw bwVar8 = new bw();
                        bwVar8.eBJ = true;
                        bwVar8.evQ = bxVar;
                        bwVar8.position = i;
                        arrayList2.add(bwVar8);
                    }
                    bw bwVar9 = new bw();
                    bwVar9.eBI = true;
                    bwVar9.evQ = bxVar;
                    bwVar9.position = i;
                    arrayList2.add(bwVar9);
                    bw bwVar10 = new bw();
                    bwVar10.eBD = true;
                    bwVar10.evQ = bxVar;
                    bwVar10.position = i;
                    arrayList2.add(bwVar10);
                } else if (bxVar.getType() == bx.eCg && bxVar.bkk()) {
                    bxVar.position = i;
                    arrayList2.add(bxVar);
                } else if (com.baidu.tieba.card.data.j.ad(bxVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(bxVar);
                    jVar.tid = bxVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bw bwVar11 = new bw();
                    bwVar11.evQ = bxVar;
                    bwVar11.position = i;
                    arrayList2.add(bwVar11);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.be(arrayList2);
        return arrayList2;
    }
}
