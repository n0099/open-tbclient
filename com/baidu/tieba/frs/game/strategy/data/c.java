package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int fGY;
    public List<m> fGZ;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cp(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.fGZ)) {
            this.fGZ = new LinkedList();
            this.fGZ.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fGZ.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fGZ.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bh agI = ((b) mVar).agI();
                    bh agI2 = ((b) mVar2).agI();
                    if (agI != null && agI2 != null && agI.getTid() != null && agI2.getTid() != null && agI.getTid().equals(agI2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.add(linkedList, mVar);
            }
        }
        if (linkedList.size() != 0) {
            v.addAll(this.fGZ, 0, linkedList);
        }
        return linkedList.size();
    }
}
