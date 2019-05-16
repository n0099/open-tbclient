package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int fAh;
    public List<m> fAi;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int cc(List<m> list) {
        boolean z;
        if (v.aa(list)) {
            return 0;
        }
        if (v.aa(this.fAi)) {
            this.fAi = new LinkedList();
            this.fAi.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fAi.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fAi.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bg abv = ((b) mVar).abv();
                    bg abv2 = ((b) mVar2).abv();
                    if (abv != null && abv2 != null && abv.getTid() != null && abv2.getTid() != null && abv.getTid().equals(abv2.getTid())) {
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
            v.a((List) this.fAi, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
