package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes22.dex */
public class d extends com.baidu.tbadk.core.data.a {
    private List<c> jQu;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.jQu = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.jQu.add(new c(list.get(i), i));
        }
        this.jQu.add(new c());
    }

    public List<c> cPx() {
        return this.jQu;
    }

    public void dV(List<c> list) {
        this.jQu = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jQo;
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        return null;
    }
}
