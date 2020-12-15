package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes6.dex */
public class c {
    private List<q> dataList;
    private List<q> guE;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> guA = new ArrayList();
    private List<SdkLiveInfoData> guB = new ArrayList();
    private List<q> guC = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bSy();
    }

    private void bSy() {
        this.guE = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.grN = this.stageLiveInfo;
            this.guE.add(fVar);
            this.guA.add(this.stageLiveInfo.grO.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bSz = bSz();
            if (!y.isEmpty(bSz)) {
                this.guE.addAll(bSz);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.grG)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.grI = this.officialRecommendLiveInfo;
            this.guE.add(cVar);
        }
        this.dataList = new ArrayList(this.guE);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bSz() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.grG;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.guA.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.guA.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return ce(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.grG;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!au.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                String str = next.liveId;
                if (!this.guA.contains(str)) {
                    arrayList2.add(next);
                    this.guA.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.guB.addAll(arrayList2);
        this.guC = ce(this.guB);
        return !y.isEmpty(this.guC);
    }

    private ArrayList<q> ce(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gpE = list.get(i);
            aVar.isLeft = true;
            eVar.grK = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gpE = list.get(i + 1);
                eVar.grL = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gpF = true;
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
        if (!y.isEmpty(this.guC)) {
            arrayList.addAll(this.guC);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.guE != null) {
            this.guE.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.guA != null) {
            this.guA.clear();
        }
        if (this.guB != null) {
            this.guB.clear();
        }
        if (this.guC != null) {
            this.guC.clear();
        }
    }
}
