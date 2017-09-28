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
    private CardGod dau;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dau = cardGod;
            this.mGroupTitle = this.dau.card_title;
            if (!v.u(this.dau.gods)) {
                int i = 0;
                for (User user : this.dau.gods) {
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

    public boolean Mo() {
        return v.t(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dau == null || this.dau.position == null) {
            return 0;
        }
        return this.dau.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XZ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dE(boolean z) {
        this.showBottomDivider = z;
    }
}
