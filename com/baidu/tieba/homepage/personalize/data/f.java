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
    private CardGod gmK;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.gmK = cardGod;
            this.mGroupTitle = this.gmK.card_title;
            if (!v.isEmpty(this.gmK.gods)) {
                int i = 0;
                Iterator<User> it = this.gmK.gods.iterator();
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
                                iVar.ccm = metaData;
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

    public boolean aEG() {
        return v.getCount(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.gmK == null || this.gmK.position == null) {
            return 0;
        }
        return this.gmK.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baM() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
        this.showBottomDivider = z;
    }
}
