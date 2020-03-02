package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private boolean cUq;
    private String emb;
    private String emc;
    private boolean hasMore = false;
    private List<String> eox = new ArrayList();
    private List<SdkLiveInfoData> eoy = new ArrayList();
    private List<m> eoz = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.cUq = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.cUq = true;
        }
        this.emb = str;
        this.emc = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bi = bi(list);
        this.hasMore = z;
        return bi;
    }

    private boolean bi(List<SdkLiveInfoData> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.eox.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.eox.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.eoy.addAll(arrayList);
        this.eoz = bj(this.eoy);
        return !v.isEmpty(this.eoz);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ejG = list.get(i);
            aVar.isLeft = true;
            aVar.cUq = this.cUq;
            aVar.fid = this.emb;
            aVar.fname = this.emc;
            aVar.position = i + 1;
            eVar.elJ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ejG = list.get(i + 1);
                aVar2.cUq = this.cUq;
                aVar2.fid = this.emb;
                aVar2.fname = this.emc;
                aVar2.position = i + 2;
                eVar.elK = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ejH = true;
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
        if (!v.isEmpty(this.eoz)) {
            arrayList.addAll(this.eoz);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.eox != null) {
            this.eox.clear();
        }
        if (this.eoy != null) {
            this.eoy.clear();
        }
        if (this.eoz != null) {
            this.eoz.clear();
        }
    }
}
