package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dTa;
    public List<h> dTb;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bH(List<h> list) {
        boolean z;
        if (v.I(list)) {
            return 0;
        }
        if (v.I(this.dTb)) {
            this.dTb = new LinkedList();
            this.dTb.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dTb.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dTb.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb ZR = ((b) hVar).ZR();
                    bb ZR2 = ((b) hVar2).ZR();
                    if (ZR != null && ZR2 != null && ZR.getTid() != null && ZR2.getTid() != null && ZR.getTid().equals(ZR2.getTid())) {
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
            v.a((List) this.dTb, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
