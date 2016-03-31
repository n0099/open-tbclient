package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class x extends b implements z {
    public static final BdUniqueId aWt = BdUniqueId.gen();
    public boolean aVy = true;
    public String aWu;
    public List<w> aWv;
    public int aWw;
    public int position;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aWt;
    }

    @Override // com.baidu.tieba.card.a.z
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.z
    public boolean LE() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.z
    public void cd(boolean z) {
        this.aVy = z;
    }
}
