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
    public String bAp;
    public String fOb;
    public b fOc;
    private boolean fOd;
    private boolean fOe = false;
    public boolean hasMore;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fOd = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.bAp = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.fOb = dataRes.topic_info.share_pic;
                this.fOc = new b();
                this.fOc.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.fOd = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.fOe = true;
                this.fOd = true;
                if (this.fOc == null) {
                    this.fOc = new b();
                }
                this.fOc.a(dataRes.pk_module);
            } else {
                this.fOe = false;
            }
            if (dataRes.time_line != null) {
                this.fOd = true;
                if (this.fOc == null) {
                    this.fOc = new b();
                }
                this.fOc.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.T(dataRes.special_topic)) {
                this.fOd = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.T(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.fOp = true;
                                    dVar.fOq = specialTopic.title;
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
            if (this.fOd) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.eEC = d.e.tbds78;
                cVar.fPQ = d.C0277d.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.T(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.eEC = d.e.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.fOn = this.fOe;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean bnd() {
        return this.fOe;
    }
}
