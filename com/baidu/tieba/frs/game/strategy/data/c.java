package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public int bGk;
    public int fHJ;
    public List<m> fHK;
    public boolean hasMore;
    public String key;
    public int pn;

    public int cc(List<m> list) {
        boolean z;
        if (v.aa(list)) {
            return 0;
        }
        if (v.aa(this.fHK)) {
            this.fHK = new LinkedList();
            this.fHK.addAll(list);
            return list.size();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            m mVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.fHK.size()) {
                    z = false;
                    break;
                }
                m mVar2 = this.fHK.get(i2);
                if (mVar != null && (mVar instanceof b) && mVar2 != null && (mVar2 instanceof b)) {
                    bh acC = ((b) mVar).acC();
                    bh acC2 = ((b) mVar2).acC();
                    if (acC != null && acC2 != null && acC.getTid() != null && acC2.getTid() != null && acC.getTid().equals(acC2.getTid())) {
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
            v.a((List) this.fHK, 0, (List) linkedList);
        }
        return linkedList.size();
    }
}
