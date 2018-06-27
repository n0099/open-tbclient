package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.p;
import java.util.Iterator;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes2.dex */
public class f extends h implements p {
    private CardGod dVy;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dVy = cardGod;
            this.mGroupTitle = this.dVy.card_title;
            if (!w.A(this.dVy.gods)) {
                int i = 0;
                Iterator<User> it = this.dVy.gods.iterator();
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
                                iVar.aiE = metaData;
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

    public boolean isValidate() {
        return w.z(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.dVy == null || this.dVy.position == null) {
            return 0;
        }
        return this.dVy.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aiQ() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.showBottomDivider = z;
    }
}
