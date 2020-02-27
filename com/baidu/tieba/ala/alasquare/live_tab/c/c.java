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
    private boolean cUp;
    private String ema;
    private String emb;
    private boolean hasMore = false;
    private List<String> eow = new ArrayList();
    private List<SdkLiveInfoData> eox = new ArrayList();
    private List<m> eoy = new ArrayList();

    public c(j jVar, String str, String str2) {
        this.cUp = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.cUp = true;
        }
        this.ema = str;
        this.emb = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean bi = bi(jVar.elE);
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
                if (!this.eow.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.eow.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.eox.addAll(arrayList);
        this.eoy = bj(this.eox);
        return !v.isEmpty(this.eoy);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ejF = list.get(i);
            aVar.isLeft = true;
            aVar.cUp = this.cUp;
            aVar.fid = this.ema;
            aVar.fname = this.emb;
            aVar.position = i + 1;
            eVar.elI = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ejF = list.get(i + 1);
                aVar2.cUp = this.cUp;
                aVar2.fid = this.ema;
                aVar2.fname = this.emb;
                aVar2.position = i + 2;
                eVar.elJ = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ejG = true;
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
        if (!v.isEmpty(this.eoy)) {
            arrayList.addAll(this.eoy);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.eow != null) {
            this.eow.clear();
        }
        if (this.eox != null) {
            this.eox.clear();
        }
        if (this.eoy != null) {
            this.eoy.clear();
        }
    }
}
