package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.w;
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
    private List<q> dataList;
    private List<q> fqK;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> fqL = new ArrayList();
    private List<SdkLiveInfoData> fqI = new ArrayList();
    private List<q> fqJ = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bug();
    }

    private void bug() {
        this.fqK = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fnZ = this.stageLiveInfo;
            this.fqK.add(fVar);
            this.fqL.add(this.stageLiveInfo.foa.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> buh = buh();
            if (!w.isEmpty(buh)) {
                this.fqK.addAll(buh);
            }
        }
        if (this.officialRecommendLiveInfo != null && !w.isEmpty(this.officialRecommendLiveInfo.fnS)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.fnU = this.officialRecommendLiveInfo;
            this.fqK.add(cVar);
        }
        this.dataList = new ArrayList(this.fqK);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> buh() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.fnS;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fqL.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.fqL.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bx(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.fnS;
        if (w.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.liveId;
                if (!this.fqL.contains(str)) {
                    arrayList2.add(next);
                    this.fqL.add(str);
                }
            }
        }
        if (w.isEmpty(arrayList2)) {
            return false;
        }
        this.fqI.addAll(arrayList2);
        this.fqJ = bx(this.fqI);
        return !w.isEmpty(this.fqJ);
    }

    private ArrayList<q> bx(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.flQ = list.get(i);
            aVar.isLeft = true;
            eVar.fnW = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.flQ = list.get(i + 1);
                eVar.fnX = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.flR = true;
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
        if (!w.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!w.isEmpty(this.fqJ)) {
            arrayList.addAll(this.fqJ);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.fqK != null) {
            this.fqK.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.fqL != null) {
            this.fqL.clear();
        }
        if (this.fqI != null) {
            this.fqI.clear();
        }
        if (this.fqJ != null) {
            this.fqJ.clear();
        }
    }
}
