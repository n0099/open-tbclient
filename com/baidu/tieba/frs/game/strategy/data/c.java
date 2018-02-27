package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dNM;
    public List<i> dNN;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bo(List<i> list) {
        boolean z;
        if (v.E(list)) {
            return 0;
        }
        if (v.E(this.dNN)) {
            this.dNN = new LinkedList();
            this.dNN.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            i iVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dNN.size()) {
                    z = false;
                    break;
                }
                i iVar2 = this.dNN.get(i2);
                if (iVar != null && (iVar instanceof b) && iVar2 != null && (iVar2 instanceof b)) {
                    bd WD = ((b) iVar).WD();
                    bd WD2 = ((b) iVar2).WD();
                    if (WD != null && WD2 != null && WD.getTid() != null && WD2.getTid() != null && WD.getTid().equals(WD2.getTid())) {
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
            v.a((List) this.dNN, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
