package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes22.dex */
public class d extends AbsThreadDataSupport {
    private List<c> jjz;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.jjz = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.jjz.add(new c(list.get(i), i));
        }
        this.jjz.add(new c());
    }

    public List<c> cEU() {
        return this.jjz;
    }

    public void dt(List<c> list) {
        this.jjz = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jjt;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        return null;
    }
}
