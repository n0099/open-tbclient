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
    public static final BdUniqueId dvb = BdUniqueId.gen();
    private List<MetaData> duY;
    private int duX = 0;
    private String duZ = "本吧都在关注";
    private boolean dva = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dvb;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.z(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.duX = frsPageUserExtend.user_extend_storey.intValue();
            this.duY = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.duY.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.duZ = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.v.z(featureCardGod.sub_nodes)) {
            this.duX = featureCardGod.floor.intValue();
            this.duY = featureCardGod.sub_nodes;
            this.duZ = featureCardGod.title;
        }
    }

    public int xm() {
        return this.duX;
    }

    public List<MetaData> getUserInfo() {
        return this.duY;
    }

    public String axz() {
        return this.duZ;
    }

    public boolean axA() {
        return this.dva;
    }

    public void gd(boolean z) {
        this.dva = z;
    }
}
