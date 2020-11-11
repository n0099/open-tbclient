package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId ibS = BdUniqueId.gen();
    public boolean ibT = true;
    public boolean ibU = true;
    public String ibV;
    public List<n> ibW;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ibS;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean coK() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oB(boolean z) {
        this.ibT = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oC(boolean z) {
        this.ibU = z;
    }
}
