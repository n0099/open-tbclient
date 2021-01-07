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
    public static final BdUniqueId jjg = BdUniqueId.gen();
    private List<MetaData> jjd;
    private int jjc = 0;
    private String jje = "本吧都在关注";
    private boolean jjf = false;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jjg;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.x.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.jjc = frsPageUserExtend.user_extend_storey.intValue();
            this.jjd = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.jjd.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.jje = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.x.isEmpty(featureCardGod.sub_nodes)) {
            this.jjc = featureCardGod.floor.intValue();
            this.jjd = featureCardGod.sub_nodes;
            this.jje = featureCardGod.title;
        }
    }

    public int bsI() {
        return this.jjc;
    }

    public List<MetaData> getUserInfo() {
        return this.jjd;
    }

    public String cGS() {
        return this.jje;
    }

    public boolean cGT() {
        return this.jjf;
    }

    public void qF(boolean z) {
        this.jjf = z;
    }
}
