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
    public static final BdUniqueId iWR = BdUniqueId.gen();
    private List<MetaData> iWO;
    private int iWN = 0;
    private String iWP = "本吧都在关注";
    private boolean iWQ = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWR;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.iWN = frsPageUserExtend.user_extend_storey.intValue();
            this.iWO = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.iWO.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.iWP = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.iWN = featureCardGod.floor.intValue();
            this.iWO = featureCardGod.sub_nodes;
            this.iWP = featureCardGod.title;
        }
    }

    public int bqf() {
        return this.iWN;
    }

    public List<MetaData> getUserInfo() {
        return this.iWO;
    }

    public String cDV() {
        return this.iWP;
    }

    public boolean cDW() {
        return this.iWQ;
    }

    public void qh(boolean z) {
        this.iWQ = z;
    }
}
