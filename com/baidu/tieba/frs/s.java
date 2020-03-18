package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gsr = BdUniqueId.gen();
    private List<MetaData> gso;
    private int gsn = 0;
    private String gsp = "本吧都在关注";
    private boolean gsq = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gsr;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.gsn = frsPageUserExtend.user_extend_storey.intValue();
            this.gso = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.gso.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.gsp = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.gsn = featureCardGod.floor.intValue();
            this.gso = featureCardGod.sub_nodes;
            this.gsp = featureCardGod.title;
        }
    }

    public int aDC() {
        return this.gsn;
    }

    public List<MetaData> getUserInfo() {
        return this.gso;
    }

    public String bFD() {
        return this.gsp;
    }

    public boolean bFE() {
        return this.gsq;
    }

    public void lB(boolean z) {
        this.gsq = z;
    }
}
