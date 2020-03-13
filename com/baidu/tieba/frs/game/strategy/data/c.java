package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public int gzY;
    public List<m> gzZ;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int ch(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.gzZ)) {
            this.gzZ = new LinkedList();
            this.gzZ.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.gzZ.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.gzZ.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj aAg = ((b) mVar).aAg();
                    bj aAg2 = ((b) mVar2).aAg();
                    if (aAg != null && aAg2 != null && aAg.getTid() != null && aAg2.getTid() != null && aAg.getTid().equals(aAg2.getTid())) {
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
            v.addAll(this.gzZ, 0, linkedList);
        }
        return linkedList.size();
    }
}
