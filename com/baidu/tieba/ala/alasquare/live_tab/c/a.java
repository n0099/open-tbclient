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
    private boolean dtP;
    private String eQf;
    private String eQg;
    private boolean hasMore = false;
    private List<String> eSy = new ArrayList();
    private List<SdkLiveInfoData> eSz = new ArrayList();
    private List<m> eSA = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dtP = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dtP = true;
        }
        this.eQf = str;
        this.eQg = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bs = bs(list);
        this.hasMore = z;
        return bs;
    }

    private boolean bs(List<SdkLiveInfoData> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.eSy.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.eSy.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.eSz.addAll(arrayList);
        this.eSA = bt(this.eSz);
        return !v.isEmpty(this.eSA);
    }

    private ArrayList<m> bt(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.eNJ = list.get(i);
            aVar.isLeft = true;
            aVar.dtP = this.dtP;
            aVar.fid = this.eQf;
            aVar.fname = this.eQg;
            aVar.position = i + 1;
            eVar.ePN = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.eNJ = list.get(i + 1);
                aVar2.dtP = this.dtP;
                aVar2.fid = this.eQf;
                aVar2.fname = this.eQg;
                aVar2.position = i + 2;
                eVar.ePO = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.eNK = true;
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
        if (!v.isEmpty(this.eSA)) {
            arrayList.addAll(this.eSA);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.eSy != null) {
            this.eSy.clear();
        }
        if (this.eSz != null) {
            this.eSz.clear();
        }
        if (this.eSA != null) {
            this.eSA.clear();
        }
    }
}
