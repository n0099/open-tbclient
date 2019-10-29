package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
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
/* loaded from: classes6.dex */
public class a {
    private List<m> bZG;
    private List<m> dzm;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private c officialRecommendLiveInfo;
    private e stageLiveInfo;
    private f superEntranceInfo;
    private h tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> dzn = new ArrayList();
    private List<bh> dzo = new ArrayList();
    private List<m> dzp = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        aJD();
    }

    private void aJD() {
        this.dzm = new ArrayList();
        if (this.superEntranceInfo != null) {
            g gVar = new g();
            gVar.dxp = this.superEntranceInfo;
            this.dzm.add(gVar);
        }
        if (this.stageLiveInfo != null && this.stageLiveInfo.aJr() && this.stageLiveInfo.isValid()) {
            d dVar = new d();
            dVar.dxi = this.stageLiveInfo;
            this.dzm.add(dVar);
            this.dzn.add(this.stageLiveInfo.dxj.getTid());
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> aJE = aJE();
            if (!v.isEmpty(aJE)) {
                this.dzm.addAll(aJE);
            }
        }
        if (this.officialRecommendLiveInfo != null && this.officialRecommendLiveInfo.dxg && !v.isEmpty(this.officialRecommendLiveInfo.dxd)) {
            b bVar = new b();
            bVar.dxf = this.officialRecommendLiveInfo;
            this.dzm.add(bVar);
        }
        this.bZG = new ArrayList(this.dzm);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> aJE() {
        ArrayList<bh> arrayList = this.hotLiveInfo.dxd;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (bh bhVar : arrayList) {
            if (bhVar != null) {
                String tid = bhVar.getTid();
                if (!this.dzn.contains(tid)) {
                    arrayList2.add(bhVar);
                    this.dzn.add(tid);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bk(arrayList2);
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
        ArrayList<bh> arrayList = hVar.dxd;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<bh> it = arrayList.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                String tid = next.getTid();
                if (!this.dzn.contains(tid)) {
                    arrayList2.add(next);
                    this.dzn.add(tid);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.dzo.addAll(arrayList2);
        this.dzp = bk(this.dzo);
        return !v.isEmpty(this.dzp);
    }

    private ArrayList<m> bk(List<bh> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            i iVar = new i();
            com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
            bVar.dvi = list.get(i);
            bVar.isLeft = true;
            iVar.dxr = bVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                bVar2.dvi = list.get(i + 1);
                iVar.dxs = bVar2;
                bVar2.isRight = true;
            } else {
                bVar.isLeft = false;
                bVar.dvl = true;
            }
            arrayList.add(iVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean aJF() {
        return !v.isEmpty(this.dzn);
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.bZG)) {
            arrayList.addAll(this.bZG);
        }
        if (!v.isEmpty(this.dzp)) {
            arrayList.addAll(this.dzp);
        }
        return arrayList;
    }

    public void clear() {
        this.superEntranceInfo = null;
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.dzm != null) {
            this.dzm.clear();
        }
        if (this.bZG != null) {
            this.bZG.clear();
        }
        if (this.dzn != null) {
            this.dzn.clear();
        }
        if (this.dzo != null) {
            this.dzo.clear();
        }
        if (this.dzp != null) {
            this.dzp.clear();
        }
    }
}
