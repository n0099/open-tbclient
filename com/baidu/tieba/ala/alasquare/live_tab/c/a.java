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
/* loaded from: classes6.dex */
public class a {
    private boolean hasMore = false;
    private List<String> guA = new ArrayList();
    private List<SdkLiveInfoData> guB = new ArrayList();
    private List<q> guC = new ArrayList();

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
        ArrayList<SdkLiveInfoData> arrayList = jVar.grG;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && com.baidu.tieba.ala.alasquare.live_tab.c.a(next)) {
                String str = next.liveId;
                if (!this.guA.contains(str)) {
                    arrayList2.add(next);
                    this.guA.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.guB.addAll(arrayList2);
        this.guC = ce(this.guB);
        return !y.isEmpty(this.guC);
    }

    private ArrayList<q> ce(List<SdkLiveInfoData> list) {
        ArrayList<q> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            e eVar = new e();
            com.baidu.tieba.ala.alasquare.a.a aVar = new com.baidu.tieba.ala.alasquare.a.a();
            aVar.gpE = list.get(i);
            aVar.isLeft = true;
            eVar.grK = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.gpE = list.get(i + 1);
                eVar.grL = aVar2;
                aVar2.isRight = true;
            } else {
                aVar.isLeft = false;
                aVar.gpF = true;
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
        if (!y.isEmpty(this.guC)) {
            arrayList.addAll(this.guC);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.guA != null) {
            this.guA.clear();
        }
        if (this.guB != null) {
            this.guB.clear();
        }
        if (this.guC != null) {
            this.guC.clear();
        }
    }
}
