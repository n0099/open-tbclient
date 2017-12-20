package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cJN = BdUniqueId.gen();
    private List<MetaData> cJK;
    private int cJJ = 0;
    private String cJL = "本吧都在关注";
    private boolean cJM = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJN;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cJJ = frsPageUserExtend.user_extend_storey.intValue();
            this.cJK = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cJK.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cJL = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sx() {
        return this.cJJ;
    }

    public List<MetaData> getUserInfo() {
        return this.cJK;
    }

    public String amu() {
        return this.cJL;
    }

    public boolean amv() {
        return this.cJM;
    }

    public void fb(boolean z) {
        this.cJM = z;
    }
}
