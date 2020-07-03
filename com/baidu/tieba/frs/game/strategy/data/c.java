package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public int hNh;
    public List<q> hNi;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cB(List<q> list) {
        boolean z;
        if (w.isEmpty(list)) {
            return 0;
        }
        if (w.isEmpty(this.hNi)) {
            this.hNi = new LinkedList();
            this.hNi.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.hNi.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.hNi.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    bu aPS = ((b) qVar).aPS();
                    bu aPS2 = ((b) qVar2).aPS();
                    if (aPS != null && aPS2 != null && aPS.getTid() != null && aPS2.getTid() != null && aPS.getTid().equals(aPS2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                w.add(linkedList, qVar);
            }
        }
        if (linkedList.size() != 0) {
            w.addAll(this.hNi, 0, linkedList);
        }
        return linkedList.size();
    }
}
