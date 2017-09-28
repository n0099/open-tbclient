package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId csV = BdUniqueId.gen();
    private List<MetaData> csS;
    private int csR = 0;
    private String csT = "本吧都在关注";
    private boolean csU = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csV;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.u(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.csR = frsPageUserExtend.user_extend_storey.intValue();
            this.csS = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.csS.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.csT = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sw() {
        return this.csR;
    }

    public List<MetaData> getUserInfo() {
        return this.csS;
    }

    public String ahZ() {
        return this.csT;
    }

    public boolean aia() {
        return this.csU;
    }

    public void eJ(boolean z) {
        this.csU = z;
    }
}
