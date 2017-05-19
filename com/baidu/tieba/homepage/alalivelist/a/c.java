package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId csA = BdUniqueId.gen();
    public int csB;
    public List<ForcusUsers> csC;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return csA;
    }
}
