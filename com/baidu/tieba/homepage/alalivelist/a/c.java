package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusRecommand;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId ctj = BdUniqueId.gen();
    public int ctk;
    public List<ForcusUsers> ctl;

    public c(ForcusRecommand forcusRecommand) {
        if (forcusRecommand != null) {
            this.ctk = forcusRecommand.type.intValue();
            this.ctl = forcusRecommand.users;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ctj;
    }
}
