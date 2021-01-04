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
        return bzVar.getThreadType() == 67 && bzVar.brJ() != null && bzVar.brJ().friendRoomStatus == 2;
    }

    public aq Ju(String str) {
        aq Jt = Jt(str);
        Jt.delete("obj_type");
        Jt.delete("obj_type");
        Jt.an("obj_type", 3);
        return Jt;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boO() {
        return this.eMv;
    }
}
