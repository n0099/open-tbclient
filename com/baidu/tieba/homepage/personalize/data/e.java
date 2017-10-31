package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends h implements r {
    private CardGod dic;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dic = cardGod;
            this.mGroupTitle = this.dic.card_title;
            if (!v.v(this.dic.gods)) {
                int i = 0;
                for (User user : this.dic.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.YJ = metaData;
                            a(iVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean Ms() {
        return v.u(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dic == null || this.dic.position == null) {
            return 0;
        }
        return this.dic.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aaf() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dB(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
        this.showBottomDivider = z;
    }
}
