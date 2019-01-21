package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dOp = BdUniqueId.gen();
    private List<MetaData> dOm;
    private int dOl = 0;
    private String dOn = "本吧都在关注";
    private boolean dOo = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOp;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.I(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dOl = frsPageUserExtend.user_extend_storey.intValue();
            this.dOm = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dOm.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dOn = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.I(featureCardGod.sub_nodes)) {
            this.dOl = featureCardGod.floor.intValue();
            this.dOm = featureCardGod.sub_nodes;
            this.dOn = featureCardGod.title;
        }
    }

    public int AT() {
        return this.dOl;
    }

    public List<MetaData> getUserInfo() {
        return this.dOm;
    }

    public String aDo() {
        return this.dOn;
    }

    public boolean aDp() {
        return this.dOo;
    }

    public void gM(boolean z) {
        this.dOo = z;
    }
}
