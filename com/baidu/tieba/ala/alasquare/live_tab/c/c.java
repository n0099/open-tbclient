package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import com.baidu.tieba.ala.alasquare.live_tab.b.g;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private List<n> dataList;
    private List<n> gAX;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<SdkLiveInfoData> gAU = new ArrayList();
    private List<n> gAV = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bRj();
    }

    private void bRj() {
        this.gAX = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.gyf = this.stageLiveInfo;
            this.gAX.add(fVar);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<n> bRk = bRk();
            if (!x.isEmpty(bRk)) {
                this.gAX.addAll(bRk);
            }
        }
        if (this.officialRecommendLiveInfo != null && !x.isEmpty(this.officialRecommendLiveInfo.gxY)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.gya = this.officialRecommendLiveInfo;
            this.gAX.add(cVar);
        }
        this.dataList = new ArrayList(this.gAX);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<n> bRk() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.gxY;
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
            return cl(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.gxY;
        if (x.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!at.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                arrayList2.add(next);
            }
        }
        if (x.isEmpty(arrayList2)) {
            return false;
        }
        this.gAU.addAll(arrayList2);
        this.gAV = cl(this.gAU);
        return !x.isEmpty(this.gAV);
    }

    private ArrayList<n> cl(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gvN = list.get(i);
            aVar.isLeft = true;
            eVar.gyc = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gvN = list.get(i + 1);
                eVar.gyd = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gvO = true;
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
        if (!x.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!x.isEmpty(this.gAV)) {
            arrayList.addAll(this.gAV);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.gAX != null) {
            this.gAX.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.gAU != null) {
            this.gAU.clear();
        }
        if (this.gAV != null) {
            this.gAV.clear();
        }
    }
}
