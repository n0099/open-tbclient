package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.p;
import tbclient.ActiveCenter;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData eHU;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.eHU = new ActiveCenterData();
            this.eHU.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cvx() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pz(boolean z) {
    }
}
