package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    public boolean hasMore;
    public int iPN;
    public List<q> iPO;
    public String key;
    public int labelId;
    public int pn;

    public int da(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.iPO)) {
            this.iPO = new LinkedList();
            this.iPO.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.iPO.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.iPO.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bw bhz = ((b) qVar).bhz();
                    bw bhz2 = ((b) qVar2).bhz();
                    if (bhz != null && bhz2 != null && bhz.getTid() != null && bhz2.getTid() != null && bhz.getTid().equals(bhz2.getTid())) {
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
            y.addAll(this.iPO, 0, linkedList);
        }
        return linkedList.size();
    }
}
