package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId imT = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.eCR == null || this.eCR.getThreadType() != 67) ? TYPE : imT;
    }

    public j(by byVar) {
        this.eCR = byVar;
    }

    public static boolean ad(by byVar) {
        if (byVar == null) {
            return false;
        }
        if (byVar.getThreadType() == 49) {
            return true;
        }
        return byVar.getThreadType() == 67 && byVar.bpj() != null && byVar.bpj().friendRoomStatus == 2;
    }

    public ar Jw(String str) {
        ar Jv = Jv(str);
        Jv.delete("obj_type");
        Jv.delete("obj_type");
        Jv.al("obj_type", 3);
        return Jv;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        return this.eCR;
    }
}
