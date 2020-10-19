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
    public static final BdUniqueId isU = BdUniqueId.gen();
    private List<MetaData> isR;
    private int isQ = 0;
    private String isS = "本吧都在关注";
    private boolean isT = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return isU;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.isQ = frsPageUserExtend.user_extend_storey.intValue();
            this.isR = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.isR.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.isS = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.isQ = featureCardGod.floor.intValue();
            this.isR = featureCardGod.sub_nodes;
            this.isS = featureCardGod.title;
        }
    }

    public int bjv() {
        return this.isQ;
    }

    public List<MetaData> getUserInfo() {
        return this.isR;
    }

    public String cuu() {
        return this.isS;
    }

    public boolean cuv() {
        return this.isT;
    }

    public void pg(boolean z) {
        this.isT = z;
    }
}
