package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId csJ = BdUniqueId.gen();
    private List<MetaData> csG;
    private int csF = 0;
    private String csH = "本吧都在关注";
    private boolean csI = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csJ;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.u(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.csF = frsPageUserExtend.user_extend_storey.intValue();
            this.csG = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.csG.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.csH = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sp() {
        return this.csF;
    }

    public List<MetaData> getUserInfo() {
        return this.csG;
    }

    public String ahU() {
        return this.csH;
    }

    public boolean ahV() {
        return this.csI;
    }

    public void eI(boolean z) {
        this.csI = z;
    }
}
