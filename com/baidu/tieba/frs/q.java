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
    public static final BdUniqueId dmo = BdUniqueId.gen();
    private List<MetaData> dml;
    private int dmk = 0;
    private String dmm = "本吧都在关注";
    private boolean dmn = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dmo;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.w.A(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dmk = frsPageUserExtend.user_extend_storey.intValue();
            this.dml = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dml.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dmm = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.w.A(featureCardGod.sub_nodes)) {
            this.dmk = featureCardGod.floor.intValue();
            this.dml = featureCardGod.sub_nodes;
            this.dmm = featureCardGod.title;
        }
    }

    public int wt() {
        return this.dmk;
    }

    public List<MetaData> getUserInfo() {
        return this.dml;
    }

    public String avb() {
        return this.dmm;
    }

    public boolean avc() {
        return this.dmn;
    }

    public void fK(boolean z) {
        this.dmn = z;
    }
}
