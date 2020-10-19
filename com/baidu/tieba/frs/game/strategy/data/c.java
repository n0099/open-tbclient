package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    public boolean hasMore;
    public int iDr;
    public List<q> iDs;
    public String key;
    public int labelId;
    public int pn;

    public int cR(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.iDs)) {
            this.iDs = new LinkedList();
            this.iDs.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.iDs.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.iDs.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bw bfG = ((b) qVar).bfG();
                    bw bfG2 = ((b) qVar2).bfG();
                    if (bfG != null && bfG2 != null && bfG.getTid() != null && bfG2.getTid() != null && bfG.getTid().equals(bfG2.getTid())) {
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
            y.addAll(this.iDs, 0, linkedList);
        }
        return linkedList.size();
    }
}
