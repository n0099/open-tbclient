package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public boolean hasMore;
    public int jxK;
    public List<n> jxL;
    public String key;
    public int labelId;
    public int pn;

    public int du(List<n> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.jxL)) {
            this.jxL = new LinkedList();
            this.jxL.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            n nVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.jxL.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.jxL.get(i2);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    cb bln = ((b) nVar).bln();
                    cb bln2 = ((b) nVar2).bln();
                    if (bln != null && bln2 != null && bln.getTid() != null && bln2.getTid() != null && bln.getTid().equals(bln2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                y.add(linkedList, nVar);
            }
        }
        if (linkedList.size() != 0) {
            y.addAll(this.jxL, 0, linkedList);
        }
        return linkedList.size();
    }
}
