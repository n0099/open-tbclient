package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dtZ;
    public List<h> dua;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int br(List<h> list) {
        boolean z;
        if (w.A(list)) {
            return 0;
        }
        if (w.A(this.dua)) {
            this.dua = new LinkedList();
            this.dua.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dua.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dua.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bc SV = ((b) hVar).SV();
                    bc SV2 = ((b) hVar2).SV();
                    if (SV != null && SV2 != null && SV.getTid() != null && SV2.getTid() != null && SV.getTid().equals(SV2.getTid())) {
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
            w.a((List) this.dua, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
