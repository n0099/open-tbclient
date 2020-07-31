package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
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
    private List<q> fvU;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> fvV = new ArrayList();
    private List<SdkLiveInfoData> fvS = new ArrayList();
    private List<q> fvT = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bxp();
    }

    private void bxp() {
        this.fvU = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fti = this.stageLiveInfo;
            this.fvU.add(fVar);
            this.fvV.add(this.stageLiveInfo.ftj.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bxq = bxq();
            if (!x.isEmpty(bxq)) {
                this.fvU.addAll(bxq);
            }
        }
        if (this.officialRecommendLiveInfo != null && !x.isEmpty(this.officialRecommendLiveInfo.ftb)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.ftd = this.officialRecommendLiveInfo;
            this.fvU.add(cVar);
        }
        this.dataList = new ArrayList(this.fvU);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bxq() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.ftb;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fvV.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.fvV.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bB(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.ftb;
        if (x.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.liveId;
                if (!this.fvV.contains(str)) {
                    arrayList2.add(next);
                    this.fvV.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList2)) {
            return false;
        }
        this.fvS.addAll(arrayList2);
        this.fvT = bB(this.fvS);
        return !x.isEmpty(this.fvT);
    }

    private ArrayList<q> bB(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fqY = list.get(i);
            aVar.isLeft = true;
            eVar.ftf = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fqY = list.get(i + 1);
                eVar.ftg = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fqZ = true;
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
        if (!x.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!x.isEmpty(this.fvT)) {
            arrayList.addAll(this.fvT);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.fvU != null) {
            this.fvU.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.fvV != null) {
            this.fvV.clear();
        }
        if (this.fvS != null) {
            this.fvS.clear();
        }
        if (this.fvT != null) {
            this.fvT.clear();
        }
    }
}
