package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class a {
    public String eab;
    public boolean hasMore;
    public String iTh;
    public b iTi;
    private boolean iTj;
    private boolean iTk = false;
    public List<q> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iTj = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.eab = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.iTh = dataRes.topic_info.share_pic;
                this.iTi = new b();
                this.iTi.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.iTj = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.iTk = true;
                this.iTj = true;
                if (this.iTi == null) {
                    this.iTi = new b();
                }
                this.iTi.a(dataRes.pk_module);
            } else {
                this.iTk = false;
            }
            if (dataRes.time_line != null) {
                this.iTj = true;
                if (this.iTi == null) {
                    this.iTi = new b();
                }
                this.iTi.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!y.isEmpty(dataRes.special_topic)) {
                this.iTj = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !y.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.iTu = true;
                                    dVar.iTv = specialTopic.title;
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
            if (this.iTj) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.hyL = R.dimen.tbds78;
                cVar.iUS = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !y.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.hyL = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.iTs = this.iTk;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cyY() {
        return this.iTk;
    }
}
