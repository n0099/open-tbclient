package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private boolean eTD;
    private String fNd;
    private String gBf;
    private boolean hasMore = false;
    private List<String> gDD = new ArrayList();
    private List<SdkLiveInfoData> gDE = new ArrayList();
    private List<n> gDF = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.eTD = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eTD = true;
        }
        this.fNd = str;
        this.gBf = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean ch = ch(jVar.gAI);
        this.hasMore = jVar.hasMore;
        return ch;
    }

    private boolean ch(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.gDD.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gDD.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.gDE.addAll(arrayList);
        this.gDF = cg(this.gDE);
        return !y.isEmpty(this.gDF);
    }

    private ArrayList<n> cg(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gyx = list.get(i);
            aVar.isLeft = true;
            aVar.eTD = this.eTD;
            aVar.fid = this.fNd;
            aVar.fname = this.gBf;
            aVar.position = i + 1;
            eVar.gAM = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gyx = list.get(i + 1);
                aVar2.eTD = this.eTD;
                aVar2.fid = this.fNd;
                aVar2.fname = this.gBf;
                aVar2.position = i + 2;
                eVar.gAN = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gyy = true;
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
        if (!y.isEmpty(this.gDF)) {
            arrayList.addAll(this.gDF);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gDD != null) {
            this.gDD.clear();
        }
        if (this.gDE != null) {
            this.gDE.clear();
        }
        if (this.gDF != null) {
            this.gDF.clear();
        }
    }
}
