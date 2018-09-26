package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.p;
import java.util.Iterator;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes2.dex */
public class f extends h implements p {
    private CardGod egJ;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.egJ = cardGod;
            this.mGroupTitle = this.egJ.card_title;
            if (!v.z(this.egJ.gods)) {
                int i = 0;
                Iterator<User> it = this.egJ.gods.iterator();
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
                                iVar.akB = metaData;
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

    public boolean TK() {
        return v.y(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.egJ == null || this.egJ.position == null) {
            return 0;
        }
        return this.egJ.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ald() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eS(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eT(boolean z) {
        this.showBottomDivider = z;
    }
}
