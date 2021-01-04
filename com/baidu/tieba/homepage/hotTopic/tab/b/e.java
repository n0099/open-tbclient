package com.baidu.tieba.homepage.hotTopic.tab.b;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class e implements n {
    public String cover;
    public bz eMv;
    public int eWw;
    public int index;
    public int time;
    public String title;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.index = i + 1;
        this.title = threadInfo.title;
        this.eWw = threadInfo.hot_num.intValue();
        if (!x.isEmpty(threadInfo.media)) {
            this.cover = threadInfo.media.get(0).src_pic;
            this.time = threadInfo.media.get(0).during_time.intValue();
        }
        this.eMv = new bz();
        this.eMv.eWi = true;
        this.eMv.a(threadInfo);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.kdD;
    }
}
