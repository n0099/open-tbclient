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
    private List<o> ffz;
    private com.baidu.tieba.ala.alasquare.live_tab.b.a hotLiveInfo;
    private d officialRecommendLiveInfo;
    private g stageLiveInfo;
    private j tabAllLiveInfo;
    private boolean hasMore = false;
    private List<String> ffw = new ArrayList();
    private List<SdkLiveInfoData> ffx = new ArrayList();
    private List<o> ffy = new ArrayList();

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        this.stageLiveInfo = alaTabLiveResponsedMessage.stageLiveInfo;
        this.hotLiveInfo = alaTabLiveResponsedMessage.hotLiveInfo;
        this.officialRecommendLiveInfo = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.tabAllLiveInfo = alaTabLiveResponsedMessage.tabAllLiveInfo;
        brj();
    }

    private void brj() {
        this.ffz = new ArrayList();
        if (this.stageLiveInfo != null && this.stageLiveInfo.isValid()) {
            f fVar = new f();
            fVar.fcP = this.stageLiveInfo;
            this.ffz.add(fVar);
            this.ffw.add(this.stageLiveInfo.fcQ.tid);
        }
        if (this.hotLiveInfo != null) {
            ArrayList<o> brk = brk();
            if (!v.isEmpty(brk)) {
                this.ffz.addAll(brk);
            }
        }
        if (this.officialRecommendLiveInfo != null && !v.isEmpty(this.officialRecommendLiveInfo.fcI)) {
            com.baidu.tieba.ala.alasquare.live_tab.b.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.b.c();
            cVar.fcK = this.officialRecommendLiveInfo;
            this.ffz.add(cVar);
        }
        this.dataList = new ArrayList(this.ffz);
        a(this.tabAllLiveInfo);
    }

    private ArrayList<o> brk() {
        ArrayList<SdkLiveInfoData> arrayList = this.hotLiveInfo.fcI;
        if (arrayList == null || arrayList.size() < 2) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.ffw.contains(str)) {
                    arrayList2.add(sdkLiveInfoData);
                    this.ffw.add(str);
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
        ArrayList<SdkLiveInfoData> arrayList = jVar.fcI;
        if (v.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.tid;
                if (!this.ffw.contains(str)) {
                    arrayList2.add(next);
                    this.ffw.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList2)) {
            return false;
        }
        this.ffx.addAll(arrayList2);
        this.ffy = bo(this.ffx);
        return !v.isEmpty(this.ffy);
    }

    private ArrayList<o> bo(List<SdkLiveInfoData> list) {
        ArrayList<o> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.faG = list.get(i);
            aVar.isLeft = true;
            eVar.fcM = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.faG = list.get(i + 1);
                eVar.fcN = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.faH = true;
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
        if (!v.isEmpty(this.ffy)) {
            arrayList.addAll(this.ffy);
        }
        return arrayList;
    }

    public void clear() {
        this.stageLiveInfo = null;
        this.hotLiveInfo = null;
        this.officialRecommendLiveInfo = null;
        this.hasMore = false;
        if (this.ffz != null) {
            this.ffz.clear();
        }
        if (this.dataList != null) {
            this.dataList.clear();
        }
        if (this.ffw != null) {
            this.ffw.clear();
        }
        if (this.ffx != null) {
            this.ffx.clear();
        }
        if (this.ffy != null) {
            this.ffy.clear();
        }
    }
}
