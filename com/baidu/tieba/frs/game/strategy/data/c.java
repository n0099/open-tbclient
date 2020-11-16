package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    public boolean hasMore;
    public int iWw;
    public List<q> iWx;
    public String key;
    public int labelId;
    public int pn;

    public int di(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.iWx)) {
            this.iWx = new LinkedList();
            this.iWx.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.iWx.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.iWx.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bx bjd = ((b) qVar).bjd();
                    bx bjd2 = ((b) qVar2).bjd();
                    if (bjd != null && bjd2 != null && bjd.getTid() != null && bjd2.getTid() != null && bjd.getTid().equals(bjd2.getTid())) {
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
            y.addAll(this.iWx, 0, linkedList);
        }
        return linkedList.size();
    }
}
