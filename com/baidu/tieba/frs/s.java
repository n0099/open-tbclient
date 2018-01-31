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
    public static final BdUniqueId dDW = BdUniqueId.gen();
    private List<MetaData> dDT;
    private int dDS = 0;
    private String dDU = "本吧都在关注";
    private boolean dDV = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDW;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !v.E(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dDS = frsPageUserExtend.user_extend_storey.intValue();
            this.dDT = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dDT.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dDU = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int zS() {
        return this.dDS;
    }

    public List<MetaData> getUserInfo() {
        return this.dDT;
    }

    public String avl() {
        return this.dDU;
    }

    public boolean avm() {
        return this.dDV;
    }

    public void fN(boolean z) {
        this.dDV = z;
    }
}
