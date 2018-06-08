package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dkh = BdUniqueId.gen();
    private List<MetaData> dke;
    private int dkd = 0;
    private String dkf = "本吧都在关注";
    private boolean dkg = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkh;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.w.z(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dkd = frsPageUserExtend.user_extend_storey.intValue();
            this.dke = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dke.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dkf = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.w.z(featureCardGod.sub_nodes)) {
            this.dkd = featureCardGod.floor.intValue();
            this.dke = featureCardGod.sub_nodes;
            this.dkf = featureCardGod.title;
        }
    }

    public int wj() {
        return this.dkd;
    }

    public List<MetaData> getUserInfo() {
        return this.dke;
    }

    public String auH() {
        return this.dkf;
    }

    public boolean auI() {
        return this.dkg;
    }

    public void fG(boolean z) {
        this.dkg = z;
    }
}
