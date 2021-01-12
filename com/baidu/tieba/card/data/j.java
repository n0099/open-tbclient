package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class j extends k {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId iuJ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eHK == null || this.eHK.getThreadType() != 67) ? TYPE : iuJ;
    }

    public j(bz bzVar) {
        this.eHK = bzVar;
    }

    public static boolean ad(bz bzVar) {
        if (bzVar == null) {
            return false;
        }
        if (bzVar.getThreadType() == 49) {
            return true;
        }
        return bzVar.getThreadType() == 67 && bzVar.bnQ() != null && bzVar.bnQ().friendRoomStatus == 2;
    }

    public aq Ii(String str) {
        aq Ih = Ih(str);
        Ih.delete("obj_type");
        Ih.delete("obj_type");
        Ih.an("obj_type", 3);
        return Ih;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz bkV() {
        return this.eHK;
    }
}
