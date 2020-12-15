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
    public static final BdUniqueId iWT = BdUniqueId.gen();
    private List<MetaData> iWQ;
    private int iWP = 0;
    private String iWR = "本吧都在关注";
    private boolean iWS = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWT;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.iWP = frsPageUserExtend.user_extend_storey.intValue();
            this.iWQ = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.iWQ.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.iWR = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.iWP = featureCardGod.floor.intValue();
            this.iWQ = featureCardGod.sub_nodes;
            this.iWR = featureCardGod.title;
        }
    }

    public int bqf() {
        return this.iWP;
    }

    public List<MetaData> getUserInfo() {
        return this.iWQ;
    }

    public String cDW() {
        return this.iWR;
    }

    public boolean cDX() {
        return this.iWS;
    }

    public void qh(boolean z) {
        this.iWS = z;
    }
}
