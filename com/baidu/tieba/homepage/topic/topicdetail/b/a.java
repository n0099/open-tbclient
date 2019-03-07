package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    public String bAk;
    public String fOo;
    public b fOp;
    private boolean fOq;
    private boolean fOr = false;
    public boolean hasMore;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fOq = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.bAk = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.fOo = dataRes.topic_info.share_pic;
                this.fOp = new b();
                this.fOp.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.fOq = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.fOr = true;
                this.fOq = true;
                if (this.fOp == null) {
                    this.fOp = new b();
                }
                this.fOp.a(dataRes.pk_module);
            } else {
                this.fOr = false;
            }
            if (dataRes.time_line != null) {
                this.fOq = true;
                if (this.fOp == null) {
                    this.fOp = new b();
                }
                this.fOp.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.T(dataRes.special_topic)) {
                this.fOq = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.T(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.fOC = true;
                                    dVar.fOD = specialTopic.title;
                                    z = true;
                                }
                                dVar.index = i2;
                                dVar.topicId = this.topicId;
                                dVar.b(threadInfo);
                                this.mDataList.add(dVar);
                                i2++;
                            }
                        }
                        i = i2;
                    }
                }
            }
            if (this.fOq) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.eEV = d.e.tbds78;
                cVar.fQc = d.C0236d.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.T(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.eEV = d.e.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.fOA = this.fOr;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean bng() {
        return this.fOr;
    }
}
