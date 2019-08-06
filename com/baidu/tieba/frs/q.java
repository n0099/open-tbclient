package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fxB = BdUniqueId.gen();
    private List<MetaData> fxy;
    private int fxx = 0;
    private String fxz = "本吧都在关注";
    private boolean fxA = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxB;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.aa(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fxx = frsPageUserExtend.user_extend_storey.intValue();
            this.fxy = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fxy.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fxz = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.aa(featureCardGod.sub_nodes)) {
            this.fxx = featureCardGod.floor.intValue();
            this.fxy = featureCardGod.sub_nodes;
            this.fxz = featureCardGod.title;
        }
    }

    public int afF() {
        return this.fxx;
    }

    public List<MetaData> getUserInfo() {
        return this.fxy;
    }

    public String bnB() {
        return this.fxz;
    }

    public boolean bnC() {
        return this.fxA;
    }

    public void ke(boolean z) {
        this.fxA = z;
    }
}
