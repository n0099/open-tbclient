package com.baidu.tieba.homepage.hotTopic.tab.b;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.core.data.a {
    private List<c> kgU;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.kgU = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.kgU.add(new c(list.get(i), i));
        }
        this.kgU.add(new c());
    }

    public List<c> cQQ() {
        return this.kgU;
    }

    public void dZ(List<c> list) {
        this.kgU = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kgO;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        return null;
    }
}
