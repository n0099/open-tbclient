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
    public static final BdUniqueId fce = BdUniqueId.gen();
    private List<MetaData> fcb;
    private int fca = 0;
    private String fcc = "本吧都在关注";
    private boolean fcd = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fce;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.T(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fca = frsPageUserExtend.user_extend_storey.intValue();
            this.fcb = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fcb.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fcc = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.T(featureCardGod.sub_nodes)) {
            this.fca = featureCardGod.floor.intValue();
            this.fcb = featureCardGod.sub_nodes;
            this.fcc = featureCardGod.title;
        }
    }

    public int ZY() {
        return this.fca;
    }

    public List<MetaData> getUserInfo() {
        return this.fcb;
    }

    public String bdX() {
        return this.fcc;
    }

    public boolean bdY() {
        return this.fcd;
    }

    public void jk(boolean z) {
        this.fcd = z;
    }
}
