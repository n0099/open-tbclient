package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private boolean cUE;
    private String emF;
    private String emG;
    private boolean hasMore = false;
    private List<String> epb = new ArrayList();
    private List<SdkLiveInfoData> epc = new ArrayList();
    private List<m> epd = new ArrayList();

    public c(j jVar, String str, String str2) {
        this.cUE = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.cUE = true;
        }
        this.emF = str;
        this.emG = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean bi = bi(jVar.emj);
        this.hasMore = jVar.hasMore;
        return bi;
    }

    private boolean bi(List<SdkLiveInfoData> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.tid;
                if (!this.epb.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.epb.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.epc.addAll(arrayList);
        this.epd = bj(this.epc);
        return !v.isEmpty(this.epd);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ekj = list.get(i);
            aVar.isLeft = true;
            aVar.cUE = this.cUE;
            aVar.fid = this.emF;
            aVar.fname = this.emG;
            aVar.position = i + 1;
            eVar.emn = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ekj = list.get(i + 1);
                aVar2.cUE = this.cUE;
                aVar2.fid = this.emF;
                aVar2.fname = this.emG;
                aVar2.position = i + 2;
                eVar.emo = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ekk = true;
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
        if (!v.isEmpty(this.epd)) {
            arrayList.addAll(this.epd);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.epb != null) {
            this.epb.clear();
        }
        if (this.epc != null) {
            this.epc.clear();
        }
        if (this.epd != null) {
            this.epd.clear();
        }
    }
}
