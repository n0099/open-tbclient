package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class q extends b implements s {
    public static final BdUniqueId aWG = BdUniqueId.gen();
    public boolean aVX = true;
    public String aWH;
    public List<p> aWI;
    public int aWJ;
    public int position;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aWG;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Ll() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.s
    public void cn(boolean z) {
        this.aVX = z;
    }
}
