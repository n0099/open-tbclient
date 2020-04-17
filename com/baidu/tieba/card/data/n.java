package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId gsY = BdUniqueId.gen();
    public boolean gsZ = true;
    public boolean gta = true;
    public String gtb;
    public List<m> gtc;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gsY;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bFn() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lA(boolean z) {
        this.gsZ = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lB(boolean z) {
        this.gta = z;
    }
}
