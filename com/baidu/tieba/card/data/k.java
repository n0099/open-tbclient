package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class k extends l {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hVh = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.erH == null || this.erH.getThreadType() != 67) ? TYPE : hVh;
    }

    public k(bw bwVar) {
        this.erH = bwVar;
    }

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        if (bwVar.getThreadType() == 49) {
            return true;
        }
        return bwVar.getThreadType() == 67 && bwVar.bku() != null && bwVar.bku().friendRoomStatus == 2;
    }

    public aq IN(String str) {
        aq IO = IO(str);
        IO.delete("obj_type");
        IO.delete("obj_type");
        IO.aj("obj_type", 3);
        return IO;
    }

    @Override // com.baidu.tieba.card.data.l, com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this.erH;
    }
}
