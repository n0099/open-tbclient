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
    public static final BdUniqueId daR = BdUniqueId.gen();
    private List<MetaData> daO;
    private int daN = 0;
    private String daP = "本吧都在关注";
    private boolean daQ = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return daR;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.daN = frsPageUserExtend.user_extend_storey.intValue();
            this.daO = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.daO.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.daP = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.w(featureCardGod.sub_nodes)) {
            this.daN = featureCardGod.floor.intValue();
            this.daO = featureCardGod.sub_nodes;
            this.daP = featureCardGod.title;
        }
    }

    public int sM() {
        return this.daN;
    }

    public List<MetaData> getUserInfo() {
        return this.daO;
    }

    public String aqC() {
        return this.daP;
    }

    public boolean aqD() {
        return this.daQ;
    }

    public void fB(boolean z) {
        this.daQ = z;
    }
}
