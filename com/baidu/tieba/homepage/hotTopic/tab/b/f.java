package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes9.dex */
public class f implements q {
    private String title;

    public f(@NonNull String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.iqT;
    }
}
