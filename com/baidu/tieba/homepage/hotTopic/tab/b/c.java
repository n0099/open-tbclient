package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes16.dex */
public class c extends AbsThreadDataSupport {
    private List<b> ixc;

    public c() {
    }

    public c(@NonNull List<RecomTopicList> list) {
        this.ixc = new ArrayList();
        int min = Math.min(list.size(), 9);
        for (int i = 0; i < min; i++) {
            this.ixc.add(new b(list.get(i)));
        }
        this.ixc.add(new b());
    }

    public List<b> cmR() {
        return this.ixc;
    }

    public void db(List<b> list) {
        this.ixc = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iwZ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return null;
    }
}
