package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class y implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId idX = BdUniqueId.gen();
    private List<MetaData> idU;
    private int idT = 0;
    private String idV = "本吧都在关注";
    private boolean idW = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return idX;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.idT = frsPageUserExtend.user_extend_storey.intValue();
            this.idU = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.idU.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.idV = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.idT = featureCardGod.floor.intValue();
            this.idU = featureCardGod.sub_nodes;
            this.idV = featureCardGod.title;
        }
    }

    public int bgM() {
        return this.idT;
    }

    public List<MetaData> getUserInfo() {
        return this.idU;
    }

    public String cqW() {
        return this.idV;
    }

    public boolean cqX() {
        return this.idW;
    }

    public void oB(boolean z) {
        this.idW = z;
    }
}
