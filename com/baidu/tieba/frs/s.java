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
    public static final BdUniqueId dza = BdUniqueId.gen();
    private List<MetaData> dyX;
    private int dyW = 0;
    private String dyY = "本吧都在关注";
    private boolean dyZ = false;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dza;
    }

    public void a(FrsPageUserExtend frsPageUserExtend) {
        if (frsPageUserExtend != null && !v.G(frsPageUserExtend.data)) {
            List<User> list = frsPageUserExtend.data;
            this.dyW = frsPageUserExtend.user_extend_storey.intValue();
            this.dyX = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    User user = list.get(i2);
                    if (user != null && user.id.longValue() != 0) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        this.dyX.add(metaData);
                    }
                    i = i2 + 1;
                } else {
                    this.dyY = frsPageUserExtend.tips;
                    return;
                }
            }
        }
    }

    public int zZ() {
        return this.dyW;
    }

    public List<MetaData> getUserInfo() {
        return this.dyX;
    }

    public String aud() {
        return this.dyY;
    }

    public boolean aue() {
        return this.dyZ;
    }

    public void fH(boolean z) {
        this.dyZ = z;
    }
}
