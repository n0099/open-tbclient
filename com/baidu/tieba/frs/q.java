package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fbR = BdUniqueId.gen();
    private List<MetaData> fbO;
    private int fbN = 0;
    private String fbP = "本吧都在关注";
    private boolean fbQ = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbR;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.T(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fbN = frsPageUserExtend.user_extend_storey.intValue();
            this.fbO = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fbO.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fbP = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.T(featureCardGod.sub_nodes)) {
            this.fbN = featureCardGod.floor.intValue();
            this.fbO = featureCardGod.sub_nodes;
            this.fbP = featureCardGod.title;
        }
    }

    public int ZV() {
        return this.fbN;
    }

    public List<MetaData> getUserInfo() {
        return this.fbO;
    }

    public String bdV() {
        return this.fbP;
    }

    public boolean bdW() {
        return this.fbQ;
    }

    public void jk(boolean z) {
        this.fbQ = z;
    }
}
