package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hIK = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.eji == null || this.eji.getThreadType() != 67) ? TYPE : hIK;
    }

    public k(bw bwVar) {
        this.eji = bwVar;
    }

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getThreadType() == 49 || bwVar.getThreadType() == 67;
    }

    public aq Io(String str) {
        aq Ip = Ip(str);
        Ip.delete("obj_type");
        Ip.delete("obj_type");
        Ip.aj("obj_type", 3);
        return Ip;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return this.eji;
    }
}
