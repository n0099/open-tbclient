package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGN = BdUniqueId.gen();
    private List<MetaData> dGK;
    private int dGJ = 0;
    private String dGL = "本吧都在关注";
    private boolean dGM = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGN;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.E(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dGJ = frsPageUserExtend.user_extend_storey.intValue();
            this.dGK = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dGK.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dGL = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int Al() {
        return this.dGJ;
    }

    public List<MetaData> getUserInfo() {
        return this.dGK;
    }

    public String awi() {
        return this.dGL;
    }

    public boolean awj() {
        return this.dGM;
    }

    public void fV(boolean z) {
        this.dGM = z;
    }
}
