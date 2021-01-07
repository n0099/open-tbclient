package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public boolean hasMore;
    public int jww;
    public List<n> jwx;
    public String key;
    public int labelId;
    public int pn;

    public int dz(List<n> list) {
        boolean z;
        if (x.isEmpty(list)) {
            return 0;
        }
        if (x.isEmpty(this.jwx)) {
            this.jwx = new LinkedList();
            this.jwx.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            n nVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.jwx.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.jwx.get(i2);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    bz boP = ((b) nVar).boP();
                    bz boP2 = ((b) nVar2).boP();
                    if (boP != null && boP2 != null && boP.getTid() != null && boP2.getTid() != null && boP.getTid().equals(boP2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                x.add(linkedList, nVar);
            }
        }
        if (linkedList.size() != 0) {
            x.addAll(this.jwx, 0, linkedList);
        }
        return linkedList.size();
    }
}
