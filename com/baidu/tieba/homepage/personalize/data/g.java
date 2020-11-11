package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.q;
import tbclient.ActiveCenter;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.c implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData etj;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData bgP() {
        return this.etj;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.etj = new ActiveCenterData();
            this.etj.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean coK() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void oB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void oC(boolean z) {
    }
}
