package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gru = BdUniqueId.gen();
    private List<MetaData> grr;
    private int grq = 0;
    private String grs = "本吧都在关注";
    private boolean grt = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gru;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.grq = frsPageUserExtend.user_extend_storey.intValue();
            this.grr = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.grr.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.grs = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.grq = featureCardGod.floor.intValue();
            this.grr = featureCardGod.sub_nodes;
            this.grs = featureCardGod.title;
        }
    }

    public int aDy() {
        return this.grq;
    }

    public List<MetaData> getUserInfo() {
        return this.grr;
    }

    public String bFs() {
        return this.grs;
    }

    public boolean bFt() {
        return this.grt;
    }

    public void lv(boolean z) {
        this.grt = z;
    }
}
