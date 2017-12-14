package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b implements r {
    public static final BdUniqueId cei = BdUniqueId.gen();
    public int bjM;
    public boolean cej = true;
    public boolean cek = true;
    public String cel;
    public List<o> cem;
    public int position;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cei;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ack() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
        this.cej = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
        this.cek = z;
    }
}
