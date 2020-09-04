package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private String eVx;
    private boolean eei;
    private String fEW;
    private boolean hasMore = false;
    private List<String> fHn = new ArrayList();
    private List<SdkLiveInfoData> fHo = new ArrayList();
    private List<q> fHp = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.eei = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eei = true;
        }
        this.eVx = str;
        this.fEW = str2;
        i(list, z);
    }

    public boolean i(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bB = bB(list);
        this.hasMore = z;
        return bB;
    }

    private boolean bB(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.fHn.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fHn.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.fHo.addAll(arrayList);
        this.fHp = bC(this.fHo);
        return !y.isEmpty(this.fHp);
    }

    private ArrayList<q> bC(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fCy = list.get(i);
            aVar.isLeft = true;
            aVar.eei = this.eei;
            aVar.fid = this.eVx;
            aVar.fname = this.fEW;
            aVar.position = i + 1;
            eVar.fED = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fCy = list.get(i + 1);
                aVar2.eei = this.eei;
                aVar2.fid = this.eVx;
                aVar2.fname = this.fEW;
                aVar2.position = i + 2;
                eVar.fEE = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fCz = true;
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
        if (!y.isEmpty(this.fHp)) {
            arrayList.addAll(this.fHp);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fHn != null) {
            this.fHn.clear();
        }
        if (this.fHo != null) {
            this.fHo.clear();
        }
        if (this.fHp != null) {
            this.fHp.clear();
        }
    }
}
