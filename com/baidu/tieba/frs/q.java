package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cJD = BdUniqueId.gen();
    private List<MetaData> cJA;
    private int cJz = 0;
    private String cJB = "本吧都在关注";
    private boolean cJC = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJD;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cJz = frsPageUserExtend.user_extend_storey.intValue();
            this.cJA = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cJA.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cJB = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sz() {
        return this.cJz;
    }

    public List<MetaData> getUserInfo() {
        return this.cJA;
    }

    public String amm() {
        return this.cJB;
    }

    public boolean amn() {
        return this.cJC;
    }

    public void fa(boolean z) {
        this.cJC = z;
    }
}
