package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.q;
import tbclient.ActiveCenter;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.c implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData dQF;
    public int position;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public ActiveCenterData aZb() {
        return this.dQF;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.dQF = new ActiveCenterData();
            this.dQF.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccq() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nn(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.q
    public void no(boolean z) {
    }
}
