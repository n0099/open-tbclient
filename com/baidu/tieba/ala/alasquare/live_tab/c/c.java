package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private boolean dUI;
    private String eKO;
    private String ftz;
    private boolean hasMore = false;
    private List<String> fvV = new ArrayList();
    private List<SdkLiveInfoData> fvS = new ArrayList();
    private List<q> fvT = new ArrayList();

    public c(j jVar, String str, String str2) {
        this.dUI = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dUI = true;
        }
        this.eKO = str;
        this.ftz = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean bA = bA(jVar.ftb);
        this.hasMore = jVar.hasMore;
        return bA;
    }

    private boolean bA(List<SdkLiveInfoData> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fvV.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fvV.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList)) {
            return false;
        }
        this.fvS.addAll(arrayList);
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
            aVar.dUI = this.dUI;
            aVar.fid = this.eKO;
            aVar.fname = this.ftz;
            aVar.position = i + 1;
            eVar.ftf = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fqY = list.get(i + 1);
                aVar2.dUI = this.dUI;
                aVar2.fid = this.eKO;
                aVar2.fname = this.ftz;
                aVar2.position = i + 2;
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
        if (!x.isEmpty(this.fvT)) {
            arrayList.addAll(this.fvT);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
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
