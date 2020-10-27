package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.q;
import tbclient.ActiveCenter;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.c implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData eno;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData bep() {
        return this.eno;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.eno = new ActiveCenterData();
            this.eno.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cmj() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void os(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void ot(boolean z) {
    }
}
