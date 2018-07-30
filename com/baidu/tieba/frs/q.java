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
    public static final BdUniqueId dpg = BdUniqueId.gen();
    private List<MetaData> dpd;
    private int dpc = 0;
    private String dpe = "本吧都在关注";
    private boolean dpf = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dpg;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.w.z(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dpc = frsPageUserExtend.user_extend_storey.intValue();
            this.dpd = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dpd.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dpe = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.w.z(featureCardGod.sub_nodes)) {
            this.dpc = featureCardGod.floor.intValue();
            this.dpd = featureCardGod.sub_nodes;
            this.dpe = featureCardGod.title;
        }
    }

    public int wi() {
        return this.dpc;
    }

    public List<MetaData> getUserInfo() {
        return this.dpd;
    }

    public String avG() {
        return this.dpe;
    }

    public boolean avH() {
        return this.dpf;
    }

    public void fM(boolean z) {
        this.dpf = z;
    }
}
