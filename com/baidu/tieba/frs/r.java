package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId grH = BdUniqueId.gen();
    private List<MetaData> grE;
    private int grD = 0;
    private String grF = "本吧都在关注";
    private boolean grG = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return grH;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.grD = frsPageUserExtend.user_extend_storey.intValue();
            this.grE = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.grE.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.grF = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.grD = featureCardGod.floor.intValue();
            this.grE = featureCardGod.sub_nodes;
            this.grF = featureCardGod.title;
        }
    }

    public int aDy() {
        return this.grD;
    }

    public List<MetaData> getUserInfo() {
        return this.grE;
    }

    public String bFt() {
        return this.grF;
    }

    public boolean bFu() {
        return this.grG;
    }

    public void lv(boolean z) {
        this.grG = z;
    }
}
