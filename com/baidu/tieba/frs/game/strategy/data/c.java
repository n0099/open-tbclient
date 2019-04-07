package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int fjM;
    public List<m> fjN;
    public boolean hasMore;
    public String key;
    public int labelId;
    public int pn;

    public int bU(List<m> list) {
        boolean z;
        if (v.T(list)) {
            return 0;
        }
        if (v.T(this.fjN)) {
            this.fjN = new LinkedList();
            this.fjN.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fjN.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fjN.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bg WO = ((b) mVar).WO();
                    bg WO2 = ((b) mVar2).WO();
                    if (WO != null && WO2 != null && WO.getTid() != null && WO2.getTid() != null && WO.getTid().equals(WO2.getTid())) {
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
            v.a((List) this.fjN, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
