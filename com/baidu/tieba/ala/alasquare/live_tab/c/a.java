package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private boolean dHL;
    private String evm;
    private String fcT;
    private boolean hasMore = false;
    private List<String> ffl = new ArrayList();
    private List<SdkLiveInfoData> ffm = new ArrayList();
    private List<o> ffn = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dHL = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dHL = true;
        }
        this.evm = str;
        this.fcT = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bn = bn(list);
        this.hasMore = z;
        return bn;
    }

    private boolean bn(List<SdkLiveInfoData> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.ffl.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.ffl.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.ffm.addAll(arrayList);
        this.ffn = bo(this.ffm);
        return !v.isEmpty(this.ffn);
    }

    private ArrayList<o> bo(List<SdkLiveInfoData> list) {
        ArrayList<o> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fav = list.get(i);
            aVar.isLeft = true;
            aVar.dHL = this.dHL;
            aVar.fid = this.evm;
            aVar.fname = this.fcT;
            aVar.position = i + 1;
            eVar.fcB = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fav = list.get(i + 1);
                aVar2.dHL = this.dHL;
                aVar2.fid = this.evm;
                aVar2.fname = this.fcT;
                aVar2.position = i + 2;
                eVar.fcC = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.faw = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<o> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.ffn)) {
            arrayList.addAll(this.ffn);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.ffl != null) {
            this.ffl.clear();
        }
        if (this.ffm != null) {
            this.ffm.clear();
        }
        if (this.ffn != null) {
            this.ffn.clear();
        }
    }
}
