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
    private CardGod glu;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.glu = cardGod;
            this.mGroupTitle = this.glu.card_title;
            if (!v.aa(this.glu.gods)) {
                int i = 0;
                Iterator<User> it = this.glu.gods.iterator();
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
                                iVar.bKg = metaData;
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

    public boolean aDS() {
        return v.Z(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.glu == null || this.glu.position == null) {
            return 0;
        }
        return this.glu.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bag() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
        this.showBottomDivider = z;
    }
}
