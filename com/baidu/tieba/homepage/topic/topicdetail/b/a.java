package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    public String caN;
    public String gnJ;
    public b gnK;
    private boolean gnL;
    private boolean gnM = false;
    public boolean hasMore;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gnL = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.caN = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.gnJ = dataRes.topic_info.share_pic;
                this.gnK = new b();
                this.gnK.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.gnL = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.gnM = true;
                this.gnL = true;
                if (this.gnK == null) {
                    this.gnK = new b();
                }
                this.gnK.a(dataRes.pk_module);
            } else {
                this.gnM = false;
            }
            if (dataRes.time_line != null) {
                this.gnL = true;
                if (this.gnK == null) {
                    this.gnK = new b();
                }
                this.gnK.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.isEmpty(dataRes.special_topic)) {
                this.gnL = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.gnW = true;
                                    dVar.gnX = specialTopic.title;
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
            if (this.gnL) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.fee = R.dimen.tbds78;
                cVar.gpw = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.fee = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.gnU = this.gnM;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean bvt() {
        return this.gnM;
    }
}
