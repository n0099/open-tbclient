package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    public String eQU;
    public boolean hasMore;
    public String kqJ;
    public b kqK;
    private boolean kqL;
    private boolean kqM = false;
    public List<n> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.kqL = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.eQU = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.kqJ = dataRes.topic_info.share_pic;
                this.kqK = new b();
                this.kqK.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.kqL = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.kqM = true;
                this.kqL = true;
                if (this.kqK == null) {
                    this.kqK = new b();
                }
                this.kqK.a(dataRes.pk_module);
            } else {
                this.kqM = false;
            }
            if (dataRes.time_line != null) {
                this.kqL = true;
                if (this.kqK == null) {
                    this.kqK = new b();
                }
                this.kqK.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kqL = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !y.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.kqW = true;
                                    dVar.kqX = specialTopic.title;
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
            if (this.kqL) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.iOh = R.dimen.tbds78;
                cVar.eXW = R.color.CAM_X0201;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !y.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.iOh = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.kqU = this.kqM;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cSv() {
        return this.kqM;
    }
}
