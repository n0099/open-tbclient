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
    private CardGod eeH;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.eeH = cardGod;
            this.mGroupTitle = this.eeH.card_title;
            if (!v.G(this.eeH.gods)) {
                int i = 0;
                for (User user : this.eeH.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.aNy = metaData;
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

    public boolean UH() {
        return v.F(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.eeH == null || this.eeH.position == null) {
            return 0;
        }
        return this.eeH.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
        this.showBottomDivider = z;
    }
}
