package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.at;
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
    private List<q> gmM;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> gmI = new ArrayList();
    private List<SdkLiveInfoData> gmJ = new ArrayList();
    private List<q> gmK = new ArrayList();

    public c(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        bPt();
    }

    private void bPt() {
        this.gmM = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.gjV = this.stageLiveInfo;
            this.gmM.add(fVar);
            this.gmI.add(this.stageLiveInfo.gjW.liveId);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<q> bPu = bPu();
            if (!y.isEmpty(bPu)) {
                this.gmM.addAll(bPu);
            }
        }
        if (this.officialRecommendLiveInfo != null && !y.isEmpty(this.officialRecommendLiveInfo.gjO)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.gjQ = this.officialRecommendLiveInfo;
            this.gmM.add(cVar);
        }
        this.dataList = new ArrayList(this.gmM);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<q> bPu() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.gjO;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.gmI.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.gmI.add(str);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.gjO;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && (!at.equals(next.source, "jiaoyoufang") || com.baidu.tieba.ala.alasquare.live_tab.c.a(next))) {
                String str = next.liveId;
                if (!this.gmI.contains(str)) {
                    arrayList2.add(next);
                    this.gmI.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.gmJ.addAll(arrayList2);
        this.gmK = ca(this.gmJ);
        return !y.isEmpty(this.gmK);
    }

    private ArrayList<q> ca(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ghL = list.get(i);
            aVar.isLeft = true;
            eVar.gjS = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ghL = list.get(i + 1);
                eVar.gjT = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ghM = true;
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
        if (!y.isEmpty(this.gmK)) {
            arrayList.addAll(this.gmK);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.gmM != null) {
            this.gmM.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.gmI != null) {
            this.gmI.clear();
        }
        if (this.gmJ != null) {
            this.gmJ.clear();
        }
        if (this.gmK != null) {
            this.gmK.clear();
        }
    }
}
