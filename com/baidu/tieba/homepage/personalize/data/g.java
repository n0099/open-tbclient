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
    private CardGod csv;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.csv = cardGod;
            this.aUO = this.csv.card_title;
            if (!y.t(this.csv.gods)) {
                int i = 0;
                for (User user : this.csv.gods) {
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

    public boolean ov() {
        return y.s(Eb()) > 2;
    }

    @Override // com.baidu.tieba.card.a.s
    public int getPosition() {
        if (this.csv == null || this.csv.position == null) {
            return 0;
        }
        return this.csv.position.intValue();
    }

    @Override // com.baidu.tieba.card.a.s
    public boolean Lm() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.s
    public void ck(boolean z) {
        this.aUS = z;
    }
}
