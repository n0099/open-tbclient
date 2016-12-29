package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.s;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends j implements s {
    private CardGod crR;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.crR = cardGod;
            this.mGroupTitle = this.crR.card_title;
            if (!x.t(this.crR.gods)) {
                int i = 0;
                for (User user : this.crR.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            k kVar = new k();
                            kVar.author = metaData;
                            a(kVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean pj() {
        return x.s(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        if (this.crR == null || this.crR.position == null) {
            return 0;
        }
        return this.crR.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean OO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cA(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cB(boolean z) {
        this.showBottomDivider = z;
    }
}
