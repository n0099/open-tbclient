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
    private boolean dtT;
    private String eQk;
    private String eQl;
    private boolean hasMore = false;
    private List<String> eSD = new ArrayList();
    private List<SdkLiveInfoData> eSE = new ArrayList();
    private List<m> eSF = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dtT = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dtT = true;
        }
        this.eQk = str;
        this.eQl = str2;
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
                if (!this.eSD.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.eSD.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.eSE.addAll(arrayList);
        this.eSF = bt(this.eSE);
        return !v.isEmpty(this.eSF);
    }

    private ArrayList<m> bt(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.eNO = list.get(i);
            aVar.isLeft = true;
            aVar.dtT = this.dtT;
            aVar.fid = this.eQk;
            aVar.fname = this.eQl;
            aVar.position = i + 1;
            eVar.ePS = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.eNO = list.get(i + 1);
                aVar2.dtT = this.dtT;
                aVar2.fid = this.eQk;
                aVar2.fname = this.eQl;
                aVar2.position = i + 2;
                eVar.ePT = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.eNP = true;
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
        if (!v.isEmpty(this.eSF)) {
            arrayList.addAll(this.eSF);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.eSD != null) {
            this.eSD.clear();
        }
        if (this.eSE != null) {
            this.eSE.clear();
        }
        if (this.eSF != null) {
            this.eSF.clear();
        }
    }
}
