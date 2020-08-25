package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes16.dex */
public class d extends AbsThreadDataSupport {
    private List<c> iLP;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.iLP = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.iLP.add(new c(list.get(i), i));
        }
        this.iLP.add(new c());
    }

    public List<c> cxE() {
        return this.iLP;
    }

    public void di(List<c> list) {
        this.iLP = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iLJ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        return null;
    }
}
