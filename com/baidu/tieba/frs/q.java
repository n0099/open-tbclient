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
    public static final BdUniqueId fzo = BdUniqueId.gen();
    private List<MetaData> fzl;
    private int fzk = 0;
    private String fzm = "本吧都在关注";
    private boolean fzn = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fzo;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.aa(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fzk = frsPageUserExtend.user_extend_storey.intValue();
            this.fzl = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fzl.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fzm = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.aa(featureCardGod.sub_nodes)) {
            this.fzk = featureCardGod.floor.intValue();
            this.fzl = featureCardGod.sub_nodes;
            this.fzm = featureCardGod.title;
        }
    }

    public int afJ() {
        return this.fzk;
    }

    public List<MetaData> getUserInfo() {
        return this.fzl;
    }

    public String bom() {
        return this.fzm;
    }

    public boolean bon() {
        return this.fzn;
    }

    public void kh(boolean z) {
        this.fzn = z;
    }
}
