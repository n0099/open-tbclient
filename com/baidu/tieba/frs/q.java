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
    public static final BdUniqueId dOo = BdUniqueId.gen();
    private List<MetaData> dOl;
    private int dOk = 0;
    private String dOm = "本吧都在关注";
    private boolean dOn = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOo;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.I(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dOk = frsPageUserExtend.user_extend_storey.intValue();
            this.dOl = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dOl.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dOm = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.I(featureCardGod.sub_nodes)) {
            this.dOk = featureCardGod.floor.intValue();
            this.dOl = featureCardGod.sub_nodes;
            this.dOm = featureCardGod.title;
        }
    }

    public int AT() {
        return this.dOk;
    }

    public List<MetaData> getUserInfo() {
        return this.dOl;
    }

    public String aDo() {
        return this.dOm;
    }

    public boolean aDp() {
        return this.dOn;
    }

    public void gM(boolean z) {
        this.dOn = z;
    }
}
