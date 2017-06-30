package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.h implements r {
    private CardGod cKI;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cKI = cardGod;
            this.mGroupTitle = this.cKI.card_title;
            if (!z.t(this.cKI.gods)) {
                int i = 0;
                for (User user : this.cKI.gods) {
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

    public boolean LC() {
        return z.s(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.cKI == null || this.cKI.position == null) {
            return 0;
        }
        return this.cKI.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean VX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dw(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dx(boolean z) {
        this.showBottomDivider = z;
    }
}
