package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public int dhB;
    public List<h> dhC;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bl(List<h> list) {
        boolean z;
        if (v.w(list)) {
            return 0;
        }
        if (v.w(this.dhC)) {
            this.dhC = new LinkedList();
            this.dhC.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            h hVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.dhC.size()) {
                    z = false;
                    break;
                }
                h hVar2 = this.dhC.get(i2);
                if (hVar != null && (hVar instanceof b) && hVar2 != null && (hVar2 instanceof b)) {
                    bd Pb = ((b) hVar).Pb();
                    bd Pb2 = ((b) hVar2).Pb();
                    if (Pb != null && Pb2 != null && Pb.getTid() != null && Pb2.getTid() != null && Pb.getTid().equals(Pb2.getTid())) {
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
            v.a((List) this.dhC, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
