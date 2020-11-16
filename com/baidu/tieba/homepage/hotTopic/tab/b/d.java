package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes21.dex */
public class d extends com.baidu.tbadk.core.data.a {
    private List<c> jCQ;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.jCQ = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.jCQ.add(new c(list.get(i), i));
        }
        this.jCQ.add(new c());
    }

    public List<c> cKh() {
        return this.jCQ;
    }

    public void dK(List<c> list) {
        this.jCQ = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jCK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        return null;
    }
}
