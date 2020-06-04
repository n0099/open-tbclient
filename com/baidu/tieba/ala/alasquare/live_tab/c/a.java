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
    private String fde;
    private boolean hasMore = false;
    private List<String> ffw = new ArrayList();
    private List<SdkLiveInfoData> ffx = new ArrayList();
    private List<o> ffy = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.dHL = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.dHL = true;
        }
        this.evm = str;
        this.fde = str2;
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
                if (!this.ffw.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.ffw.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.ffx.addAll(arrayList);
        this.ffy = bo(this.ffx);
        return !v.isEmpty(this.ffy);
    }

    private ArrayList<o> bo(List<SdkLiveInfoData> list) {
        ArrayList<o> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.faG = list.get(i);
            aVar.isLeft = true;
            aVar.dHL = this.dHL;
            aVar.fid = this.evm;
            aVar.fname = this.fde;
            aVar.position = i + 1;
            eVar.fcM = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.faG = list.get(i + 1);
                aVar2.dHL = this.dHL;
                aVar2.fid = this.evm;
                aVar2.fname = this.fde;
                aVar2.position = i + 2;
                eVar.fcN = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.faH = true;
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
        if (!v.isEmpty(this.ffy)) {
            arrayList.addAll(this.ffy);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.ffw != null) {
            this.ffw.clear();
        }
        if (this.ffx != null) {
            this.ffx.clear();
        }
        if (this.ffy != null) {
            this.ffy.clear();
        }
    }
}
