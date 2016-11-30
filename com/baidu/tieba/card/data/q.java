package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId bfz = BdUniqueId.gen();
    public boolean bfA = true;
    public boolean bfB = true;
    public String bfC;
    public List<p> bfD;
    public int bfE;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bfz;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Ps() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cy(boolean z) {
        this.bfA = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cz(boolean z) {
        this.bfB = z;
    }
}
