package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.q;
import tbclient.ActiveCenter;
/* loaded from: classes21.dex */
public class g extends com.baidu.tieba.card.data.c implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData dSQ;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData aZO() {
        return this.dSQ;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.dSQ = new ActiveCenterData();
            this.dSQ.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean cfG() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nv(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void nw(boolean z) {
    }
}
