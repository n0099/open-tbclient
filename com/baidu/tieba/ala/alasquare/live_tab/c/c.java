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
    private List<q> guC;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> guy = new ArrayList();
    private List<SdkLiveInfoData> guz = new ArrayList();
    private List<q> guA = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bSx();
    }

    private void bSx() {
        this.guC = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.grL = this.stageLiveInfo;
            this.guC.add(fVar);
            this.guy.add(this.stageLiveInfo.grM.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bSy = bSy();
            if (!y.isEmpty(bSy)) {
                this.guC.addAll(bSy);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.grE)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.grG = this.officialRecommendLiveInfo;
            this.guC.add(cVar);
        }
        this.dataList = new ArrayList(this.guC);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bSy() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.grE;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.guy.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.guy.add(str);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.grE;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!au.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                String str = next.liveId;
                if (!this.guy.contains(str)) {
                    arrayList2.add(next);
                    this.guy.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.guz.addAll(arrayList2);
        this.guA = ce(this.guz);
        return !y.isEmpty(this.guA);
    }

    private ArrayList<q> ce(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gpC = list.get(i);
            aVar.isLeft = true;
            eVar.grI = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gpC = list.get(i + 1);
                eVar.grJ = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gpD = true;
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
        if (!y.isEmpty(this.guA)) {
            arrayList.addAll(this.guA);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.guC != null) {
            this.guC.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.guy != null) {
            this.guy.clear();
        }
        if (this.guz != null) {
            this.guz.clear();
        }
        if (this.guA != null) {
            this.guA.clear();
        }
    }
}
