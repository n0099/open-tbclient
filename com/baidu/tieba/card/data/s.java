package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s extends b implements t {
    public static final BdUniqueId byi = BdUniqueId.gen();
    public long byj;
    public String byk;
    public String byl;
    public String bym;
    public String byn;
    public String byo;
    public long byp;
    public String byq;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return byi;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        return (int) this.byp;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Uc() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.t
    public void db(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.t
    public void dc(boolean z) {
    }
}
