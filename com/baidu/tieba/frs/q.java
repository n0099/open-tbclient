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
    public static final BdUniqueId fsf = BdUniqueId.gen();
    private List<MetaData> fsc;
    private int fsb = 0;
    private String fsd = "本吧都在关注";
    private boolean fse = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsf;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.aa(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.fsb = frsPageUserExtend.user_extend_storey.intValue();
            this.fsc = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.fsc.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.fsd = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.aa(featureCardGod.sub_nodes)) {
            this.fsb = featureCardGod.floor.intValue();
            this.fsc = featureCardGod.sub_nodes;
            this.fsd = featureCardGod.title;
        }
    }

    public int aeC() {
        return this.fsb;
    }

    public List<MetaData> getUserInfo() {
        return this.fsc;
    }

    public String bln() {
        return this.fsd;
    }

    public boolean blo() {
        return this.fse;
    }

    public void jU(boolean z) {
        this.fse = z;
    }
}
