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
    private List<String> gmI = new ArrayList();
    private List<SdkLiveInfoData> gmJ = new ArrayList();
    private List<q> gmK = new ArrayList();

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
        ArrayList<SdkLiveInfoData> arrayList = jVar.gjO;
        if (y.isEmpty(arrayList)) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<SdkLiveInfoData> it = arrayList.iterator();
        while (it.hasNext()) {
            SdkLiveInfoData next = it.next();
            if (next != null && com.baidu.tieba.ala.alasquare.live_tab.c.a(next)) {
                String str = next.liveId;
                if (!this.gmI.contains(str)) {
                    arrayList2.add(next);
                    this.gmI.add(str);
                }
            }
        }
        if (y.isEmpty(arrayList2)) {
            return false;
        }
        this.gmJ.addAll(arrayList2);
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
            eVar.gjS = aVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.a aVar2 = new com.baidu.tieba.ala.alasquare.a.a();
                aVar2.ghL = list.get(i + 1);
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
