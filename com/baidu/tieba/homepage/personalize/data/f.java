package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends h implements r {
    private CardGod dsB;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dsB = cardGod;
            this.mGroupTitle = this.dsB.card_title;
            if (!v.w(this.dsB.gods)) {
                int i = 0;
                for (User user : this.dsB.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.YZ = metaData;
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

    public boolean Ni() {
        return v.v(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dsB == null || this.dsB.position == null) {
            return 0;
        }
        return this.dsB.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean acj() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
        this.showBottomDivider = z;
    }
}
