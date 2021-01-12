package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public boolean hasMore;
    public int jrQ;
    public List<n> jrR;
    public String key;
    public int labelId;
    public int pn;

    public int dz(List<n> list) {
        boolean z;
        if (x.isEmpty(list)) {
            return 0;
        }
        if (x.isEmpty(this.jrR)) {
            this.jrR = new LinkedList();
            this.jrR.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            n nVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.jrR.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.jrR.get(i2);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    bz bkV = ((b) nVar).bkV();
                    bz bkV2 = ((b) nVar2).bkV();
                    if (bkV != null && bkV2 != null && bkV.getTid() != null && bkV2.getTid() != null && bkV.getTid().equals(bkV2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                x.add(linkedList, nVar);
            }
        }
        if (linkedList.size() != 0) {
            x.addAll(this.jrR, 0, linkedList);
        }
        return linkedList.size();
    }
}
