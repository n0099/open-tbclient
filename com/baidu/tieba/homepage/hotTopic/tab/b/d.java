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
    private List<c> kiX;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.kiX = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.kiX.add(new c(list.get(i), i));
        }
        this.kiX.add(new c());
    }

    public List<c> cQX() {
        return this.kiX;
    }

    public void dZ(List<c> list) {
        this.kiX = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kiR;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        return null;
    }
}
