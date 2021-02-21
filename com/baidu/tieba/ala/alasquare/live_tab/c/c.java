package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private List<n> dataList;
    private List<n> gDV;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<SdkLiveInfoData> gDS = new ArrayList();
    private List<n> gDT = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bRT();
    }

    private void bRT() {
        this.gDV = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.gBd = this.stageLiveInfo;
            this.gDV.add(fVar);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<n> bRU = bRU();
            if (!y.isEmpty(bRU)) {
                this.gDV.addAll(bRU);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.gAW)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.gAY = this.officialRecommendLiveInfo;
            this.gDV.add(cVar);
        }
        this.dataList = new ArrayList(this.gDV);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<n> bRU() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.gAW;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                arrayList2.add(sdkLiveInfoData);
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return cg(arrayList2);
        }
        return null;
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean b2 = b(jVar);
        this.hasMore = jVar.hasMore;
        return b2;
    }

    private boolean b(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<SdkLiveInfoData> arrayList = jVar.gAW;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!au.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                arrayList2.add(next);
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.gDS.addAll(arrayList2);
        this.gDT = cg(this.gDS);
        return !y.isEmpty(this.gDT);
    }

    private ArrayList<n> cg(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gyL = list.get(i);
            aVar.isLeft = true;
            eVar.gBa = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gyL = list.get(i + 1);
                eVar.gBb = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gyM = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<n> getData() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!y.isEmpty(this.gDT)) {
            arrayList.addAll(this.gDT);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.gDV != null) {
            this.gDV.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.gDS != null) {
            this.gDS.clear();
        }
        if (this.gDT != null) {
            this.gDT.clear();
        }
    }
}
