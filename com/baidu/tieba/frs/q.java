package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dNF = BdUniqueId.gen();
    private List<MetaData> dNC;
    private int dNB = 0;
    private String dND = "本吧都在关注";
    private boolean dNE = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dNF;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.I(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dNB = frsPageUserExtend.user_extend_storey.intValue();
            this.dNC = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dNC.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dND = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.I(featureCardGod.sub_nodes)) {
            this.dNB = featureCardGod.floor.intValue();
            this.dNC = featureCardGod.sub_nodes;
            this.dND = featureCardGod.title;
        }
    }

    public int AG() {
        return this.dNB;
    }

    public List<MetaData> getUserInfo() {
        return this.dNC;
    }

    public String aCR() {
        return this.dND;
    }

    public boolean aCS() {
        return this.dNE;
    }

    public void gJ(boolean z) {
        this.dNE = z;
    }
}
