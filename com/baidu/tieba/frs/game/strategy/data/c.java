package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dVR;
    public List<h> dVS;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bI(List<h> list) {
        boolean z;
        if (v.I(list)) {
            return 0;
        }
        if (v.I(this.dVS)) {
            this.dVS = new LinkedList();
            this.dVS.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dVS.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dVS.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb ZT = ((b) hVar).ZT();
                    bb ZT2 = ((b) hVar2).ZT();
                    if (ZT != null && ZT2 != null && ZT.getTid() != null && ZT2.getTid() != null && ZT.getTid().equals(ZT2.getTid())) {
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
            v.a((List) this.dVS, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
