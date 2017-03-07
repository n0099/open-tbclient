package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusRecommand;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId cuJ = BdUniqueId.gen();
    public int cuK;
    public List<ForcusUsers> cuL;

    public c(ForcusRecommand forcusRecommand) {
        if (forcusRecommand != null) {
            this.cuK = forcusRecommand.type.intValue();
            this.cuL = forcusRecommand.users;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cuJ;
    }
}
