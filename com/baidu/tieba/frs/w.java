package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.FeatureCardGod;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class w implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jey = BdUniqueId.gen();
    private List<MetaData> jev;
    private int jeu = 0;
    private String jew = "本吧都在关注";
    private boolean jex = false;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jey;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.x.isEmpty(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.jeu = frsPageUserExtend.user_extend_storey.intValue();
            this.jev = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.jev.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.jew = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public void a(FeatureCardGod featureCardGod) {
        if (featureCardGod != null && !com.baidu.tbadk.core.util.x.isEmpty(featureCardGod.sub_nodes)) {
            this.jeu = featureCardGod.floor.intValue();
            this.jev = featureCardGod.sub_nodes;
            this.jew = featureCardGod.title;
        }
    }

    public int boO() {
        return this.jeu;
    }

    public List<MetaData> getUserInfo() {
        return this.jev;
    }

    public String cDa() {
        return this.jew;
    }

    public boolean cDb() {
        return this.jex;
    }

    public void qB(boolean z) {
        this.jex = z;
    }
}
