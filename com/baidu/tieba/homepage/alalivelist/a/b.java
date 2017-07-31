package com.baidu.tieba.homepage.alalivelist.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cPj = BdUniqueId.gen();
    public int cPk;
    public List<ForcusUsers> cPl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cPj;
    }
}
