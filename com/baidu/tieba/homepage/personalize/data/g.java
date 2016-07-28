package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.s;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends k implements s {
    private CardGod cvf;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.cvf = cardGod;
            this.aVL = this.cvf.card_title;
            if (!y.t(this.cvf.gods)) {
                int i = 0;
                for (User user : this.cvf.gods) {
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

    public boolean ok() {
        return y.s(Ea()) > 2;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        if (this.cvf == null || this.cvf.position == null) {
            return 0;
        }
        return this.cvf.position.intValue();
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Ll() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.s
    public void cn(boolean z) {
        this.aVP = z;
    }
}
