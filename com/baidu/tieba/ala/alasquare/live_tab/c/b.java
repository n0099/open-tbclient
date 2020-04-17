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
    private List<m> eSB;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> eSy = new ArrayList();
    private List<SdkLiveInfoData> eSz = new ArrayList();
    private List<m> eSA = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        blL();
    }

    private void blL() {
        this.eSB = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.ePQ = this.stageLiveInfo;
            this.eSB.add(fVar);
            this.eSy.add(this.stageLiveInfo.ePR.tid);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<m> blM = blM();
            if (!v.isEmpty(blM)) {
                this.eSB.addAll(blM);
            }
        }
        if (this.officialRecommendLiveInfo != null && !v.isEmpty(this.officialRecommendLiveInfo.ePJ)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.ePL = this.officialRecommendLiveInfo;
            this.eSB.add(cVar);
        }
        this.dataList = new ArrayList(this.eSB);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<m> blM() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.ePJ;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.eSy.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.eSy.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bt(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.ePJ;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.tid;
                if (!this.eSy.contains(str)) {
                    arrayList2.add(next);
                    this.eSy.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.eSz.addAll(arrayList2);
        this.eSA = bt(this.eSz);
        return !v.isEmpty(this.eSA);
    }

    private ArrayList<m> bt(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.eNJ = list.get(i);
            aVar.isLeft = true;
            eVar.ePN = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.eNJ = list.get(i + 1);
                eVar.ePO = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.eNK = true;
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
        if (!v.isEmpty(this.eSA)) {
            arrayList.addAll(this.eSA);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.eSB != null) {
            this.eSB.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.eSy != null) {
            this.eSy.clear();
        }
        if (this.eSz != null) {
            this.eSz.clear();
        }
        if (this.eSA != null) {
            this.eSA.clear();
        }
    }
}
