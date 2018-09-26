package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dDt;
    public List<h> dDu;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int br(List<h> list) {
        boolean z;
        if (v.z(list)) {
            return 0;
        }
        if (v.z(this.dDu)) {
            this.dDu = new LinkedList();
            this.dDu.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dDu.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dDu.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb UT = ((b) hVar).UT();
                    bb UT2 = ((b) hVar2).UT();
                    if (UT != null && UT2 != null && UT.getTid() != null && UT2.getTid() != null && UT.getTid().equals(UT2.getTid())) {
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
            v.a((List) this.dDu, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
