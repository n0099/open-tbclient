package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dGZ = BdUniqueId.gen();
    private List<MetaData> dGW;
    private int dGV = 0;
    private String dGX = "本吧都在关注";
    private boolean dGY = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGZ;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !com.baidu.tbadk.core.util.v.E(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dGV = frsPageUserExtend.user_extend_storey.intValue();
            this.dGW = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dGW.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dGX = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int Al() {
        return this.dGV;
    }

    public List<MetaData> getUserInfo() {
        return this.dGW;
    }

    public String awj() {
        return this.dGX;
    }

    public boolean awk() {
        return this.dGY;
    }

    public void fV(boolean z) {
        this.dGY = z;
    }
}
