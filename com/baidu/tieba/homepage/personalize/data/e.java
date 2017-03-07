package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.t;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends j implements t {
    private CardGod cAt;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cAt = cardGod;
            this.mGroupTitle = this.cAt.card_title;
            if (!x.q(this.cAt.gods)) {
                int i = 0;
                for (User user : this.cAt.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            k kVar = new k();
                            kVar.author = metaData;
                            a(kVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean pq() {
        return x.p(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        if (this.cAt == null || this.cAt.position == null) {
            return 0;
        }
        return this.cAt.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean SC() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
        this.showBottomDivider = z;
    }
}
