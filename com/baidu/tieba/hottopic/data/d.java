package com.baidu.tieba.hottopic.data;

import android.support.annotation.NonNull;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d extends bu {
    public List<com.baidu.tieba.card.data.c> eSH;
    public String iDR;
    public long lastId;
    public List<q> list = new ArrayList();
    public at pageData;
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
            this.iDR = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.eSH = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bu buVar = new bu();
                        buVar.a(threadInfo);
                        buVar.kF(5);
                        com.baidu.tieba.card.data.k kVar = null;
                        if (buVar.isShareThread) {
                            com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                            kVar2.dLi = buVar;
                            kVar = kVar2;
                        } else if (com.baidu.tieba.card.data.l.ad(buVar)) {
                            kVar = new com.baidu.tieba.card.data.l(buVar);
                        } else if (com.baidu.tieba.card.data.k.ad(buVar)) {
                            com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                            kVar3.dLi = buVar;
                            kVar = kVar3;
                        }
                        if (kVar != null && kVar.isValid()) {
                            kVar.DR("c10816");
                            this.eSH.add(kVar);
                        }
                    }
                }
                df(this.eSH);
                dg(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new at();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void df(List<com.baidu.tieba.card.data.c> list) {
        if (!w.isEmpty(list)) {
            com.baidu.tieba.card.data.c cVar = list.get(list.size() - 1);
            if (cVar.aPS() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(cVar.aPS().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.eSH = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bu buVar = new bu();
                        buVar.a(threadInfo);
                        buVar.kF(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (com.baidu.tieba.card.data.l.ad(buVar)) {
                            lVar = new com.baidu.tieba.card.data.l(buVar);
                        } else if (com.baidu.tieba.card.data.k.ad(buVar)) {
                            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
                            kVar.dLi = buVar;
                            lVar = kVar;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.DR("c10816");
                            this.eSH.add(lVar);
                        }
                    }
                }
                df(this.eSH);
                dg(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new at();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dg(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bu buVar = new bu();
            buVar.a(threadInfo);
            buVar.aRR();
            this.list.add(buVar);
        }
    }

    private void a(ArrayList<q> arrayList, bh bhVar) {
        int i;
        if (bhVar != null && !w.isEmpty(bhVar.aRv())) {
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(arrayList.get(i2) instanceof bu)) {
                    i = i3;
                } else if (bhVar.floorPosition == i3) {
                    w.add(arrayList, i2, bhVar);
                    break;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            if (size == 2) {
                w.add(arrayList, bhVar);
            }
        }
    }

    public ArrayList<q> e(bh bhVar) {
        ArrayList<q> arrayList = new ArrayList<>(this.list);
        a(arrayList, bhVar);
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bu) {
                bu buVar = (bu) next;
                int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                if (buVar.getType() == bu.dLm) {
                    bt btVar = new bt();
                    btVar.dLi = buVar;
                    btVar.position = i;
                    btVar.dKS = true;
                    arrayList2.add(btVar);
                    bt btVar2 = new bt();
                    btVar2.dLi = buVar;
                    btVar2.position = i;
                    if (buVar.aUl()) {
                        btVar2.dKX = true;
                    } else if (buVar.aTv() == 1) {
                        btVar2.dKV = true;
                        btVar2.dLj = imageWidthAndHeight[0];
                        btVar2.dLk = imageWidthAndHeight[1];
                    } else if (buVar.aTv() >= 2) {
                        btVar2.dKW = true;
                    } else {
                        btVar2.dKT = true;
                    }
                    arrayList2.add(btVar2);
                    if (buVar.aUu() != null) {
                        bt btVar3 = new bt();
                        btVar3.dLe = true;
                        btVar3.dLi = buVar;
                        btVar3.position = i;
                        arrayList2.add(btVar3);
                    }
                    bt btVar4 = new bt();
                    btVar4.dLd = true;
                    btVar4.dLi = buVar;
                    btVar4.position = i;
                    arrayList2.add(btVar4);
                    bt btVar5 = new bt();
                    btVar5.dKY = true;
                    btVar5.dLi = buVar;
                    btVar5.position = i;
                    arrayList2.add(btVar5);
                } else if (buVar.getType() == bu.dLH) {
                    bt btVar6 = new bt();
                    btVar6.dLi = buVar;
                    btVar6.position = i;
                    btVar6.dKS = true;
                    arrayList2.add(btVar6);
                    bt btVar7 = new bt();
                    btVar7.dLi = buVar;
                    btVar7.position = i;
                    btVar7.dLa = true;
                    arrayList2.add(btVar7);
                    if (buVar.aUu() != null) {
                        bt btVar8 = new bt();
                        btVar8.dLe = true;
                        btVar8.dLi = buVar;
                        btVar8.position = i;
                        arrayList2.add(btVar8);
                    }
                    bt btVar9 = new bt();
                    btVar9.dLd = true;
                    btVar9.dLi = buVar;
                    btVar9.position = i;
                    arrayList2.add(btVar9);
                    bt btVar10 = new bt();
                    btVar10.dKY = true;
                    btVar10.dLi = buVar;
                    btVar10.position = i;
                    arrayList2.add(btVar10);
                } else if (buVar.getType() == bu.dLz && buVar.aQX()) {
                    buVar.position = i;
                    arrayList2.add(buVar);
                } else if (com.baidu.tieba.card.data.j.ad(buVar)) {
                    com.baidu.tieba.card.data.j jVar = new com.baidu.tieba.card.data.j(buVar);
                    jVar.tid = buVar.getTid();
                    arrayList2.add(jVar);
                } else {
                    bt btVar11 = new bt();
                    btVar11.dLi = buVar;
                    btVar11.position = i;
                    arrayList2.add(btVar11);
                }
            } else if (next instanceof com.baidu.tieba.card.data.b) {
                ((com.baidu.tieba.card.data.b) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        return arrayList2;
    }
}
