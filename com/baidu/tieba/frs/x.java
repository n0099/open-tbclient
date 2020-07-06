package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class x implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hDv = BdUniqueId.gen();
    private List<MetaData> hDs;
    private int hDr = 0;
    private String hDt = "本吧都在关注";
    private boolean hDu = false;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hDv;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.w.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.hDr = frsPageUserExtend.user_extend_storey.intValue();
            this.hDs = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.hDs.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.hDt = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.w.isEmpty(featureCardGod.sub_nodes)) {
            this.hDr = featureCardGod.floor.intValue();
            this.hDs = featureCardGod.sub_nodes;
            this.hDt = featureCardGod.title;
        }
    }

    public int aTD() {
        return this.hDr;
    }

    public List<MetaData> getUserInfo() {
        return this.hDs;
    }

    public String bZO() {
        return this.hDt;
    }

    public boolean bZP() {
        return this.hDu;
    }

    public void nk(boolean z) {
        this.hDu = z;
    }
}
