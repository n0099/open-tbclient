package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public int gAW;
    public List<m> gAX;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int ch(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.gAX)) {
            this.gAX = new LinkedList();
            this.gAX.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.gAX.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.gAX.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj aAj = ((b) mVar).aAj();
                    bj aAj2 = ((b) mVar2).aAj();
                    if (aAj != null && aAj2 != null && aAj.getTid() != null && aAj2.getTid() != null && aAj.getTid().equals(aAj2.getTid())) {
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
            v.addAll(this.gAX, 0, linkedList);
        }
        return linkedList.size();
    }
}
