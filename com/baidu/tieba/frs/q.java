package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dKR = BdUniqueId.gen();
    private List<MetaData> dKO;
    private int dKN = 0;
    private String dKP = "本吧都在关注";
    private boolean dKQ = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKR;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.I(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dKN = frsPageUserExtend.user_extend_storey.intValue();
            this.dKO = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dKO.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dKP = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.I(featureCardGod.sub_nodes)) {
            this.dKN = featureCardGod.floor.intValue();
            this.dKO = featureCardGod.sub_nodes;
            this.dKP = featureCardGod.title;
        }
    }

    public int AG() {
        return this.dKN;
    }

    public List<MetaData> getUserInfo() {
        return this.dKO;
    }

    public String aCc() {
        return this.dKP;
    }

    public boolean aCd() {
        return this.dKQ;
    }

    public void gG(boolean z) {
        this.dKQ = z;
    }
}
