package com.baidu.tieba.homepage.hotTopic.tab.b;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class e implements n {
    public String cover;
    public cb eLr;
    public int eVA;
    public int index;
    public int time;
    public String title;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.index = i + 1;
        this.title = threadInfo.title;
        this.eVA = threadInfo.hot_num.intValue();
        if (!y.isEmpty(threadInfo.media)) {
            this.cover = threadInfo.media.get(0).src_pic;
            this.time = threadInfo.media.get(0).during_time.intValue();
        }
        this.eLr = new cb();
        this.eLr.eVk = true;
        this.eLr.a(threadInfo);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kiS;
    }
}
