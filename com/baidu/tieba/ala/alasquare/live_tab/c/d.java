package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private boolean esy;
    private String fUs;
    private String fkA;
    private boolean hasMore = false;
    private List<String> fWQ = new ArrayList();
    private List<SdkLiveInfoData> fWR = new ArrayList();
    private List<q> fWS = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.esy = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.esy = true;
        }
        this.fkA = str;
        this.fUs = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean bK = bK(jVar.fTV);
        this.hasMore = jVar.hasMore;
        return bK;
    }

    private boolean bK(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fWQ.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fWQ.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.fWR.addAll(arrayList);
        this.fWS = bJ(this.fWR);
        return !y.isEmpty(this.fWS);
    }

    private ArrayList<q> bJ(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fRT = list.get(i);
            aVar.isLeft = true;
            aVar.esy = this.esy;
            aVar.fid = this.fkA;
            aVar.fname = this.fUs;
            aVar.position = i + 1;
            eVar.fTZ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fRT = list.get(i + 1);
                aVar2.esy = this.esy;
                aVar2.fid = this.fkA;
                aVar2.fname = this.fUs;
                aVar2.position = i + 2;
                eVar.fUa = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fRU = true;
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
        if (!y.isEmpty(this.fWS)) {
            arrayList.addAll(this.fWS);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fWQ != null) {
            this.fWQ.clear();
        }
        if (this.fWR != null) {
            this.fWR.clear();
        }
        if (this.fWS != null) {
            this.fWS.clear();
        }
    }
}
