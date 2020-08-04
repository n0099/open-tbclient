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
    private List<b> ixe;

    public c() {
    }

    public c(@NonNull List<RecomTopicList> list) {
        this.ixe = new ArrayList();
        int min = Math.min(list.size(), 9);
        for (int i = 0; i < min; i++) {
            this.ixe.add(new b(list.get(i)));
        }
        this.ixe.add(new b());
    }

    public List<b> cmR() {
        return this.ixe;
    }

    public void db(List<b> list) {
        this.ixe = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.ixb;
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
