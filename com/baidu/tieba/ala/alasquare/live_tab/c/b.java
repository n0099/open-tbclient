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
    private List<m> epe;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> epb = new ArrayList();
    private List<SdkLiveInfoData> epc = new ArrayList();
    private List<m> epd = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bcU();
    }

    private void bcU() {
        this.epe = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.emq = this.stageLiveInfo;
            this.epe.add(fVar);
            this.epb.add(this.stageLiveInfo.emr.tid);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> bcV = bcV();
            if (!v.isEmpty(bcV)) {
                this.epe.addAll(bcV);
            }
        }
        if (this.officialRecommendLiveInfo != null && !v.isEmpty(this.officialRecommendLiveInfo.emj)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.eml = this.officialRecommendLiveInfo;
            this.epe.add(cVar);
        }
        this.dataList = new ArrayList(this.epe);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> bcV() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.emj;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.epb.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.epb.add(str);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.emj;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.tid;
                if (!this.epb.contains(str)) {
                    arrayList2.add(next);
                    this.epb.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.epc.addAll(arrayList2);
        this.epd = bj(this.epc);
        return !v.isEmpty(this.epd);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ekj = list.get(i);
            aVar.isLeft = true;
            eVar.emn = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ekj = list.get(i + 1);
                eVar.emo = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ekk = true;
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
        if (!v.isEmpty(this.epd)) {
            arrayList.addAll(this.epd);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.epe != null) {
            this.epe.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.epb != null) {
            this.epb.clear();
        }
        if (this.epc != null) {
            this.epc.clear();
        }
        if (this.epd != null) {
            this.epd.clear();
        }
    }
}
