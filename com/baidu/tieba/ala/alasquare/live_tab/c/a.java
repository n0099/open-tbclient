package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private boolean cUr;
    private String emo;
    private String emp;
    private boolean hasMore = false;
    private List<String> eoK = new ArrayList();
    private List<SdkLiveInfoData> eoL = new ArrayList();
    private List<m> eoM = new ArrayList();

    public a(List<SdkLiveInfoData> list, boolean z, String str, String str2) {
        this.cUr = false;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.cUr = true;
        }
        this.emo = str;
        this.emp = str2;
        k(list, z);
    }

    public boolean k(List<SdkLiveInfoData> list, boolean z) {
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
                if (!this.eoK.contains(str)) {
                    arrayList.add(sdkLiveInfoData);
                    this.eoK.add(str);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.eoL.addAll(arrayList);
        this.eoM = bj(this.eoL);
        return !v.isEmpty(this.eoM);
    }

    private ArrayList<m> bj(List<SdkLiveInfoData> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.ejT = list.get(i);
            aVar.isLeft = true;
            aVar.cUr = this.cUr;
            aVar.fid = this.emo;
            aVar.fname = this.emp;
            aVar.position = i + 1;
            eVar.elW = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ejT = list.get(i + 1);
                aVar2.cUr = this.cUr;
                aVar2.fid = this.emo;
                aVar2.fname = this.emp;
                aVar2.position = i + 2;
                eVar.elX = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.ejU = true;
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
        if (!v.isEmpty(this.eoM)) {
            arrayList.addAll(this.eoM);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.eoK != null) {
            this.eoK.clear();
        }
        if (this.eoL != null) {
            this.eoL.clear();
        }
        if (this.eoM != null) {
            this.eoM.clear();
        }
    }
}
