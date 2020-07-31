package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class e implements q {
    public int aoJ;
    public String cover;
    public bv dLK;
    public int index;
    public int time;
    public String title;

    public e(@NonNull ThreadInfo threadInfo, int i) {
        this.index = i + 1;
        this.title = threadInfo.title;
        this.aoJ = threadInfo.reply_num.intValue();
        if (!x.isEmpty(threadInfo.media)) {
            this.cover = threadInfo.media.get(0).src_pic;
            this.time = threadInfo.media.get(0).during_time.intValue();
        }
        this.dLK = new bv();
        this.dLK.a(threadInfo);
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.ixa;
    }
}
