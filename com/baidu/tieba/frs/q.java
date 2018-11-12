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
    public static final BdUniqueId dEs = BdUniqueId.gen();
    private List<MetaData> dEp;
    private int dEo = 0;
    private String dEq = "本吧都在关注";
    private boolean dEr = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dEs;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.I(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dEo = frsPageUserExtend.user_extend_storey.intValue();
            this.dEp = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dEp.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dEq = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.I(featureCardGod.sub_nodes)) {
            this.dEo = featureCardGod.floor.intValue();
            this.dEp = featureCardGod.sub_nodes;
            this.dEq = featureCardGod.title;
        }
    }

    public int zC() {
        return this.dEo;
    }

    public List<MetaData> getUserInfo() {
        return this.dEp;
    }

    public String aAs() {
        return this.dEq;
    }

    public boolean aAt() {
        return this.dEr;
    }

    public void gF(boolean z) {
        this.dEr = z;
    }
}
