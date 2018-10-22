package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dLt;
    public List<h> dLu;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bH(List<h> list) {
        boolean z;
        if (v.J(list)) {
            return 0;
        }
        if (v.J(this.dLu)) {
            this.dLu = new LinkedList();
            this.dLu.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dLu.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dLu.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb YB = ((b) hVar).YB();
                    bb YB2 = ((b) hVar2).YB();
                    if (YB != null && YB2 != null && YB.getTid() != null && YB2.getTid() != null && YB.getTid().equals(YB2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.b(linkedList, hVar);
            }
        }
        if (linkedList.size() != 0) {
            v.a((List) this.dLu, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
