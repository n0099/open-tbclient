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
    private List<q> fKC;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> fKD = new ArrayList();
    private List<SdkLiveInfoData> fKA = new ArrayList();
    private List<q> fKB = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bHF();
    }

    private void bHF() {
        this.fKC = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fHS = this.stageLiveInfo;
            this.fKC.add(fVar);
            this.fKD.add(this.stageLiveInfo.fHT.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bHG = bHG();
            if (!y.isEmpty(bHG)) {
                this.fKC.addAll(bHG);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.fHL)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.fHN = this.officialRecommendLiveInfo;
            this.fKC.add(cVar);
        }
        this.dataList = new ArrayList(this.fKC);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bHG() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.fHL;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fKD.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.fKD.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bH(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.fHL;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.liveId;
                if (!this.fKD.contains(str)) {
                    arrayList2.add(next);
                    this.fKD.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.fKA.addAll(arrayList2);
        this.fKB = bH(this.fKA);
        return !y.isEmpty(this.fKB);
    }

    private ArrayList<q> bH(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fFK = list.get(i);
            aVar.isLeft = true;
            eVar.fHP = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fFK = list.get(i + 1);
                eVar.fHQ = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fFL = true;
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
        if (!y.isEmpty(this.fKB)) {
            arrayList.addAll(this.fKB);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.fKC != null) {
            this.fKC.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.fKD != null) {
            this.fKD.clear();
        }
        if (this.fKA != null) {
            this.fKA.clear();
        }
        if (this.fKB != null) {
            this.fKB.clear();
        }
    }
}
