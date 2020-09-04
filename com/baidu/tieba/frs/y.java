package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class y implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWT = BdUniqueId.gen();
    private List<MetaData> hWQ;
    private int hWP = 0;
    private String hWR = "本吧都在关注";
    private boolean hWS = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWT;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hWP = frsPageUserExtend.user_extend_storey.intValue();
            this.hWQ = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hWQ.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hWR = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.hWP = featureCardGod.floor.intValue();
            this.hWQ = featureCardGod.sub_nodes;
            this.hWR = featureCardGod.title;
        }
    }

    public int bfS() {
        return this.hWP;
    }

    public List<MetaData> getUserInfo() {
        return this.hWQ;
    }

    public String cnJ() {
        return this.hWR;
    }

    public boolean cnK() {
        return this.hWS;
    }

    public void ov(boolean z) {
        this.hWS = z;
    }
}
