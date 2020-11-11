package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ibe = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.exA == null || this.exA.getThreadType() != 67) ? TYPE : ibe;
    }

    public k(bw bwVar) {
        this.exA = bwVar;
    }

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (bwVar.getThreadType() == 49) {
            return true;
        }
        return bwVar.getThreadType() == 67 && bwVar.bmU() != null && bwVar.bmU().friendRoomStatus == 2;
    }

    public aq Je(String str) {
        aq Jf = Jf(str);
        Jf.delete("obj_type");
        Jf.delete("obj_type");
        Jf.al("obj_type", 3);
        return Jf;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return this.exA;
    }
}
