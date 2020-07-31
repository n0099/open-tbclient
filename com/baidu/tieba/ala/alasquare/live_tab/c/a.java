package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private boolean dUI;
    private String eKO;
    private String ftz;
    private boolean hasMore = false;
    private List<String> fvR = new ArrayList();
    private List<SdkLiveInfoData> fvS = new ArrayList();
    private List<q> fvT = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dUI = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dUI = true;
        }
        this.eKO = str;
        this.ftz = str2;
        i(list, z);
    }

    public boolean i(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bA = bA(list);
        this.hasMore = z;
        return bA;
    }

    private boolean bA(List<SdkLiveInfoData> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.fvR.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fvR.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList)) {
            return false;
        }
        this.fvS.addAll(arrayList);
        this.fvT = bB(this.fvS);
        return !x.isEmpty(this.fvT);
    }

    private ArrayList<q> bB(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fqY = list.get(i);
            aVar.isLeft = true;
            aVar.dUI = this.dUI;
            aVar.fid = this.eKO;
            aVar.fname = this.ftz;
            aVar.position = i + 1;
            eVar.ftf = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fqY = list.get(i + 1);
                aVar2.dUI = this.dUI;
                aVar2.fid = this.eKO;
                aVar2.fname = this.ftz;
                aVar2.position = i + 2;
                eVar.ftg = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fqZ = true;
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
        if (!x.isEmpty(this.fvT)) {
            arrayList.addAll(this.fvT);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fvR != null) {
            this.fvR.clear();
        }
        if (this.fvS != null) {
            this.fvS.clear();
        }
        if (this.fvT != null) {
            this.fvT.clear();
        }
    }
}
