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
    private CardGod efW;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.efW = cardGod;
            this.mGroupTitle = this.efW.card_title;
            if (!v.E(this.efW.gods)) {
                int i = 0;
                for (User user : this.efW.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.aNu = metaData;
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

    public boolean Uv() {
        return v.D(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.efW == null || this.efW.position == null) {
            return 0;
        }
        return this.efW.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akS() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eH(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eI(boolean z) {
        this.showBottomDivider = z;
    }
}
