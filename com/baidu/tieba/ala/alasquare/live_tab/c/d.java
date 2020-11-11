package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private boolean eGN;
    private String fyR;
    private String gkl;
    private boolean hasMore = false;
    private List<String> gmI = new ArrayList();
    private List<SdkLiveInfoData> gmJ = new ArrayList();
    private List<q> gmK = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.eGN = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eGN = true;
        }
        this.fyR = str;
        this.gkl = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean cb = cb(jVar.gjO);
        this.hasMore = jVar.hasMore;
        return cb;
    }

    private boolean cb(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.gmI.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gmI.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.gmJ.addAll(arrayList);
        this.gmK = ca(this.gmJ);
        return !y.isEmpty(this.gmK);
    }

    private ArrayList<q> ca(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ghL = list.get(i);
            aVar.isLeft = true;
            aVar.eGN = this.eGN;
            aVar.fid = this.fyR;
            aVar.fname = this.gkl;
            aVar.position = i + 1;
            eVar.gjS = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ghL = list.get(i + 1);
                aVar2.eGN = this.eGN;
                aVar2.fid = this.fyR;
                aVar2.fname = this.gkl;
                aVar2.position = i + 2;
                eVar.gjT = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ghM = true;
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
        if (!y.isEmpty(this.gmK)) {
            arrayList.addAll(this.gmK);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gmI != null) {
            this.gmI.clear();
        }
        if (this.gmJ != null) {
            this.gmJ.clear();
        }
        if (this.gmK != null) {
            this.gmK.clear();
        }
    }
}
