package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private boolean hasMore = false;
    private List<String> gDR = new ArrayList();
    private List<SdkLiveInfoData> gDS = new ArrayList();
    private List<n> gDT = new ArrayList();

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
        ArrayList<SdkLiveInfoData> arrayList = jVar.gAW;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && com.baidu.tieba.ala.alasquare.live_tab.c.a(next)) {
                String str = next.liveId;
                if (!this.gDR.contains(str)) {
                    arrayList2.add(next);
                    this.gDR.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.gDS.addAll(arrayList2);
        this.gDT = cg(this.gDS);
        return !y.isEmpty(this.gDT);
    }

    private ArrayList<n> cg(List<SdkLiveInfoData> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gyL = list.get(i);
            aVar.isLeft = true;
            eVar.gBa = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gyL = list.get(i + 1);
                eVar.gBb = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gyM = true;
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
        if (!y.isEmpty(this.gDT)) {
            arrayList.addAll(this.gDT);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.gDR != null) {
            this.gDR.clear();
        }
        if (this.gDS != null) {
            this.gDS.clear();
        }
        if (this.gDT != null) {
            this.gDT.clear();
        }
    }
}
