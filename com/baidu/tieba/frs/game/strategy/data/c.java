package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public int guA;
    public List<m> guB;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cl(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.guB)) {
            this.guB = new LinkedList();
            this.guB.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.guB.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.guB.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj axx = ((b) mVar).axx();
                    bj axx2 = ((b) mVar2).axx();
                    if (axx != null && axx2 != null && axx.getTid() != null && axx2.getTid() != null && axx.getTid().equals(axx2.getTid())) {
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
            v.addAll(this.guB, 0, linkedList);
        }
        return linkedList.size();
    }
}
