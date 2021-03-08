package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private boolean eVe;
    private String fOD;
    private String gDc;
    private boolean hasMore = false;
    private List<String> gFA = new ArrayList();
    private List<SdkLiveInfoData> gFB = new ArrayList();
    private List<n> gFC = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.eVe = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eVe = true;
        }
        this.fOD = str;
        this.gDc = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean ch = ch(jVar.gCF);
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
                if (!this.gFA.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gFA.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.gFB.addAll(arrayList);
        this.gFC = cg(this.gFB);
        return !y.isEmpty(this.gFC);
    }

    private ArrayList<n> cg(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gAu = list.get(i);
            aVar.isLeft = true;
            aVar.eVe = this.eVe;
            aVar.fid = this.fOD;
            aVar.fname = this.gDc;
            aVar.position = i + 1;
            eVar.gCJ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gAu = list.get(i + 1);
                aVar2.eVe = this.eVe;
                aVar2.fid = this.fOD;
                aVar2.fname = this.gDc;
                aVar2.position = i + 2;
                eVar.gCK = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gAv = true;
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
        if (!y.isEmpty(this.gFC)) {
            arrayList.addAll(this.gFC);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gFA != null) {
            this.gFA.clear();
        }
        if (this.gFB != null) {
            this.gFB.clear();
        }
        if (this.gFC != null) {
            this.gFC.clear();
        }
    }
}
