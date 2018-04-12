package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cZL = BdUniqueId.gen();
    private List<MetaData> cZI;
    private int cZH = 0;
    private String cZJ = "本吧都在关注";
    private boolean cZK = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZL;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cZH = frsPageUserExtend.user_extend_storey.intValue();
            this.cZI = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cZI.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cZJ = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.w(featureCardGod.sub_nodes)) {
            this.cZH = featureCardGod.floor.intValue();
            this.cZI = featureCardGod.sub_nodes;
            this.cZJ = featureCardGod.title;
        }
    }

    public int sN() {
        return this.cZH;
    }

    public List<MetaData> getUserInfo() {
        return this.cZI;
    }

    public String aqD() {
        return this.cZJ;
    }

    public boolean aqE() {
        return this.cZK;
    }

    public void fA(boolean z) {
        this.cZK = z;
    }
}
