package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.b;
import com.baidu.tieba.ala.alasquare.live_tab.b.c;
import com.baidu.tieba.ala.alasquare.live_tab.b.d;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<m> cLa;
    private List<m> ejx;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private c officialRecommendLiveInfo;
    private e stageLiveInfo;
    private f superEntranceInfo;
    private h tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> ejy = new ArrayList();
    private List<bj> ejz = new ArrayList();
    private List<m> ejA = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        aZZ();
    }

    private void aZZ() {
        this.ejx = new ArrayList();
        if (this.superEntranceInfo != null) {
            g gVar = new g();
            gVar.ehA = this.superEntranceInfo;
            this.ejx.add(gVar);
        }
        if (this.stageLiveInfo != null && this.stageLiveInfo.aZN() && this.stageLiveInfo.isValid()) {
            d dVar = new d();
            dVar.eht = this.stageLiveInfo;
            this.ejx.add(dVar);
            this.ejy.add(this.stageLiveInfo.ehu.getTid());
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> baa = baa();
            if (!v.isEmpty(baa)) {
                this.ejx.addAll(baa);
            }
        }
        if (this.officialRecommendLiveInfo != null && this.officialRecommendLiveInfo.ehr && !v.isEmpty(this.officialRecommendLiveInfo.eho)) {
            b bVar = new b();
            bVar.ehq = this.officialRecommendLiveInfo;
            this.ejx.add(bVar);
        }
        this.cLa = new ArrayList(this.ejx);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> baa() {
        ArrayList<bj> arrayList = this.hotLiveInfo.eho;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (bj bjVar : arrayList) {
            if (bjVar != null) {
                String tid = bjVar.getTid();
                if (!this.ejy.contains(tid)) {
                    arrayList2.add(bjVar);
                    this.ejy.add(tid);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bj(arrayList2);
        }
        return null;
    }

    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        boolean b = b(hVar);
        this.hasMore = hVar.hasMore;
        return b;
    }

    private boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        ArrayList<bj> arrayList = hVar.eho;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<bj> it = arrayList.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                String tid = next.getTid();
                if (!this.ejy.contains(tid)) {
                    arrayList2.add(next);
                    this.ejy.add(tid);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.ejz.addAll(arrayList2);
        this.ejA = bj(this.ejz);
        return !v.isEmpty(this.ejA);
    }

    private ArrayList<m> bj(List<bj> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            i iVar = new i();
            com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
            bVar.eft = list.get(i);
            bVar.isLeft = true;
            iVar.ehC = bVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                bVar2.eft = list.get(i + 1);
                iVar.ehD = bVar2;
                bVar2.isRight = true;
            } else {
                bVar.isLeft = false;
                bVar.efw = true;
            }
            arrayList.add(iVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean bab() {
        return !v.isEmpty(this.ejy);
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.cLa)) {
            arrayList.addAll(this.cLa);
        }
        if (!v.isEmpty(this.ejA)) {
            arrayList.addAll(this.ejA);
        }
        return arrayList;
    }

    public void clear() {
        this.superEntranceInfo = null;
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.ejx != null) {
            this.ejx.clear();
        }
        if (this.cLa != null) {
            this.cLa.clear();
        }
        if (this.ejy != null) {
            this.ejy.clear();
        }
        if (this.ejz != null) {
            this.ejz.clear();
        }
        if (this.ejA != null) {
            this.ejA.clear();
        }
    }
}
