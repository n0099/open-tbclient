package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.s;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends k implements s {
    private CardGod cHz;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cHz = cardGod;
            this.bbF = this.cHz.card_title;
            if (!y.t(this.cHz.gods)) {
                int i = 0;
                for (User user : this.cHz.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            l lVar = new l();
                            lVar.author = metaData;
                            a(lVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean ph() {
        return y.s(Ft()) > 2;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        if (this.cHz == null || this.cHz.position == null) {
            return 0;
        }
        return this.cHz.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Op() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bbJ = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cu(boolean z) {
        this.bbK = z;
    }
}
