package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private boolean eMh;
    private String fFV;
    private String gsd;
    private boolean hasMore = false;
    private List<String> guD = new ArrayList();
    private List<SdkLiveInfoData> guB = new ArrayList();
    private List<q> guC = new ArrayList();

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.eMh = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eMh = true;
        }
        this.fFV = str;
        this.gsd = str2;
        l(list, z);
    }

    public boolean l(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean cf = cf(list);
        this.hasMore = z;
        return cf;
    }

    private boolean cf(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.guD.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.guD.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.guB.addAll(arrayList);
        this.guC = ce(this.guB);
        return !y.isEmpty(this.guC);
    }

    private ArrayList<q> ce(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gpE = list.get(i);
            aVar.isLeft = true;
            aVar.eMh = this.eMh;
            aVar.fid = this.fFV;
            aVar.fname = this.gsd;
            aVar.position = i + 1;
            eVar.grK = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gpE = list.get(i + 1);
                aVar2.eMh = this.eMh;
                aVar2.fid = this.fFV;
                aVar2.fname = this.gsd;
                aVar2.position = i + 2;
                eVar.grL = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gpF = true;
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
        if (!y.isEmpty(this.guC)) {
            arrayList.addAll(this.guC);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.guD != null) {
            this.guD.clear();
        }
        if (this.guB != null) {
            this.guB.clear();
        }
        if (this.guC != null) {
            this.guC.clear();
        }
    }
}
