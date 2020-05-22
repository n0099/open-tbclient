package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class u implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hqx = BdUniqueId.gen();
    private List<MetaData> hqu;
    private int hqt = 0;
    private String hqv = "本吧都在关注";
    private boolean hqw = false;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hqx;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hqt = frsPageUserExtend.user_extend_storey.intValue();
            this.hqu = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hqu.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hqv = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.hqt = featureCardGod.floor.intValue();
            this.hqu = featureCardGod.sub_nodes;
            this.hqv = featureCardGod.title;
        }
    }

    public int aRM() {
        return this.hqt;
    }

    public List<MetaData> getUserInfo() {
        return this.hqu;
    }

    public String bWB() {
        return this.hqv;
    }

    public boolean bWC() {
        return this.hqw;
    }

    public void mZ(boolean z) {
        this.hqw = z;
    }
}
