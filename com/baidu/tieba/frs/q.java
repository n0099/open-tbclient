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
    public static final BdUniqueId fxc = BdUniqueId.gen();
    private List<MetaData> fwZ;
    private int fwY = 0;
    private String fxa = "本吧都在关注";
    private boolean fxb = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxc;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.aa(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fwY = frsPageUserExtend.user_extend_storey.intValue();
            this.fwZ = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fwZ.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fxa = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.aa(featureCardGod.sub_nodes)) {
            this.fwY = featureCardGod.floor.intValue();
            this.fwZ = featureCardGod.sub_nodes;
            this.fxa = featureCardGod.title;
        }
    }

    public int afE() {
        return this.fwY;
    }

    public List<MetaData> getUserInfo() {
        return this.fwZ;
    }

    public String bnr() {
        return this.fxa;
    }

    public boolean bns() {
        return this.fxb;
    }

    public void ke(boolean z) {
        this.fxb = z;
    }
}
