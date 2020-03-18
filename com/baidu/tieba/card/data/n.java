package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b implements p {
    public static final BdUniqueId fOr = BdUniqueId.gen();
    public boolean fOs = true;
    public boolean fOt = true;
    public String fOu;
    public List<m> fOv;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOr;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvC() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kx(boolean z) {
        this.fOs = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ky(boolean z) {
        this.fOt = z;
    }
}
