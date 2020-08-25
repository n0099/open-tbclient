package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes2.dex */
public class o extends b implements q {
    public static final BdUniqueId hnv = BdUniqueId.gen();
    public boolean hnw = true;
    public boolean hnx = true;
    public String hny;
    public List<n> hnz;
    public int locate;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hnv;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccq() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nn(boolean z) {
        this.hnw = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void no(boolean z) {
        this.hnx = z;
    }
}
