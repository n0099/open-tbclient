package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class f extends e {
    public String forumName;

    public f(@NonNull ThreadInfo threadInfo, int i) {
        super(threadInfo, i);
        this.forumName = threadInfo.fname;
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.b.e, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jjv;
    }
}
