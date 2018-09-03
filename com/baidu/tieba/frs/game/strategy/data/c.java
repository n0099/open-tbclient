package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dwJ;
    public List<h> dwK;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bq(List<h> list) {
        boolean z;
        if (w.z(list)) {
            return 0;
        }
        if (w.z(this.dwK)) {
            this.dwK = new LinkedList();
            this.dwK.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dwK.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dwK.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bb Tg = ((b) hVar).Tg();
                    bb Tg2 = ((b) hVar2).Tg();
                    if (Tg != null && Tg2 != null && Tg.getTid() != null && Tg2.getTid() != null && Tg.getTid().equals(Tg2.getTid())) {
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
            w.a((List) this.dwK, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
