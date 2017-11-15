package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cAz = BdUniqueId.gen();
    private List<MetaData> cAw;
    private int cAv = 0;
    private String cAx = "本吧都在关注";
    private boolean cAy = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cAz;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.v(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.cAv = frsPageUserExtend.user_extend_storey.intValue();
            this.cAw = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.cAw.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.cAx = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int sw() {
        return this.cAv;
    }

    public List<MetaData> getUserInfo() {
        return this.cAw;
    }

    public String akq() {
        return this.cAx;
    }

    public boolean akr() {
        return this.cAy;
    }

    public void eJ(boolean z) {
        this.cAy = z;
    }
}
