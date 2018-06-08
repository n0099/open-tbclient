package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dqQ;
    public List<h> dqR;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bo(List<h> list) {
        boolean z;
        if (w.z(list)) {
            return 0;
        }
        if (w.z(this.dqR)) {
            this.dqR = new LinkedList();
            this.dqR.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dqR.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dqR.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bd Sz = ((b) hVar).Sz();
                    bd Sz2 = ((b) hVar2).Sz();
                    if (Sz != null && Sz2 != null && Sz.getTid() != null && Sz2.getTid() != null && Sz.getTid().equals(Sz2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                w.b(linkedList, hVar);
            }
        }
        if (linkedList.size() != 0) {
            w.a((List) this.dqR, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
