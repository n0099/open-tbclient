package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private boolean eWc;
    private String fPy;
    private String gDc;
    private boolean hasMore = false;
    private List<String> gFC = new ArrayList();
    private List<SdkLiveInfoData> gFA = new ArrayList();
    private List<n> gFB = new ArrayList();

    public b(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.eWc = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eWc = true;
        }
        this.fPy = str;
        this.gDc = str2;
        l(list, z);
    }

    public boolean l(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean cm = cm(list);
        this.hasMore = z;
        return cm;
    }

    private boolean cm(List<SdkLiveInfoData> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.gFC.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gFC.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList)) {
            return false;
        }
        this.gFA.addAll(arrayList);
        this.gFB = cl(this.gFA);
        return !x.isEmpty(this.gFB);
    }

    private ArrayList<n> cl(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gAu = list.get(i);
            aVar.isLeft = true;
            aVar.eWc = this.eWc;
            aVar.fid = this.fPy;
            aVar.fname = this.gDc;
            aVar.position = i + 1;
            eVar.gCJ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gAu = list.get(i + 1);
                aVar2.eWc = this.eWc;
                aVar2.fid = this.fPy;
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
        if (!x.isEmpty(this.gFB)) {
            arrayList.addAll(this.gFB);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gFC != null) {
            this.gFC.clear();
        }
        if (this.gFA != null) {
            this.gFA.clear();
        }
        if (this.gFB != null) {
            this.gFB.clear();
        }
    }
}
