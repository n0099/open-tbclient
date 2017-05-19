package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends b implements r {
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

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return (int) this.byp;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Tv() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dd(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void de(boolean z) {
    }
}
