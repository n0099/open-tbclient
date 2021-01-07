package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId izq = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eMv == null || this.eMv.getThreadType() != 67) ? TYPE : izq;
    }

    public j(bz bzVar) {
        this.eMv = bzVar;
    }

    public static boolean ad(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (bzVar.getThreadType() == 49) {
            return true;
        }
        return bzVar.getThreadType() == 67 && bzVar.brK() != null && bzVar.brK().friendRoomStatus == 2;
    }

    public aq Jt(String str) {
        aq Js = Js(str);
        Js.delete("obj_type");
        Js.delete("obj_type");
        Js.an("obj_type", 3);
        return Js;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boP() {
        return this.eMv;
    }
}
