package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dMx;
    public List<h> dMy;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bF(List<h> list) {
        boolean z;
        if (v.I(list)) {
            return 0;
        }
        if (v.I(this.dMy)) {
            this.dMy = new LinkedList();
            this.dMy.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dMy.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dMy.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb YL = ((b) hVar).YL();
                    bb YL2 = ((b) hVar2).YL();
                    if (YL != null && YL2 != null && YL.getTid() != null && YL2.getTid() != null && YL.getTid().equals(YL2.getTid())) {
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
            v.a((List) this.dMy, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
