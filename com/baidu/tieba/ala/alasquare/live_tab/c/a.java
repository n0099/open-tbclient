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
    private String eYo;
    private boolean egs;
    private String fIi;
    private boolean hasMore = false;
    private List<String> fKz = new ArrayList();
    private List<SdkLiveInfoData> fKA = new ArrayList();
    private List<q> fKB = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.egs = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.egs = true;
        }
        this.eYo = str;
        this.fIi = str2;
        i(list, z);
    }

    public boolean i(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bG = bG(list);
        this.hasMore = z;
        return bG;
    }

    private boolean bG(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.fKz.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fKz.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.fKA.addAll(arrayList);
        this.fKB = bH(this.fKA);
        return !y.isEmpty(this.fKB);
    }

    private ArrayList<q> bH(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fFK = list.get(i);
            aVar.isLeft = true;
            aVar.egs = this.egs;
            aVar.fid = this.eYo;
            aVar.fname = this.fIi;
            aVar.position = i + 1;
            eVar.fHP = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fFK = list.get(i + 1);
                aVar2.egs = this.egs;
                aVar2.fid = this.eYo;
                aVar2.fname = this.fIi;
                aVar2.position = i + 2;
                eVar.fHQ = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fFL = true;
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
        if (!y.isEmpty(this.fKB)) {
            arrayList.addAll(this.fKB);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fKz != null) {
            this.fKz.clear();
        }
        if (this.fKA != null) {
            this.fKA.clear();
        }
        if (this.fKB != null) {
            this.fKB.clear();
        }
    }
}
