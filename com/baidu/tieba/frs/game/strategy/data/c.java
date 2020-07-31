package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    public int hTg;
    public List<q> hTh;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cG(List<q> list) {
        boolean z;
        if (x.isEmpty(list)) {
            return 0;
        }
        if (x.isEmpty(this.hTh)) {
            this.hTh = new LinkedList();
            this.hTh.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.hTh.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.hTh.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bv aTN = ((b) qVar).aTN();
                    bv aTN2 = ((b) qVar2).aTN();
                    if (aTN != null && aTN2 != null && aTN.getTid() != null && aTN2.getTid() != null && aTN.getTid().equals(aTN2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                x.add(linkedList, qVar);
            }
        }
        if (linkedList.size() != 0) {
            x.addAll(this.hTh, 0, linkedList);
        }
        return linkedList.size();
    }
}
