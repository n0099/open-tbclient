package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId dbU = BdUniqueId.gen();
    public boolean dbV = true;
    public boolean dbW = true;
    public String dbX;
    public List<m> dbY;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dbU;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean arg() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fB(boolean z) {
        this.dbV = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fC(boolean z) {
        this.dbW = z;
    }
}
