package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gmi = BdUniqueId.gen();
    private List<MetaData> gmf;
    private int gme = 0;
    private String gmg = "本吧都在关注";
    private boolean gmh = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmi;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.gme = frsPageUserExtend.user_extend_storey.intValue();
            this.gmf = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.gmf.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.gmg = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.isEmpty(featureCardGod.sub_nodes)) {
            this.gme = featureCardGod.floor.intValue();
            this.gmf = featureCardGod.sub_nodes;
            this.gmg = featureCardGod.title;
        }
    }

    public int aAQ() {
        return this.gme;
    }

    public List<MetaData> getUserInfo() {
        return this.gmf;
    }

    public String bCL() {
        return this.gmg;
    }

    public boolean bCM() {
        return this.gmh;
    }

    public void lh(boolean z) {
        this.gmh = z;
    }
}
