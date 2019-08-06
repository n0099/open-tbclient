package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int bFM;
    public int fFU;
    public List<m> fFV;
    public boolean hasMore;
    public String key;
    public int pn;

    public int cc(List<m> list) {
        boolean z;
        if (v.aa(list)) {
            return 0;
        }
        if (v.aa(this.fFV)) {
            this.fFV = new LinkedList();
            this.fFV.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fFV.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fFV.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bh acy = ((b) mVar).acy();
                    bh acy2 = ((b) mVar2).acy();
                    if (acy != null && acy2 != null && acy.getTid() != null && acy2.getTid() != null && acy.getTid().equals(acy2.getTid())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                v.b(linkedList, mVar);
            }
        }
        if (linkedList.size() != 0) {
            v.a((List) this.fFV, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
