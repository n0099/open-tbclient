package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.p;
import tbclient.ActiveCenter;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.c implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData dHy;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData aQL() {
        return this.dHy;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.dHy = new ActiveCenterData();
            this.dHy.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bSe() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mL(boolean z) {
    }
}
