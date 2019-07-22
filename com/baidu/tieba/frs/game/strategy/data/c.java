package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int bFL;
    public int fFg;
    public List<m> fFh;
    public boolean hasMore;
    public String key;
    public int pn;

    public int cd(List<m> list) {
        boolean z;
        if (v.aa(list)) {
            return 0;
        }
        if (v.aa(this.fFh)) {
            this.fFh = new LinkedList();
            this.fFh.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fFh.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fFh.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bg acx = ((b) mVar).acx();
                    bg acx2 = ((b) mVar2).acx();
                    if (acx != null && acx2 != null && acx.getTid() != null && acx2.getTid() != null && acx.getTid().equals(acx2.getTid())) {
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
            v.a((List) this.fFh, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
