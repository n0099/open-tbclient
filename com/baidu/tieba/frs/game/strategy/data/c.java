package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public int gxK;
    public List<m> gxL;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cl(List<m> list) {
        boolean z;
        if (v.isEmpty(list)) {
            return 0;
        }
        if (v.isEmpty(this.gxL)) {
            this.gxL = new LinkedList();
            this.gxL.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.gxL.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.gxL.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bj axQ = ((b) mVar).axQ();
                    bj axQ2 = ((b) mVar2).axQ();
                    if (axQ != null && axQ2 != null && axQ.getTid() != null && axQ2.getTid() != null && axQ.getTid().equals(axQ2.getTid())) {
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
            v.addAll(this.gxL, 0, linkedList);
        }
        return linkedList.size();
    }
}
