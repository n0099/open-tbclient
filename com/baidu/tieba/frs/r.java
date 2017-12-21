package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cJR = BdUniqueId.gen();
    private List<MetaData> cJO;
    private int cJN = 0;
    private String cJP = "本吧都在关注";
    private boolean cJQ = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJR;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.w(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cJN = frsPageUserExtend.user_extend_storey.intValue();
            this.cJO = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cJO.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cJP = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sx() {
        return this.cJN;
    }

    public List<MetaData> getUserInfo() {
        return this.cJO;
    }

    public String amv() {
        return this.cJP;
    }

    public boolean amw() {
        return this.cJQ;
    }

    public void fb(boolean z) {
        this.cJQ = z;
    }
}
