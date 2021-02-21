package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class w implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jkt = BdUniqueId.gen();
    private List<MetaData> jkq;
    private int jkp = 0;
    private String jkr = "本吧都在关注";
    private boolean jks = false;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jkt;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.jkp = frsPageUserExtend.user_extend_storey.intValue();
            this.jkq = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.jkq.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.jkr = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.jkp = featureCardGod.floor.intValue();
            this.jkq = featureCardGod.sub_nodes;
            this.jkr = featureCardGod.title;
        }
    }

    public int bpg() {
        return this.jkp;
    }

    public List<MetaData> getUserInfo() {
        return this.jkq;
    }

    public String cEt() {
        return this.jkr;
    }

    public boolean cEu() {
        return this.jks;
    }

    public void qL(boolean z) {
        this.jks = z;
    }
}
