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
    public static final BdUniqueId fxL = BdUniqueId.gen();
    private List<MetaData> fxI;
    private int fxH = 0;
    private String fxJ = "本吧都在关注";
    private boolean fxK = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxL;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fxH = frsPageUserExtend.user_extend_storey.intValue();
            this.fxI = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fxI.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fxJ = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.fxH = featureCardGod.floor.intValue();
            this.fxI = featureCardGod.sub_nodes;
            this.fxJ = featureCardGod.title;
        }
    }

    public int ajK() {
        return this.fxH;
    }

    public List<MetaData> getUserInfo() {
        return this.fxI;
    }

    public String blo() {
        return this.fxJ;
    }

    public boolean blp() {
        return this.fxK;
    }

    public void jV(boolean z) {
        this.fxK = z;
    }
}
