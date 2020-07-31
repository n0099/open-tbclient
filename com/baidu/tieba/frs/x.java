package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class x implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hJt = BdUniqueId.gen();
    private List<MetaData> hJq;
    private int hJp = 0;
    private String hJr = "本吧都在关注";
    private boolean hJs = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hJt;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.x.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hJp = frsPageUserExtend.user_extend_storey.intValue();
            this.hJq = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hJq.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hJr = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.x.isEmpty(featureCardGod.sub_nodes)) {
            this.hJp = featureCardGod.floor.intValue();
            this.hJq = featureCardGod.sub_nodes;
            this.hJr = featureCardGod.title;
        }
    }

    public int aXz() {
        return this.hJp;
    }

    public List<MetaData> getUserInfo() {
        return this.hJq;
    }

    public String cdl() {
        return this.hJr;
    }

    public boolean cdm() {
        return this.hJs;
    }

    public void nP(boolean z) {
        this.hJs = z;
    }
}
