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
public class c {
    private String eVt;
    private boolean eee;
    private String fES;
    private boolean hasMore = false;
    private List<String> fHn = new ArrayList();
    private List<SdkLiveInfoData> fHk = new ArrayList();
    private List<q> fHl = new ArrayList();

    public c(j jVar, String str, String str2) {
        this.eee = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eee = true;
        }
        this.eVt = str;
        this.fES = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean bB = bB(jVar.fEv);
        this.hasMore = jVar.hasMore;
        return bB;
    }

    private boolean bB(List<SdkLiveInfoData> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.liveId;
                if (!this.fHn.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.fHn.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.fHk.addAll(arrayList);
        this.fHl = bC(this.fHk);
        return !y.isEmpty(this.fHl);
    }

    private ArrayList<q> bC(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fCu = list.get(i);
            aVar.isLeft = true;
            aVar.eee = this.eee;
            aVar.fid = this.eVt;
            aVar.fname = this.fES;
            aVar.position = i + 1;
            eVar.fEz = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fCu = list.get(i + 1);
                aVar2.eee = this.eee;
                aVar2.fid = this.eVt;
                aVar2.fname = this.fES;
                aVar2.position = i + 2;
                eVar.fEA = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fCv = true;
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
        if (!y.isEmpty(this.fHl)) {
            arrayList.addAll(this.fHl);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fHn != null) {
            this.fHn.clear();
        }
        if (this.fHk != null) {
            this.fHk.clear();
        }
        if (this.fHl != null) {
            this.fHl.clear();
        }
    }
}
