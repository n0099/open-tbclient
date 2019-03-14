package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int fka;
    public List<m> fkb;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bX(List<m> list) {
        boolean z;
        if (v.T(list)) {
            return 0;
        }
        if (v.T(this.fkb)) {
            this.fkb = new LinkedList();
            this.fkb.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fkb.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fkb.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bg WR = ((b) mVar).WR();
                    bg WR2 = ((b) mVar2).WR();
                    if (WR != null && WR2 != null && WR.getTid() != null && WR2.getTid() != null && WR.getTid().equals(WR2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.b(linkedList, mVar);
            }
        }
        if (linkedList.size() != 0) {
            v.a((List) this.fkb, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
