package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class n extends b implements p {
    public static final BdUniqueId eGw = BdUniqueId.gen();
    public List<m> eGA;
    public boolean eGx = true;
    public boolean eGy = true;
    public String eGz;
    public int locate;
    public int position;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eGw;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bag() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
        this.eGx = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
        this.eGy = z;
    }
}
