package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.p;
import tbclient.ActiveCenter;
/* loaded from: classes21.dex */
public class g extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData erD;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.erD = new ActiveCenterData();
            this.erD.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean cop() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void oE(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void oF(boolean z) {
    }
}
