package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.p;
import tbclient.ActiveCenter;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.c implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData dBC;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData aMX() {
        return this.dBC;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.dBC = new ActiveCenterData();
            this.dBC.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bOT() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mg(boolean z) {
    }
}
