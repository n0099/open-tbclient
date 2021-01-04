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
    private List<c> kdI;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.kdI = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.kdI.add(new c(list.get(i), i));
        }
        this.kdI.add(new c());
    }

    public List<c> cSD() {
        return this.kdI;
    }

    public void ec(List<c> list) {
        this.kdI = list;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kdC;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boO() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boQ() {
        return null;
    }
}
