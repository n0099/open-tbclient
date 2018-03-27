package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dNR;
    public List<i> dNS;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bo(List<i> list) {
        boolean z;
        if (v.E(list)) {
            return 0;
        }
        if (v.E(this.dNS)) {
            this.dNS = new LinkedList();
            this.dNS.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            i iVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dNS.size()) {
                    z = false;
                    break;
                }
                i iVar2 = this.dNS.get(i2);
                if (iVar != null && (iVar instanceof b) && iVar2 != null && (iVar2 instanceof b)) {
                    bd WE = ((b) iVar).WE();
                    bd WE2 = ((b) iVar2).WE();
                    if (WE != null && WE2 != null && WE.getTid() != null && WE2.getTid() != null && WE.getTid().equals(WE2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.b(linkedList, iVar);
            }
        }
        if (linkedList.size() != 0) {
            v.a((List) this.dNS, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
