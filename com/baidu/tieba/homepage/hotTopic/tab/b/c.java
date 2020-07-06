package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecomTopicList;
/* loaded from: classes9.dex */
public class c extends AbsThreadDataSupport {
    private List<b> iqY;

    public c() {
    }

    public c(@NonNull List<RecomTopicList> list) {
        this.iqY = new ArrayList();
        int min = Math.min(list.size(), 9);
        for (int i = 0; i < min; i++) {
            this.iqY.add(new b(list.get(i)));
        }
        this.iqY.add(new b());
    }

    public List<b> cjq() {
        return this.iqY;
    }

    public void cW(List<b> list) {
        this.iqY = list;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iqV;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return null;
    }
}
