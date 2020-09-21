package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    public boolean hasMore;
    public int ioy;
    public List<q> ioz;
    public String key;
    public int labelId;
    public int pn;

    public int cO(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.ioz)) {
            this.ioz = new LinkedList();
            this.ioz.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.ioz.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.ioz.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bw bcY = ((b) qVar).bcY();
                    bw bcY2 = ((b) qVar2).bcY();
                    if (bcY != null && bcY2 != null && bcY.getTid() != null && bcY2.getTid() != null && bcY.getTid().equals(bcY2.getTid())) {
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
            y.addAll(this.ioz, 0, linkedList);
        }
        return linkedList.size();
    }
}
