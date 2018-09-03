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
    public static final BdUniqueId dpe = BdUniqueId.gen();
    private List<MetaData> dpb;
    private int dpa = 0;
    private String dpc = "本吧都在关注";
    private boolean dpd = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dpe;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.w.z(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dpa = frsPageUserExtend.user_extend_storey.intValue();
            this.dpb = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dpb.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dpc = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.w.z(featureCardGod.sub_nodes)) {
            this.dpa = featureCardGod.floor.intValue();
            this.dpb = featureCardGod.sub_nodes;
            this.dpc = featureCardGod.title;
        }
    }

    public int wh() {
        return this.dpa;
    }

    public List<MetaData> getUserInfo() {
        return this.dpb;
    }

    public String avF() {
        return this.dpc;
    }

    public boolean avG() {
        return this.dpd;
    }

    public void fM(boolean z) {
        this.dpd = z;
    }
}
