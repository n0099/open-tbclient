package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class r extends b implements s {
    public static final BdUniqueId aWK = BdUniqueId.gen();
    public boolean aVX;
    public long aWL;
    public String aWM;
    public String aWN;
    public String aWO;
    public String aWP;
    public String aWQ;
    public long aWR;
    public String aWS;
    public String userName;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aWK;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        return (int) this.aWR;
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Ll() {
        return false;
    }

    @Override // com.baidu.tieba.card.a.s
    public void cn(boolean z) {
        this.aVX = z;
    }
}
