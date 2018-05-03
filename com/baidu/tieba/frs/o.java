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
    public static final BdUniqueId cZI = BdUniqueId.gen();
    private List<MetaData> cZF;
    private int cZE = 0;
    private String cZG = "本吧都在关注";
    private boolean cZH = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZI;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cZE = frsPageUserExtend.user_extend_storey.intValue();
            this.cZF = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cZF.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cZG = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.w(featureCardGod.sub_nodes)) {
            this.cZE = featureCardGod.floor.intValue();
            this.cZF = featureCardGod.sub_nodes;
            this.cZG = featureCardGod.title;
        }
    }

    public int sN() {
        return this.cZE;
    }

    public List<MetaData> getUserInfo() {
        return this.cZF;
    }

    public String aqD() {
        return this.cZG;
    }

    public boolean aqE() {
        return this.cZH;
    }

    public void fA(boolean z) {
        this.cZH = z;
    }
}
