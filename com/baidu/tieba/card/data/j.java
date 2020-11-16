package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes20.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId ibW = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.evQ == null || this.evQ.getThreadType() != 67) ? TYPE : ibW;
    }

    public j(bx bxVar) {
        this.evQ = bxVar;
    }

    public static boolean ad(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        if (bxVar.getThreadType() == 49) {
            return true;
        }
        return bxVar.getThreadType() == 67 && bxVar.blW() != null && bxVar.blW().friendRoomStatus == 2;
    }

    public ar IG(String str) {
        ar IF = IF(str);
        IF.delete("obj_type");
        IF.delete("obj_type");
        IF.ak("obj_type", 3);
        return IF;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this.evQ;
    }
}
