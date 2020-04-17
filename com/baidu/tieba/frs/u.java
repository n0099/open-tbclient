package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class u implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hbD = BdUniqueId.gen();
    private List<MetaData> hbA;
    private int hbz = 0;
    private String hbB = "本吧都在关注";
    private boolean hbC = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hbD;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hbz = frsPageUserExtend.user_extend_storey.intValue();
            this.hbA = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hbA.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hbB = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.hbz = featureCardGod.floor.intValue();
            this.hbA = featureCardGod.sub_nodes;
            this.hbB = featureCardGod.title;
        }
    }

    public int aLP() {
        return this.hbz;
    }

    public List<MetaData> getUserInfo() {
        return this.hbA;
    }

    public String bQg() {
        return this.hbB;
    }

    public boolean bQh() {
        return this.hbC;
    }

    public void mE(boolean z) {
        this.hbC = z;
    }
}
