package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends b implements q {
    public static final BdUniqueId dba = BdUniqueId.gen();
    public long dbb;
    public String dbc;
    public String dbd;
    public String dbe;
    public String dbf;
    public String dbg;
    public long dbh;
    public String dbi;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dba;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return (int) this.dbh;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
    }
}
