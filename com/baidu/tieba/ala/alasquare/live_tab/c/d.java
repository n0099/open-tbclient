package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private boolean eRr;
    private String fKR;
    private String gyv;
    private boolean hasMore = false;
    private List<String> gAT = new ArrayList();
    private List<SdkLiveInfoData> gAU = new ArrayList();
    private List<n> gAV = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.eRr = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eRr = true;
        }
        this.fKR = str;
        this.gyv = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean cm = cm(jVar.gxY);
        this.hasMore = jVar.hasMore;
        return cm;
    }

    private boolean cm(List<SdkLiveInfoData> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.gAT.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gAT.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList)) {
            return false;
        }
        this.gAU.addAll(arrayList);
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
            aVar.eRr = this.eRr;
            aVar.fid = this.fKR;
            aVar.fname = this.gyv;
            aVar.position = i + 1;
            eVar.gyc = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gvN = list.get(i + 1);
                aVar2.eRr = this.eRr;
                aVar2.fid = this.fKR;
                aVar2.fname = this.gyv;
                aVar2.position = i + 2;
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
        if (!x.isEmpty(this.gAV)) {
            arrayList.addAll(this.gAV);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gAT != null) {
            this.gAT.clear();
        }
        if (this.gAU != null) {
            this.gAU.clear();
        }
        if (this.gAV != null) {
            this.gAV.clear();
        }
    }
}
