package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.s;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends k implements s {
    private CardGod cMM;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cMM = cardGod;
            this.mGroupTitle = this.cMM.card_title;
            if (!x.t(this.cMM.gods)) {
                int i = 0;
                for (User user : this.cMM.gods) {
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

    public boolean pj() {
        return x.s(Fy()) > 2;
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        if (this.cMM == null || this.cMM.position == null) {
            return 0;
        }
        return this.cMM.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean Ps() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cy(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.s
    public void cz(boolean z) {
        this.showBottomDivider = z;
    }
}
