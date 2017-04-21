package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusRecommand;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId cvA = BdUniqueId.gen();
    public int cvB;
    public List<ForcusUsers> cvC;

    public c(ForcusRecommand forcusRecommand) {
        if (forcusRecommand != null) {
            this.cvB = forcusRecommand.type.intValue();
            this.cvC = forcusRecommand.users;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cvA;
    }
}
