package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.h implements r {
    private CardGod cwr;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cwr = cardGod;
            this.mGroupTitle = this.cwr.card_title;
            if (!x.r(this.cwr.gods)) {
                int i = 0;
                for (User user : this.cwr.gods) {
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

    public boolean pv() {
        return x.q(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.cwr == null || this.cwr.position == null) {
            return 0;
        }
        return this.cwr.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Tv() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dd(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void de(boolean z) {
        this.showBottomDivider = z;
    }
}
