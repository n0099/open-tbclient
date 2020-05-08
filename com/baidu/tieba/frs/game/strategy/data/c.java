package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public boolean hasMore;
    public int hky;
    public List<m> hkz;
    public String key;
    public int labelId;
    public int pn;

    public int ct(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.hkz)) {
            this.hkz = new LinkedList();
            this.hkz.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.hkz.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.hkz.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj aIu = ((b) mVar).aIu();
                    bj aIu2 = ((b) mVar2).aIu();
                    if (aIu != null && aIu2 != null && aIu.getTid() != null && aIu2.getTid() != null && aIu.getTid().equals(aIu2.getTid())) {
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
            v.addAll(this.hkz, 0, linkedList);
        }
        return linkedList.size();
    }
}
