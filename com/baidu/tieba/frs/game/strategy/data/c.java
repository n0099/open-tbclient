package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public boolean hasMore;
    public int jzt;
    public List<n> jzu;
    public String key;
    public int labelId;
    public int pn;

    public int du(List<n> list) {
        boolean z;
        if (y.isEmpty(list)) {
            return 0;
        }
        if (y.isEmpty(this.jzu)) {
            this.jzu = new LinkedList();
            this.jzu.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            n nVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.jzu.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.jzu.get(i2);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    cb blp = ((b) nVar).blp();
                    cb blp2 = ((b) nVar2).blp();
                    if (blp != null && blp2 != null && blp.getTid() != null && blp2.getTid() != null && blp.getTid().equals(blp2.getTid())) {
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
            y.addAll(this.jzu, 0, linkedList);
        }
        return linkedList.size();
    }
}
