package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId aVI = BdUniqueId.gen();
    public boolean aUZ = true;
    public String aVJ;
    public List<p> aVK;
    public int aVL;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aVI;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Lm() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.s
    public void ck(boolean z) {
        this.aUZ = z;
    }
}
