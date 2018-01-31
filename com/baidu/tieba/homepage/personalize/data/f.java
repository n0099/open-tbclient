package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes2.dex */
public class f extends h implements r {
    private CardGod egr;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.egr = cardGod;
            this.mGroupTitle = this.egr.card_title;
            if (!v.E(this.egr.gods)) {
                int i = 0;
                for (User user : this.egr.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.aNx = metaData;
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

    public boolean Ux() {
        return v.D(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.egr == null || this.egr.position == null) {
            return 0;
        }
        return this.egr.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eJ(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
        this.showBottomDivider = z;
    }
}
