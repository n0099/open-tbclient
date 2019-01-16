package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dWx;
    public List<h> dWy;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bJ(List<h> list) {
        boolean z;
        if (v.I(list)) {
            return 0;
        }
        if (v.I(this.dWy)) {
            this.dWy = new LinkedList();
            this.dWy.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dWy.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dWy.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb aaq = ((b) hVar).aaq();
                    bb aaq2 = ((b) hVar2).aaq();
                    if (aaq != null && aaq2 != null && aaq.getTid() != null && aaq2.getTid() != null && aaq.getTid().equals(aaq2.getTid())) {
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
            v.a((List) this.dWy, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
