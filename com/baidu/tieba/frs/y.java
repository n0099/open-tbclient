package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes2.dex */
public class y implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWN = BdUniqueId.gen();
    private List<MetaData> hWK;
    private int hWJ = 0;
    private String hWL = "本吧都在关注";
    private boolean hWM = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWN;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.y.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hWJ = frsPageUserExtend.user_extend_storey.intValue();
            this.hWK = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hWK.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hWL = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.y.isEmpty(featureCardGod.sub_nodes)) {
            this.hWJ = featureCardGod.floor.intValue();
            this.hWK = featureCardGod.sub_nodes;
            this.hWL = featureCardGod.title;
        }
    }

    public int bfS() {
        return this.hWJ;
    }

    public List<MetaData> getUserInfo() {
        return this.hWK;
    }

    public String cnI() {
        return this.hWL;
    }

    public boolean cnJ() {
        return this.hWM;
    }

    public void ot(boolean z) {
        this.hWM = z;
    }
}
