package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId bci = BdUniqueId.gen();
    public boolean bbz = true;
    public String bcj;
    public List<p> bck;
    public int bcl;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bci;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean NO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bbz = z;
    }
}
