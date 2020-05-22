package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public boolean hasMore;
    public int hzm;
    public List<o> hzn;
    public String key;
    public int labelId;
    public int pn;

    public int cq(List<o> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.hzn)) {
            this.hzn = new LinkedList();
            this.hzn.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            o oVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.hzn.size()) {
                    z = false;
                    break;
                }
                o oVar2 = this.hzn.get(i2);
                if (oVar != null && (oVar instanceof b) && oVar2 != null && (oVar2 instanceof b)) {
                    bk aOi = ((b) oVar).aOi();
                    bk aOi2 = ((b) oVar2).aOi();
                    if (aOi != null && aOi2 != null && aOi.getTid() != null && aOi2.getTid() != null && aOi.getTid().equals(aOi2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.add(linkedList, oVar);
            }
        }
        if (linkedList.size() != 0) {
            v.addAll(this.hzn, 0, linkedList);
        }
        return linkedList.size();
    }
}
