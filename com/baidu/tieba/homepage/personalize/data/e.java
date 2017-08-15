package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.h implements r {
    private CardGod cWG;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cWG = cardGod;
            this.mGroupTitle = this.cWG.card_title;
            if (!u.v(this.cWG.gods)) {
                int i = 0;
                for (User user : this.cWG.gods) {
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

    public boolean LO() {
        return u.u(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.cWG == null || this.cWG.position == null) {
            return 0;
        }
        return this.cWG.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Xg() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dH(boolean z) {
        this.showBottomDivider = z;
    }
}
