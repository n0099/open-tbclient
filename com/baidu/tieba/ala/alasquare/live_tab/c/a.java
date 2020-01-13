package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private boolean hasMore = false;
    private List<String> ekl = new ArrayList();
    private List<SdkLiveInfoData> ekm = new ArrayList();
    private List<m> ekn = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z) {
        j(list, z);
    }

    public boolean j(List<SdkLiveInfoData> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bi = bi(list);
        this.hasMore = z;
        return bi;
    }

    private boolean bi(List<SdkLiveInfoData> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (SdkLiveInfoData sdkLiveInfoData : list) {
            if (sdkLiveInfoData != null) {
                String str = sdkLiveInfoData.roomId;
                if (!this.ekl.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.ekl.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.ekm.addAll(arrayList);
        this.ekn = bj(this.ekm);
        return !v.isEmpty(this.ekn);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.efB = list.get(i);
            aVar.isLeft = true;
            eVar.ehD = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.efB = list.get(i + 1);
                eVar.ehE = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.efC = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.ekn)) {
            arrayList.addAll(this.ekn);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.ekl != null) {
            this.ekl.clear();
        }
        if (this.ekm != null) {
            this.ekm.clear();
        }
        if (this.ekn != null) {
            this.ekn.clear();
        }
    }
}
