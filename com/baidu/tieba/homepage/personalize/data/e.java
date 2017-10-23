package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.h implements r {
    private CardGod dag;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dag = cardGod;
            this.mGroupTitle = this.dag.card_title;
            if (!v.u(this.dag.gods)) {
                int i = 0;
                for (User user : this.dag.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.author = metaData;
                            a(iVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean Mi() {
        return v.t(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dag == null || this.dag.position == null) {
            return 0;
        }
        return this.dag.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XV() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
        this.showBottomDivider = z;
    }
}
