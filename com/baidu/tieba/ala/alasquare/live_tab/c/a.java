package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.live_tab.b.j;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private boolean hasMore = false;
    private List<String> fWQ = new ArrayList();
    private List<SdkLiveInfoData> fWR = new ArrayList();
    private List<q> fWS = new ArrayList();

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean b = b(jVar);
        this.hasMore = jVar.hasMore;
        return b;
    }

    private boolean b(j jVar) {
        if (jVar == null) {
            return false;
        }
        ArrayList<SdkLiveInfoData> arrayList = jVar.fTV;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null) {
                String str = next.liveId;
                if (!this.fWQ.contains(str)) {
                    arrayList2.add(next);
                    this.fWQ.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.fWR.addAll(arrayList2);
        this.fWS = bJ(this.fWR);
        return !y.isEmpty(this.fWS);
    }

    private ArrayList<q> bJ(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.fRT = list.get(i);
            aVar.isLeft = true;
            eVar.fTZ = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.fRT = list.get(i + 1);
                eVar.fUa = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.fRU = true;
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
        if (!y.isEmpty(this.fWS)) {
            arrayList.addAll(this.fWS);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.fWQ != null) {
            this.fWQ.clear();
        }
        if (this.fWR != null) {
            this.fWR.clear();
        }
        if (this.fWS != null) {
            this.fWS.clear();
        }
    }
}
