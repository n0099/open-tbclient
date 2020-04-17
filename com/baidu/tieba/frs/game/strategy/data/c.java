package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public boolean hasMore;
    public int hks;
    public List<m> hkt;
    public String key;
    public int labelId;
    public int pn;

    public int ct(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.hkt)) {
            this.hkt = new LinkedList();
            this.hkt.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.hkt.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.hkt.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj aIw = ((b) mVar).aIw();
                    bj aIw2 = ((b) mVar2).aIw();
                    if (aIw != null && aIw2 != null && aIw.getTid() != null && aIw2.getTid() != null && aIw.getTid().equals(aIw2.getTid())) {
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
            v.addAll(this.hkt, 0, linkedList);
        }
        return linkedList.size();
    }
}
