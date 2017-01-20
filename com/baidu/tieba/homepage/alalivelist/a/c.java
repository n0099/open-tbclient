package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusRecommand;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId ctk = BdUniqueId.gen();
    public int ctl;
    public List<ForcusUsers> ctm;

    public c(ForcusRecommand forcusRecommand) {
        if (forcusRecommand != null) {
            this.ctl = forcusRecommand.type.intValue();
            this.ctm = forcusRecommand.users;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ctk;
    }
}
