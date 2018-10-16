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
/* loaded from: classes6.dex */
public class f extends h implements p {
    private CardGod eoD;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.eoD = cardGod;
            this.mGroupTitle = this.eoD.card_title;
            if (!v.J(this.eoD.gods)) {
                int i = 0;
                Iterator<User> it = this.eoD.gods.iterator();
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
                                iVar.apx = metaData;
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

    public boolean VG() {
        return v.I(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.eoD == null || this.eoD.position == null) {
            return 0;
        }
        return this.eoD.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aoF() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fk(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void fl(boolean z) {
        this.showBottomDivider = z;
    }
}
