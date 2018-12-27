package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId dbi = BdUniqueId.gen();
    public int bMU;
    public boolean dbj = true;
    public boolean dbk = true;
    public String dbl;
    public List<m> dbm;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dbi;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aqJ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fy(boolean z) {
        this.dbj = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fz(boolean z) {
        this.dbk = z;
    }
}
