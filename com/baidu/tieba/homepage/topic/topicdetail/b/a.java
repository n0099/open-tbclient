package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class a {
    public String dQI;
    public boolean hasMore;
    public String iEj;
    public b iEk;
    private boolean iEl;
    private boolean iEm = false;
    public List<q> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iEl = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.dQI = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.iEj = dataRes.topic_info.share_pic;
                this.iEk = new b();
                this.iEk.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.iEl = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.iEm = true;
                this.iEl = true;
                if (this.iEk == null) {
                    this.iEk = new b();
                }
                this.iEk.a(dataRes.pk_module);
            } else {
                this.iEm = false;
            }
            if (dataRes.time_line != null) {
                this.iEl = true;
                if (this.iEk == null) {
                    this.iEk = new b();
                }
                this.iEk.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!x.isEmpty(dataRes.special_topic)) {
                this.iEl = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !x.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.iEw = true;
                                    dVar.iEx = specialTopic.title;
                                    z = true;
                                }
                                dVar.index = i2;
                                dVar.topicId = this.topicId;
                                dVar.c(threadInfo);
                                this.mDataList.add(dVar);
                                i2++;
                            }
                        }
                        i = i2;
                    }
                }
            }
            if (this.iEl) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.hlU = R.dimen.tbds78;
                cVar.iFU = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !x.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.hlU = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.iEu = this.iEm;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cof() {
        return this.iEm;
    }
}
