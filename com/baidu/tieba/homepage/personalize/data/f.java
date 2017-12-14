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
public class f extends h implements r {
    private CardGod dsx;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dsx = cardGod;
            this.mGroupTitle = this.dsx.card_title;
            if (!v.w(this.dsx.gods)) {
                int i = 0;
                for (User user : this.dsx.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            i iVar = new i();
                            iVar.YW = metaData;
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

    public boolean Ni() {
        return v.v(getDataList()) > 2;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.dsx == null || this.dsx.position == null) {
            return 0;
        }
        return this.dsx.position.intValue();
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ack() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dX(boolean z) {
        this.showBottomDivider = z;
    }
}
