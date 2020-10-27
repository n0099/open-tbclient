package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private boolean eAY;
    private String fsZ;
    private String gew;
    private boolean hasMore = false;
    private List<String> ggX = new ArrayList();
    private List<SdkLiveInfoData> ggV = new ArrayList();
    private List<q> ggW = new ArrayList();

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.eAY = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eAY = true;
        }
        this.fsZ = str;
        this.gew = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bU = bU(list);
        this.hasMore = z;
        return bU;
    }

    private boolean bU(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.ggX.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.ggX.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.ggV.addAll(arrayList);
        this.ggW = bT(this.ggV);
        return !y.isEmpty(this.ggW);
    }

    private ArrayList<q> bT(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gbW = list.get(i);
            aVar.isLeft = true;
            aVar.eAY = this.eAY;
            aVar.fid = this.fsZ;
            aVar.fname = this.gew;
            aVar.position = i + 1;
            eVar.gec = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gbW = list.get(i + 1);
                aVar2.eAY = this.eAY;
                aVar2.fid = this.fsZ;
                aVar2.fname = this.gew;
                aVar2.position = i + 2;
                eVar.ged = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gbX = true;
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
        if (!y.isEmpty(this.ggW)) {
            arrayList.addAll(this.ggW);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.ggX != null) {
            this.ggX.clear();
        }
        if (this.ggV != null) {
            this.ggV.clear();
        }
        if (this.ggW != null) {
            this.ggW.clear();
        }
    }
}
