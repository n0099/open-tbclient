package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iCq = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eLr == null || this.eLr.getThreadType() != 67) ? TYPE : iCq;
    }

    public j(cb cbVar) {
        this.eLr = cbVar;
    }

    public static boolean ae(cb cbVar) {
        if (cbVar == null) {
            return false;
        }
        if (cbVar.getThreadType() == 49) {
            return true;
        }
        return cbVar.getThreadType() == 67 && cbVar.bol() != null && cbVar.bol().friendRoomStatus == 2;
    }

    public ar Jd(String str) {
        ar Jc = Jc(str);
        Jc.delete("obj_type");
        Jc.delete("obj_type");
        Jc.aq("obj_type", 3);
        return Jc;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb blp() {
        return this.eLr;
    }
}
