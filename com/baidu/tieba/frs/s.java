package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGS = BdUniqueId.gen();
    private List<MetaData> dGP;
    private int dGO = 0;
    private String dGQ = "本吧都在关注";
    private boolean dGR = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGS;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.E(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dGO = frsPageUserExtend.user_extend_storey.intValue();
            this.dGP = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dGP.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dGQ = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int Al() {
        return this.dGO;
    }

    public List<MetaData> getUserInfo() {
        return this.dGP;
    }

    public String awk() {
        return this.dGQ;
    }

    public boolean awl() {
        return this.dGR;
    }

    public void fV(boolean z) {
        this.dGR = z;
    }
}
