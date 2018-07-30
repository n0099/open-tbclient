package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dwM;
    public List<h> dwN;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bq(List<h> list) {
        boolean z;
        if (w.z(list)) {
            return 0;
        }
        if (w.z(this.dwN)) {
            this.dwN = new LinkedList();
            this.dwN.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dwN.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dwN.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb Td = ((b) hVar).Td();
                    bb Td2 = ((b) hVar2).Td();
                    if (Td != null && Td2 != null && Td.getTid() != null && Td2.getTid() != null && Td.getTid().equals(Td2.getTid())) {
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
            w.a((List) this.dwN, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
