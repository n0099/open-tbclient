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
    private List<m> bYP;
    private List<m> dyv;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private c officialRecommendLiveInfo;
    private e stageLiveInfo;
    private f superEntranceInfo;
    private h tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> dyw = new ArrayList();
    private List<bh> dyx = new ArrayList();
    private List<m> dyy = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.superEntranceInfo = alaTabLiveResponsedMessage.superEntranceInfo;
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        aJB();
    }

    private void aJB() {
        this.dyv = new ArrayList();
        if (this.superEntranceInfo != null) {
            g gVar = new g();
            gVar.dwy = this.superEntranceInfo;
            this.dyv.add(gVar);
        }
        if (this.stageLiveInfo != null && this.stageLiveInfo.aJp() && this.stageLiveInfo.isValid()) {
            d dVar = new d();
            dVar.dwr = this.stageLiveInfo;
            this.dyv.add(dVar);
            this.dyw.add(this.stageLiveInfo.dws.getTid());
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> aJC = aJC();
            if (!v.isEmpty(aJC)) {
                this.dyv.addAll(aJC);
            }
        }
        if (this.officialRecommendLiveInfo != null && this.officialRecommendLiveInfo.dwp && !v.isEmpty(this.officialRecommendLiveInfo.dwm)) {
            b bVar = new b();
            bVar.dwo = this.officialRecommendLiveInfo;
            this.dyv.add(bVar);
        }
        this.bYP = new ArrayList(this.dyv);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> aJC() {
        ArrayList<bh> arrayList = this.hotLiveInfo.dwm;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (bh bhVar : arrayList) {
            if (bhVar != null) {
                String tid = bhVar.getTid();
                if (!this.dyw.contains(tid)) {
                    arrayList2.add(bhVar);
                    this.dyw.add(tid);
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
        ArrayList<bh> arrayList = hVar.dwm;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<bh> it = arrayList.iterator();
        while (it.hasNext()) {
            bh next = it.next();
            if (next != null) {
                String tid = next.getTid();
                if (!this.dyw.contains(tid)) {
                    arrayList2.add(next);
                    this.dyw.add(tid);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.dyx.addAll(arrayList2);
        this.dyy = bk(this.dyx);
        return !v.isEmpty(this.dyy);
    }

    private ArrayList<m> bk(List<bh> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            i iVar = new i();
            com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
            bVar.dur = list.get(i);
            bVar.isLeft = true;
            iVar.dwA = bVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                bVar2.dur = list.get(i + 1);
                iVar.dwB = bVar2;
                bVar2.isRight = true;
            } else {
                bVar.isLeft = false;
                bVar.duu = true;
            }
            arrayList.add(iVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean aJD() {
        return !v.isEmpty(this.dyw);
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.bYP)) {
            arrayList.addAll(this.bYP);
        }
        if (!v.isEmpty(this.dyy)) {
            arrayList.addAll(this.dyy);
        }
        return arrayList;
    }

    public void clear() {
        this.superEntranceInfo = null;
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.dyv != null) {
            this.dyv.clear();
        }
        if (this.bYP != null) {
            this.bYP.clear();
        }
        if (this.dyw != null) {
            this.dyw.clear();
        }
        if (this.dyx != null) {
            this.dyx.clear();
        }
        if (this.dyy != null) {
            this.dyy.clear();
        }
    }
}
