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
    public static final BdUniqueId dDc = BdUniqueId.gen();
    private List<MetaData> dCZ;
    private int dCY = 0;
    private String dDa = "本吧都在关注";
    private boolean dDb = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dDc;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.J(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dCY = frsPageUserExtend.user_extend_storey.intValue();
            this.dCZ = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dCZ.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dDa = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.J(featureCardGod.sub_nodes)) {
            this.dCY = featureCardGod.floor.intValue();
            this.dCZ = featureCardGod.sub_nodes;
            this.dDa = featureCardGod.title;
        }
    }

    public int zv() {
        return this.dCY;
    }

    public List<MetaData> getUserInfo() {
        return this.dCZ;
    }

    public String aAV() {
        return this.dDa;
    }

    public boolean aAW() {
        return this.dDb;
    }

    public void gv(boolean z) {
        this.dDb = z;
    }
}
