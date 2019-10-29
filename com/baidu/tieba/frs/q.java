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
    public static final BdUniqueId fyC = BdUniqueId.gen();
    private List<MetaData> fyz;
    private int fyy = 0;
    private String fyA = "本吧都在关注";
    private boolean fyB = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fyC;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fyy = frsPageUserExtend.user_extend_storey.intValue();
            this.fyz = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fyz.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fyA = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.fyy = featureCardGod.floor.intValue();
            this.fyz = featureCardGod.sub_nodes;
            this.fyA = featureCardGod.title;
        }
    }

    public int ajM() {
        return this.fyy;
    }

    public List<MetaData> getUserInfo() {
        return this.fyz;
    }

    public String blq() {
        return this.fyA;
    }

    public boolean blr() {
        return this.fyB;
    }

    public void jV(boolean z) {
        this.fyB = z;
    }
}
