package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.o;
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
    private List<o> dataList;
    private List<o> ffo;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> ffl = new ArrayList();
    private List<SdkLiveInfoData> ffm = new ArrayList();
    private List<o> ffn = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        brh();
    }

    private void brh() {
        this.ffo = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fcE = this.stageLiveInfo;
            this.ffo.add(fVar);
            this.ffl.add(this.stageLiveInfo.fcF.tid);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<o> bri = bri();
            if (!v.isEmpty(bri)) {
                this.ffo.addAll(bri);
            }
        }
        if (this.officialRecommendLiveInfo != null && !v.isEmpty(this.officialRecommendLiveInfo.fcx)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.fcz = this.officialRecommendLiveInfo;
            this.ffo.add(cVar);
        }
        this.dataList = new ArrayList(this.ffo);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<o> bri() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.fcx;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.ffl.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.ffl.add(str);
                }
            }
        }
        if (arrayList2 == null || arrayList2.size() >= 2) {
            return bo(arrayList2);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.fcx;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.tid;
                if (!this.ffl.contains(str)) {
                    arrayList2.add(next);
                    this.ffl.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.ffm.addAll(arrayList2);
        this.ffn = bo(this.ffm);
        return !v.isEmpty(this.ffn);
    }

    private ArrayList<o> bo(List<SdkLiveInfoData> list) {
        ArrayList<o> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fav = list.get(i);
            aVar.isLeft = true;
            eVar.fcB = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fav = list.get(i + 1);
                eVar.fcC = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.faw = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<o> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dataList)) {
            arrayList.addAll(this.dataList);
        }
        if (!v.isEmpty(this.ffn)) {
            arrayList.addAll(this.ffn);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.ffo != null) {
            this.ffo.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.ffl != null) {
            this.ffl.clear();
        }
        if (this.ffm != null) {
            this.ffm.clear();
        }
        if (this.ffn != null) {
            this.ffn.clear();
        }
    }
}
