package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.d;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private List<m> dataList;
    private List<m> eoA;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> eox = new ArrayList();
    private List<SdkLiveInfoData> eoy = new ArrayList();
    private List<m> eoz = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bcP();
    }

    private void bcP() {
        this.eoA = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.elM = this.stageLiveInfo;
            this.eoA.add(fVar);
            this.eox.add(this.stageLiveInfo.elN.tid);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> bcQ = bcQ();
            if (!v.isEmpty(bcQ)) {
                this.eoA.addAll(bcQ);
            }
        }
        if (this.officialRecommendLiveInfo != null && !v.isEmpty(this.officialRecommendLiveInfo.elF)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.elH = this.officialRecommendLiveInfo;
            this.eoA.add(cVar);
        }
        this.dataList = new ArrayList(this.eoA);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> bcQ() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.elF;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.eox.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.eox.add(str);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.elF;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.tid;
                if (!this.eox.contains(str)) {
                    arrayList2.add(next);
                    this.eox.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.eoy.addAll(arrayList2);
        this.eoz = bj(this.eoy);
        return !v.isEmpty(this.eoz);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ejG = list.get(i);
            aVar.isLeft = true;
            eVar.elJ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ejG = list.get(i + 1);
                eVar.elK = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ejH = true;
            }
            arrayList.add(eVar);
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
        if (!v.isEmpty(this.eoz)) {
            arrayList.addAll(this.eoz);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.eoA != null) {
            this.eoA.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.eox != null) {
            this.eox.clear();
        }
        if (this.eoy != null) {
            this.eoy.clear();
        }
        if (this.eoz != null) {
            this.eoz.clear();
        }
    }
}
