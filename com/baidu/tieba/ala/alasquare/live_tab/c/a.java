package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private boolean dOx;
    private String eEs;
    private String foo;
    private boolean hasMore = false;
    private List<String> fqH = new ArrayList();
    private List<SdkLiveInfoData> fqI = new ArrayList();
    private List<q> fqJ = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dOx = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dOx = true;
        }
        this.eEs = str;
        this.foo = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bw = bw(list);
        this.hasMore = z;
        return bw;
    }

    private boolean bw(List<SdkLiveInfoData> list) {
        if (w.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.fqH.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fqH.add(str);
                }
            }
        }
        if (w.isEmpty(arrayList)) {
            return false;
        }
        this.fqI.addAll(arrayList);
        this.fqJ = bx(this.fqI);
        return !w.isEmpty(this.fqJ);
    }

    private ArrayList<q> bx(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.flQ = list.get(i);
            aVar.isLeft = true;
            aVar.dOx = this.dOx;
            aVar.fid = this.eEs;
            aVar.fname = this.foo;
            aVar.position = i + 1;
            eVar.fnW = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.flQ = list.get(i + 1);
                aVar2.dOx = this.dOx;
                aVar2.fid = this.eEs;
                aVar2.fname = this.foo;
                aVar2.position = i + 2;
                eVar.fnX = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.flR = true;
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
        if (!w.isEmpty(this.fqJ)) {
            arrayList.addAll(this.fqJ);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fqH != null) {
            this.fqH.clear();
        }
        if (this.fqI != null) {
            this.fqI.clear();
        }
        if (this.fqJ != null) {
            this.fqJ.clear();
        }
    }
}
