package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.q;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes2.dex */
public class f extends h implements q {
    private CardGod ekD;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.ekD = cardGod;
            this.mGroupTitle = this.ekD.card_title;
            if (!v.E(this.ekD.gods)) {
                int i = 0;
                for (User user : this.ekD.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.aOQ = metaData;
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

    public boolean Vp() {
        return v.D(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        if (this.ekD == null || this.ekD.position == null) {
            return 0;
        }
        return this.ekD.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean alG() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eQ(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void eR(boolean z) {
        this.showBottomDivider = z;
    }
}
