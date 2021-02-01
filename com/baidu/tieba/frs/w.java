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
    public static final BdUniqueId jkf = BdUniqueId.gen();
    private List<MetaData> jkc;
    private int jkb = 0;
    private String jkd = "本吧都在关注";
    private boolean jke = false;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jkf;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.jkb = frsPageUserExtend.user_extend_storey.intValue();
            this.jkc = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.jkc.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.jkd = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.jkb = featureCardGod.floor.intValue();
            this.jkc = featureCardGod.sub_nodes;
            this.jkd = featureCardGod.title;
        }
    }

    public int bpg() {
        return this.jkb;
    }

    public List<MetaData> getUserInfo() {
        return this.jkc;
    }

    public String cEm() {
        return this.jkd;
    }

    public boolean cEn() {
        return this.jke;
    }

    public void qL(boolean z) {
        this.jke = z;
    }
}
