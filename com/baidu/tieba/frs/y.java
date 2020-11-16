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
    public static final BdUniqueId iMa = BdUniqueId.gen();
    private List<MetaData> iLX;
    private int iLW = 0;
    private String iLY = "本吧都在关注";
    private boolean iLZ = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iMa;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.iLW = frsPageUserExtend.user_extend_storey.intValue();
            this.iLX = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.iLX.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.iLY = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.iLW = featureCardGod.floor.intValue();
            this.iLX = featureCardGod.sub_nodes;
            this.iLY = featureCardGod.title;
        }
    }

    public int bmS() {
        return this.iLW;
    }

    public List<MetaData> getUserInfo() {
        return this.iLX;
    }

    public String czF() {
        return this.iLY;
    }

    public boolean czG() {
        return this.iLZ;
    }

    public void pK(boolean z) {
        this.iLZ = z;
    }
}
