package com.baidu.tieba.hottopic.data;

import android.support.annotation.NonNull;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class d extends by {
    public List<com.baidu.tieba.card.data.b> fVe;
    public String kdr;
    public long lastId;
    public List<q> list = new ArrayList();
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
            this.kdr = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.fVe = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        by byVar = new by();
                        byVar.a(threadInfo);
                        byVar.oC(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (byVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.eCR = byVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ad(byVar)) {
                            kVar = new com.baidu.tieba.card.data.l(byVar);
                        } else if (com.baidu.tieba.card.data.k.ad(byVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.eCR = byVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.Jt("c10816");
                            this.fVe.add(kVar);
                        }
                    }
                }
                ee(this.fVe);
                ef(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new ax();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void ee(List<com.baidu.tieba.card.data.b> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.b bVar = list.get(list.size() - 1);
            if (bVar.bmn() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(bVar.bmn().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.fVe = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        by byVar = new by();
                        byVar.a(threadInfo);
                        byVar.oC(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ad(byVar)) {
                            lVar = new com.baidu.tieba.card.data.l(byVar);
                        } else if (com.baidu.tieba.card.data.k.ad(byVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.eCR = byVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.Jt("c10816");
                            this.fVe.add(lVar);
                        }
                    }
                }
                ee(this.fVe);
                ef(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new ax();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void ef(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            by byVar = new by();
            byVar.a(threadInfo);
            byVar.bor();
            this.list.add(byVar);
        }
    }

    private void a(ArrayList<q> arrayList, bl blVar) {
        int i;
        if (blVar != null && !y.isEmpty(blVar.bnV())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof by)) {
                    i = i3;
                } else if (blVar.floorPosition == i3) {
                    y.add(arrayList, i2, blVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                y.add(arrayList, blVar);
            }
        }
    }

    public ArrayList<q> e(bl blVar) {
        ArrayList<q> arrayList = new ArrayList<>(this.list);
        a(arrayList, blVar);
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof by) {
                by byVar = (by) next;
                int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                if (byVar.getType() == by.eIS) {
                    bx bxVar = new bx();
                    bxVar.eCR = byVar;
                    bxVar.position = i;
                    bxVar.eIy = true;
                    arrayList2.add(bxVar);
                    bx bxVar2 = new bx();
                    bxVar2.eCR = byVar;
                    bxVar2.position = i;
                    if (byVar.bqM()) {
                        bxVar2.eID = true;
                    } else if (byVar.bpX() == 1) {
                        bxVar2.eIB = true;
                        bxVar2.eIP = imageWidthAndHeight[0];
                        bxVar2.eIQ = imageWidthAndHeight[1];
                    } else if (byVar.bpX() >= 2) {
                        bxVar2.eIC = true;
                    } else {
                        bxVar2.eIz = true;
                    }
                    arrayList2.add(bxVar2);
                    if (byVar.bqV() != null) {
                        bx bxVar3 = new bx();
                        bxVar3.eIK = true;
                        bxVar3.eCR = byVar;
                        bxVar3.position = i;
                        arrayList2.add(bxVar3);
                    }
                    bx bxVar4 = new bx();
                    bxVar4.eIJ = true;
                    bxVar4.eCR = byVar;
                    bxVar4.position = i;
                    arrayList2.add(bxVar4);
                    bx bxVar5 = new bx();
                    bxVar5.eIE = true;
                    bxVar5.eCR = byVar;
                    bxVar5.position = i;
                    arrayList2.add(bxVar5);
                } else if (byVar.getType() == by.eJq) {
                    bx bxVar6 = new bx();
                    bxVar6.eCR = byVar;
                    bxVar6.position = i;
                    bxVar6.eIy = true;
                    arrayList2.add(bxVar6);
                    bx bxVar7 = new bx();
                    bxVar7.eCR = byVar;
                    bxVar7.position = i;
                    bxVar7.eIG = true;
                    arrayList2.add(bxVar7);
                    if (byVar.bqV() != null) {
                        bx bxVar8 = new bx();
                        bxVar8.eIK = true;
                        bxVar8.eCR = byVar;
                        bxVar8.position = i;
                        arrayList2.add(bxVar8);
                    }
                    bx bxVar9 = new bx();
                    bxVar9.eIJ = true;
                    bxVar9.eCR = byVar;
                    bxVar9.position = i;
                    arrayList2.add(bxVar9);
                    bx bxVar10 = new bx();
                    bxVar10.eIE = true;
                    bxVar10.eCR = byVar;
                    bxVar10.position = i;
                    arrayList2.add(bxVar10);
                } else if (byVar.getType() == by.eJh && byVar.bnx()) {
                    byVar.position = i;
                    arrayList2.add(byVar);
                } else if (com.baidu.tieba.card.data.j.ad(byVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(byVar);
                    jVar.tid = byVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bx bxVar11 = new bx();
                    bxVar11.eCR = byVar;
                    bxVar11.position = i;
                    arrayList2.add(bxVar11);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        com.baidu.tbadk.a.a.a.bh(arrayList2);
        return arrayList2;
    }
}
