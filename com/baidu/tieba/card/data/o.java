package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b implements q {
    public static final BdUniqueId dao = BdUniqueId.gen();
    public int bZn;
    public boolean dap = true;
    public boolean daq = true;
    public String dar;
    public List<n> das;
    public int position;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dao;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alF() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
        this.dap = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
        this.daq = z;
    }
}
