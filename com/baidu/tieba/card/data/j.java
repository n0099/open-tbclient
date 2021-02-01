package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iAt = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eJQ == null || this.eJQ.getThreadType() != 67) ? TYPE : iAt;
    }

    public j(cb cbVar) {
        this.eJQ = cbVar;
    }

    public static boolean ae(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (cbVar.getThreadType() == 49) {
            return true;
        }
        return cbVar.getThreadType() == 67 && cbVar.boj() != null && cbVar.boj().friendRoomStatus == 2;
    }

    public ar IT(String str) {
        ar IS = IS(str);
        IS.delete("obj_type");
        IS.delete("obj_type");
        IS.ap("obj_type", 3);
        return IS;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        return this.eJQ;
    }
}
