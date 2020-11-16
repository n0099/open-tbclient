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
    private boolean eFf;
    private String fyg;
    private String gjS;
    private boolean hasMore = false;
    private List<String> gmp = new ArrayList();
    private List<SdkLiveInfoData> gmq = new ArrayList();
    private List<q> gmr = new ArrayList();

    public d(j jVar, String str, String str2) {
        this.eFf = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.eFf = true;
        }
        this.fyg = str;
        this.gjS = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean cb = cb(jVar.gjv);
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
                if (!this.gmp.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.gmp.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList)) {
            return false;
        }
        this.gmq.addAll(arrayList);
        this.gmr = ca(this.gmq);
        return !y.isEmpty(this.gmr);
    }

    private ArrayList<q> ca(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ghs = list.get(i);
            aVar.isLeft = true;
            aVar.eFf = this.eFf;
            aVar.fid = this.fyg;
            aVar.fname = this.gjS;
            aVar.position = i + 1;
            eVar.gjz = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ghs = list.get(i + 1);
                aVar2.eFf = this.eFf;
                aVar2.fid = this.fyg;
                aVar2.fname = this.gjS;
                aVar2.position = i + 2;
                eVar.gjA = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ght = true;
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
        if (!y.isEmpty(this.gmr)) {
            arrayList.addAll(this.gmr);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gmp != null) {
            this.gmp.clear();
        }
        if (this.gmq != null) {
            this.gmq.clear();
        }
        if (this.gmr != null) {
            this.gmr.clear();
        }
    }
}
