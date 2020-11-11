package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    public boolean hasMore;
    public int iVK;
    public List<q> iVL;
    public String key;
    public int labelId;
    public int pn;

    public int di(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.iVL)) {
            this.iVL = new LinkedList();
            this.iVL.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.iVL.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.iVL.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bw bjZ = ((b) qVar).bjZ();
                    bw bjZ2 = ((b) qVar2).bjZ();
                    if (bjZ != null && bjZ2 != null && bjZ.getTid() != null && bjZ2.getTid() != null && bjZ.getTid().equals(bjZ2.getTid())) {
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
            y.addAll(this.iVL, 0, linkedList);
        }
        return linkedList.size();
    }
}
