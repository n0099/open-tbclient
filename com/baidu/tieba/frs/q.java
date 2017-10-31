package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cAg = BdUniqueId.gen();
    private List<MetaData> cAd;
    private int cAc = 0;
    private String cAe = "本吧都在关注";
    private boolean cAf = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cAg;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.v(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cAc = frsPageUserExtend.user_extend_storey.intValue();
            this.cAd = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cAd.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cAe = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sw() {
        return this.cAc;
    }

    public List<MetaData> getUserInfo() {
        return this.cAd;
    }

    public String akc() {
        return this.cAe;
    }

    public boolean akd() {
        return this.cAf;
    }

    public void eE(boolean z) {
        this.cAf = z;
    }
}
