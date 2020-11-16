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
/* loaded from: classes4.dex */
public class c {
    private List<q> dataList;
    private List<q> gmt;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> gmp = new ArrayList();
    private List<SdkLiveInfoData> gmq = new ArrayList();
    private List<q> gmr = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bOM();
    }

    private void bOM() {
        this.gmt = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.gjC = this.stageLiveInfo;
            this.gmt.add(fVar);
            this.gmp.add(this.stageLiveInfo.gjD.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bON = bON();
            if (!y.isEmpty(bON)) {
                this.gmt.addAll(bON);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.gjv)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.gjx = this.officialRecommendLiveInfo;
            this.gmt.add(cVar);
        }
        this.dataList = new ArrayList(this.gmt);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bON() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.gjv;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.gmp.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.gmp.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return ca(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.gjv;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!au.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                String str = next.liveId;
                if (!this.gmp.contains(str)) {
                    arrayList2.add(next);
                    this.gmp.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.gmq.addAll(arrayList2);
        this.gmr = ca(this.gmq);
        return !y.isEmpty(this.gmr);
    }

    private ArrayList<q> ca(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ghs = list.get(i);
            aVar.isLeft = true;
            eVar.gjz = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ghs = list.get(i + 1);
                eVar.gjA = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ght = true;
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
        if (!y.isEmpty(this.gmr)) {
            arrayList.addAll(this.gmr);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.gmt != null) {
            this.gmt.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.gmp != null) {
            this.gmp.clear();
        }
        if (this.gmq != null) {
            this.gmq.clear();
        }
        if (this.gmr != null) {
            this.gmr.clear();
        }
    }
}
