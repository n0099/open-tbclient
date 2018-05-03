package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes2.dex */
public class f extends h implements p {
    private CardGod dFj;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dFj = cardGod;
            this.mGroupTitle = this.dFj.card_title;
            if (!v.w(this.dFj.gods)) {
                int i = 0;
                for (User user : this.dFj.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.aae = metaData;
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

    public boolean isValidate() {
        return v.v(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.dFj == null || this.dFj.position == null) {
            return 0;
        }
        return this.dFj.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean afO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ev(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ew(boolean z) {
        this.showBottomDivider = z;
    }
}
