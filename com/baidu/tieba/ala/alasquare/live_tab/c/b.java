package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.d;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<m> dataList;
    private List<m> eko;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> ekl = new ArrayList();
    private List<bj> ekm = new ArrayList();
    private List<m> ekn = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bay();
    }

    private void bay() {
        this.eko = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.baj() && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.ehG = this.stageLiveInfo;
            this.eko.add(fVar);
            this.ekl.add(this.stageLiveInfo.ehH.getTid());
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> baz = baz();
            if (!v.isEmpty(baz)) {
                this.eko.addAll(baz);
            }
        }
        if (this.officialRecommendLiveInfo != null && this.officialRecommendLiveInfo.ehB && !v.isEmpty(this.officialRecommendLiveInfo.ehy)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.ehA = this.officialRecommendLiveInfo;
            this.eko.add(cVar);
        }
        this.dataList = new ArrayList(this.eko);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> baz() {
        ArrayList<bj> arrayList = this.hotLiveInfo.ehy;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (bj bjVar : arrayList) {
            if (bjVar != null) {
                String tid = bjVar.getTid();
                if (!this.ekl.contains(tid)) {
                    arrayList2.add(bjVar);
                    this.ekl.add(tid);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bj(arrayList2);
        }
        return null;
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean b = b(jVar);
        this.hasMore = jVar.hasMore;
        return b;
    }

    private boolean b(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<bj> arrayList = jVar.ehy;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<bj> it = arrayList.iterator();
        while (it.hasNext()) {
            bj next = it.next();
            if (next != null) {
                String tid = next.getTid();
                if (!this.ekl.contains(tid)) {
                    arrayList2.add(next);
                    this.ekl.add(tid);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.ekm.addAll(arrayList2);
        this.ekn = bj(this.ekm);
        return !v.isEmpty(this.ekn);
    }

    private ArrayList<m> bj(List<bj> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            k kVar = new k();
            com.baidu.tieba.ala.alasquare.a.c cVar = new com.baidu.tieba.ala.alasquare.a.c();
            cVar.efE = list.get(i);
            cVar.isLeft = true;
            kVar.ehP = cVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.c cVar2 = new com.baidu.tieba.ala.alasquare.a.c();
                cVar2.efE = list.get(i + 1);
                kVar.ehQ = cVar2;
                cVar2.isRight = true;
            } else {
                cVar.isLeft = false;
                cVar.efC = true;
            }
            arrayList.add(kVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!v.isEmpty(this.ekn)) {
            arrayList.addAll(this.ekn);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.eko != null) {
            this.eko.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.ekl != null) {
            this.ekl.clear();
        }
        if (this.ekm != null) {
            this.ekm.clear();
        }
        if (this.ekn != null) {
            this.ekn.clear();
        }
    }
}
