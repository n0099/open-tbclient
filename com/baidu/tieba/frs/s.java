package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dDB = BdUniqueId.gen();
    private List<MetaData> dDy;
    private int dDx = 0;
    private String dDz = "本吧都在关注";
    private boolean dDA = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDB;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !v.E(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dDx = frsPageUserExtend.user_extend_storey.intValue();
            this.dDy = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dDy.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dDz = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int zR() {
        return this.dDx;
    }

    public List<MetaData> getUserInfo() {
        return this.dDy;
    }

    public String avg() {
        return this.dDz;
    }

    public boolean avh() {
        return this.dDA;
    }

    public void fL(boolean z) {
        this.dDA = z;
    }
}
