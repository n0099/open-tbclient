package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId cGE = BdUniqueId.gen();
    public int cGF;
    public List<ForcusUsers> cGG;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cGE;
    }
}
