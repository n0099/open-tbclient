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
    public List<com.baidu.tieba.card.data.c> fzF;
    public String jwF;
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
            this.jwF = hotThread.hot_title;
            if (hotThread.thread_list != null) {
                this.fzF = new ArrayList();
                for (ThreadInfo threadInfo : hotThread.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nN(5);
                        com.baidu.tieba.card.data.l lVar = null;
                        if (bwVar.isShareThread) {
                            com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                            lVar2.eji = bwVar;
                            lVar = lVar2;
                        } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            lVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                            lVar3.eji = bwVar;
                            lVar = lVar3;
                        }
                        if (lVar != null && lVar.isValid()) {
                            lVar.Im("c10816");
                            this.fzF.add(lVar);
                        }
                    }
                }
                dC(this.fzF);
                dD(hotThread.thread_list);
            }
            if (hotThread.page != null) {
                this.pageData = new av();
                this.pageData.a(hotThread.page);
            }
        }
    }

    private void dC(List<com.baidu.tieba.card.data.c> list) {
        if (!y.isEmpty(list)) {
            com.baidu.tieba.card.data.c cVar = list.get(list.size() - 1);
            if (cVar.bfG() != null) {
                this.lastId = com.baidu.adp.lib.f.b.toLong(cVar.bfG().getTid(), 0L);
            }
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.thread_list != null) {
                this.fzF = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bw bwVar = new bw();
                        bwVar.a(threadInfo);
                        bwVar.nN(5);
                        com.baidu.tieba.card.data.m mVar = null;
                        if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                            mVar = new com.baidu.tieba.card.data.m(bwVar);
                        } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
                            lVar.eji = bwVar;
                            mVar = lVar;
                        }
                        if (mVar != null && mVar.isValid()) {
                            mVar.Im("c10816");
                            this.fzF.add(mVar);
                        }
                    }
                }
                dC(this.fzF);
                dD(dataRes.thread_list);
            }
            if (dataRes.page != null) {
                this.pageData = new av();
                this.pageData.a(dataRes.page);
            }
        }
    }

    private void dD(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            bw bwVar = new bw();
            bwVar.a(threadInfo);
            bwVar.bhJ();
            this.list.add(bwVar);
        }
    }

    private void a(ArrayList<q> arrayList, bj bjVar) {
        int i;
        if (bjVar != null && !y.isEmpty(bjVar.bhn())) {
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
                    bv bvVar4 = new bv();
                    bvVar4.epc = true;
                    bvVar4.eji = bwVar;
                    bvVar4.position = i;
                    arrayList2.add(bvVar4);
                    bv bvVar5 = new bv();
                    bvVar5.eoX = true;
                    bvVar5.eji = bwVar;
                    bvVar5.position = i;
                    arrayList2.add(bvVar5);
                } else if (bwVar.getType() == bw.epH) {
                    bv bvVar6 = new bv();
                    bvVar6.eji = bwVar;
                    bvVar6.position = i;
                    bvVar6.eoR = true;
                    arrayList2.add(bvVar6);
                    bv bvVar7 = new bv();
                    bvVar7.eji = bwVar;
                    bvVar7.position = i;
                    bvVar7.eoZ = true;
                    arrayList2.add(bvVar7);
                    if (bwVar.bkk() != null) {
                        bv bvVar8 = new bv();
                        bvVar8.epd = true;
                        bvVar8.eji = bwVar;
                        bvVar8.position = i;
                        arrayList2.add(bvVar8);
                    }
                    bv bvVar9 = new bv();
                    bvVar9.epc = true;
                    bvVar9.eji = bwVar;
                    bvVar9.position = i;
                    arrayList2.add(bvVar9);
                    bv bvVar10 = new bv();
                    bvVar10.eoX = true;
                    bvVar10.eji = bwVar;
                    bvVar10.position = i;
                    arrayList2.add(bvVar10);
                } else if (bwVar.getType() == bw.epz && bwVar.bgP()) {
                    bwVar.position = i;
                    arrayList2.add(bwVar);
                } else if (com.baidu.tieba.card.data.k.ab(bwVar)) {
                    com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k(bwVar);
                    kVar.tid = bwVar.getTid();
                    arrayList2.add(kVar);
                } else {
                    bv bvVar11 = new bv();
                    bvVar11.eji = bwVar;
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
        com.baidu.tbadk.a.a.a.aN(arrayList2);
        return arrayList2;
    }
}
