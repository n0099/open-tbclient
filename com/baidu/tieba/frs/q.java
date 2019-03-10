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
    public static final BdUniqueId fcf = BdUniqueId.gen();
    private List<MetaData> fcc;
    private int fcb = 0;
    private String fcd = "本吧都在关注";
    private boolean fce = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fcf;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.T(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fcb = frsPageUserExtend.user_extend_storey.intValue();
            this.fcc = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fcc.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fcd = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.T(featureCardGod.sub_nodes)) {
            this.fcb = featureCardGod.floor.intValue();
            this.fcc = featureCardGod.sub_nodes;
            this.fcd = featureCardGod.title;
        }
    }

    public int ZY() {
        return this.fcb;
    }

    public List<MetaData> getUserInfo() {
        return this.fcc;
    }

    public String bdY() {
        return this.fcd;
    }

    public boolean bdZ() {
        return this.fce;
    }

    public void jk(boolean z) {
        this.fce = z;
    }
}
