package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public int gzK;
    public List<m> gzL;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int ch(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.gzL)) {
            this.gzL = new LinkedList();
            this.gzL.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.gzL.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.gzL.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj aAe = ((b) mVar).aAe();
                    bj aAe2 = ((b) mVar2).aAe();
                    if (aAe != null && aAe2 != null && aAe.getTid() != null && aAe2.getTid() != null && aAe.getTid().equals(aAe2.getTid())) {
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
            v.addAll(this.gzL, 0, linkedList);
        }
        return linkedList.size();
    }
}
