package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class u implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hbJ = BdUniqueId.gen();
    private List<MetaData> hbG;
    private int hbF = 0;
    private String hbH = "本吧都在关注";
    private boolean hbI = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hbJ;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hbF = frsPageUserExtend.user_extend_storey.intValue();
            this.hbG = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hbG.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hbH = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.hbF = featureCardGod.floor.intValue();
            this.hbG = featureCardGod.sub_nodes;
            this.hbH = featureCardGod.title;
        }
    }

    public int aLN() {
        return this.hbF;
    }

    public List<MetaData> getUserInfo() {
        return this.hbG;
    }

    public String bQe() {
        return this.hbH;
    }

    public boolean bQf() {
        return this.hbI;
    }

    public void mE(boolean z) {
        this.hbI = z;
    }
}
