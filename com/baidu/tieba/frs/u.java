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
    public static final BdUniqueId hqI = BdUniqueId.gen();
    private List<MetaData> hqF;
    private int hqE = 0;
    private String hqG = "本吧都在关注";
    private boolean hqH = false;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hqI;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hqE = frsPageUserExtend.user_extend_storey.intValue();
            this.hqF = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hqF.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hqG = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.hqE = featureCardGod.floor.intValue();
            this.hqF = featureCardGod.sub_nodes;
            this.hqG = featureCardGod.title;
        }
    }

    public int aRM() {
        return this.hqE;
    }

    public List<MetaData> getUserInfo() {
        return this.hqF;
    }

    public String bWD() {
        return this.hqG;
    }

    public boolean bWE() {
        return this.hqH;
    }

    public void mZ(boolean z) {
        this.hqH = z;
    }
}
