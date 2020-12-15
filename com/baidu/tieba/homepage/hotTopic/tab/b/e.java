package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class e implements q {
    public String cover;
    public by eCR;
    public int eMB;
    public int index;
    public int time;
    public String title;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.index = i + 1;
        this.title = threadInfo.title;
        this.eMB = threadInfo.hot_num.intValue();
        if (!y.isEmpty(threadInfo.media)) {
            this.cover = threadInfo.media.get(0).src_pic;
            this.time = threadInfo.media.get(0).during_time.intValue();
        }
        this.eCR = new by();
        this.eCR.eMn = true;
        this.eCR.a(threadInfo);
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jQp;
    }
}
