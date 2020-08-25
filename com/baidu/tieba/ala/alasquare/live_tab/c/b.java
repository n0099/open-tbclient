package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.d;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<q> dataList;
    private List<q> fHm;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> fHn = new ArrayList();
    private List<SdkLiveInfoData> fHk = new ArrayList();
    private List<q> fHl = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bGo();
    }

    private void bGo() {
        this.fHm = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fEC = this.stageLiveInfo;
            this.fHm.add(fVar);
            this.fHn.add(this.stageLiveInfo.fED.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bGp = bGp();
            if (!y.isEmpty(bGp)) {
                this.fHm.addAll(bGp);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.fEv)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.fEx = this.officialRecommendLiveInfo;
            this.fHm.add(cVar);
        }
        this.dataList = new ArrayList(this.fHm);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bGp() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.fEv;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fHn.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.fHn.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bC(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.fEv;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.liveId;
                if (!this.fHn.contains(str)) {
                    arrayList2.add(next);
                    this.fHn.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.fHk.addAll(arrayList2);
        this.fHl = bC(this.fHk);
        return !y.isEmpty(this.fHl);
    }

    private ArrayList<q> bC(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fCu = list.get(i);
            aVar.isLeft = true;
            eVar.fEz = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fCu = list.get(i + 1);
                eVar.fEA = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fCv = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<q> getData() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!y.isEmpty(this.fHl)) {
            arrayList.addAll(this.fHl);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.fHm != null) {
            this.fHm.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.fHn != null) {
            this.fHn.clear();
        }
        if (this.fHk != null) {
            this.fHk.clear();
        }
        if (this.fHl != null) {
            this.fHl.clear();
        }
    }
}
