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
    private List<c> iLV;

    public d() {
    }

    public d(@NonNull List<RecomTopicList> list) {
        this.iLV = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.iLV.add(new c(list.get(i), i));
        }
        this.iLV.add(new c());
    }

    public List<c> cxF() {
        return this.iLV;
    }

    public void di(List<c> list) {
        this.iLV = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iLP;
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
