package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private boolean hasMore = false;
    private List<String> gAT = new ArrayList();
    private List<SdkLiveInfoData> gAU = new ArrayList();
    private List<n> gAV = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean b2 = b(jVar);
        this.hasMore = jVar.hasMore;
        return b2;
    }

    private boolean b(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<SdkLiveInfoData> arrayList = jVar.gxY;
        if (x.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && com.baidu.tieba.ala.alasquare.live_tab.c.a(next)) {
                String str = next.liveId;
                if (!this.gAT.contains(str)) {
                    arrayList2.add(next);
                    this.gAT.add(str);
                }
            }
        }
        if (x.isEmpty(arrayList2)) {
            return false;
        }
        this.gAU.addAll(arrayList2);
        this.gAV = cl(this.gAU);
        return !x.isEmpty(this.gAV);
    }

    private ArrayList<n> cl(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gvN = list.get(i);
            aVar.isLeft = true;
            eVar.gyc = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gvN = list.get(i + 1);
                eVar.gyd = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gvO = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<n> getData() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.gAV)) {
            arrayList.addAll(this.gAV);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gAT != null) {
            this.gAT.clear();
        }
        if (this.gAU != null) {
            this.gAU.clear();
        }
        if (this.gAV != null) {
            this.gAV.clear();
        }
    }
}
