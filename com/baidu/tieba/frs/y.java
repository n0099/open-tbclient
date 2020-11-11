package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class y implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iLn = BdUniqueId.gen();
    private List<MetaData> iLk;
    private int iLj = 0;
    private String iLl = "本吧都在关注";
    private boolean iLm = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iLn;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.iLj = frsPageUserExtend.user_extend_storey.intValue();
            this.iLk = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.iLk.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.iLl = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.iLj = featureCardGod.floor.intValue();
            this.iLk = featureCardGod.sub_nodes;
            this.iLl = featureCardGod.title;
        }
    }

    public int bnO() {
        return this.iLj;
    }

    public List<MetaData> getUserInfo() {
        return this.iLk;
    }

    public String cAc() {
        return this.iLl;
    }

    public boolean cAd() {
        return this.iLm;
    }

    public void pH(boolean z) {
        this.iLm = z;
    }
}
