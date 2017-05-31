package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.h implements r {
    private CardGod cCK;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cCK = cardGod;
            this.mGroupTitle = this.cCK.card_title;
            if (!x.r(this.cCK.gods)) {
                int i = 0;
                for (User user : this.cCK.gods) {
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

    public boolean ajf() {
        return x.q(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.cCK == null || this.cCK.position == null) {
            return 0;
        }
        return this.cCK.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean UG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void du(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dv(boolean z) {
        this.showBottomDivider = z;
    }
}
