package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId hJy = BdUniqueId.gen();
    public String hJB;
    public List<n> hJC;
    public int locate;
    public int position;
    public boolean hJz = true;
    public boolean hJA = true;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hJy;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cjc() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oa(boolean z) {
        this.hJz = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void ob(boolean z) {
        this.hJA = z;
    }
}
