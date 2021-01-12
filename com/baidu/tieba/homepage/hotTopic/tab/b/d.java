package com.baidu.tieba.homepage.hotTopic.tab.b;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.core.data.a {
    private List<c> jZd;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.jZd = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.jZd.add(new c(list.get(i), i));
        }
        this.jZd.add(new c());
    }

    public List<c> cOM() {
        return this.jZd;
    }

    public void ec(List<c> list) {
        this.jZd = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.jYX;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        return null;
    }
}
