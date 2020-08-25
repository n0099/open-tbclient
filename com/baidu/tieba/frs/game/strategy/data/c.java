package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    public boolean hasMore;
    public int ihq;
    public List<q> ihr;
    public String key;
    public int labelId;
    public int pn;

    public int cI(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.ihr)) {
            this.ihr = new LinkedList();
            this.ihr.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.ihr.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.ihr.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bw bce = ((b) qVar).bce();
                    bw bce2 = ((b) qVar2).bce();
                    if (bce != null && bce2 != null && bce.getTid() != null && bce2.getTid() != null && bce.getTid().equals(bce2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                y.add(linkedList, qVar);
            }
        }
        if (linkedList.size() != 0) {
            y.addAll(this.ihr, 0, linkedList);
        }
        return linkedList.size();
    }
}
