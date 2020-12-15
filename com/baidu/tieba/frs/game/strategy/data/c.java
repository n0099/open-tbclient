package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    public boolean hasMore;
    public int jjX;
    public List<q> jjY;
    public String key;
    public int labelId;
    public int pn;

    public int dr(List<q> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.jjY)) {
            this.jjY = new LinkedList();
            this.jjY.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            q qVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.jjY.size()) {
                    z = false;
                    break;
                }
                q qVar2 = this.jjY.get(i2);
                if (qVar != null && (qVar instanceof b) && qVar2 != null && (qVar2 instanceof b)) {
                    by bmn = ((b) qVar).bmn();
                    by bmn2 = ((b) qVar2).bmn();
                    if (bmn != null && bmn2 != null && bmn.getTid() != null && bmn2.getTid() != null && bmn.getTid().equals(bmn2.getTid())) {
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
            y.addAll(this.jjY, 0, linkedList);
        }
        return linkedList.size();
    }
}
