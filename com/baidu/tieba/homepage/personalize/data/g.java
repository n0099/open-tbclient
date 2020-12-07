package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tieba.card.data.p;
import tbclient.ActiveCenter;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b implements p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ActiveCenterData eyG;
    public int position;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            this.eyG = new ActiveCenterData();
            this.eyG.parseProto(activeCenter);
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return this.position;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pa(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void pb(boolean z) {
    }
}
