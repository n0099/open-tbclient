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
    private CardGod cyT;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cyT = cardGod;
            this.mGroupTitle = this.cyT.card_title;
            if (!x.q(this.cyT.gods)) {
                int i = 0;
                for (User user : this.cyT.gods) {
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

    public boolean pO() {
        return x.p(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        if (this.cyT == null || this.cyT.position == null) {
            return 0;
        }
        return this.cyT.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean Ta() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cR(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cS(boolean z) {
        this.showBottomDivider = z;
    }
}
