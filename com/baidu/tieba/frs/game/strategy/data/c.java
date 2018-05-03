package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dgu;
    public List<h> dgv;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bi(List<h> list) {
        boolean z;
        if (v.w(list)) {
            return 0;
        }
        if (v.w(this.dgv)) {
            this.dgv = new LinkedList();
            this.dgv.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dgv.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dgv.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bd Pe = ((b) hVar).Pe();
                    bd Pe2 = ((b) hVar2).Pe();
                    if (Pe != null && Pe2 != null && Pe.getTid() != null && Pe2.getTid() != null && Pe.getTid().equals(Pe2.getTid())) {
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
            v.a((List) this.dgv, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
