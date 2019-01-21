package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends b implements p {
    public static final BdUniqueId dbV = BdUniqueId.gen();
    public boolean dbW = true;
    public boolean dbX = true;
    public String dbY;
    public List<m> dbZ;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dbV;
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
        this.dbW = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fC(boolean z) {
        this.dbX = z;
    }
}
