package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.p;
import java.util.Iterator;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.data.h implements p {
    private CardGod gnm;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.gnm = cardGod;
            this.mGroupTitle = this.gnm.card_title;
            if (!v.aa(this.gnm.gods)) {
                int i = 0;
                Iterator<User> it = this.gnm.gods.iterator();
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        User next = it.next();
                        if (i2 != 10) {
                            MetaData metaData = new MetaData();
                            metaData.parserProtobuf(next);
                            if (StringUtils.isNull(metaData.getUserName())) {
                                i = i2;
                            } else {
                                i iVar = new i();
                                iVar.bKE = metaData;
                                a(iVar);
                                i = i2 + 1;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean aEw() {
        return v.Z(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.gnm == null || this.gnm.position == null) {
            return 0;
        }
        return this.gnm.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baK() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iK(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iL(boolean z) {
        this.showBottomDivider = z;
    }
}
