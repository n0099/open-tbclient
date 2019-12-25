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
/* loaded from: classes6.dex */
public class a {
    public String cMn;
    public boolean hasMore;
    public String hat;
    public b hau;
    private boolean hav;
    private boolean haw = false;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hav = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.cMn = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.hat = dataRes.topic_info.share_pic;
                this.hau = new b();
                this.hau.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.hav = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.haw = true;
                this.hav = true;
                if (this.hau == null) {
                    this.hau = new b();
                }
                this.hau.a(dataRes.pk_module);
            } else {
                this.haw = false;
            }
            if (dataRes.time_line != null) {
                this.hav = true;
                if (this.hau == null) {
                    this.hau = new b();
                }
                this.hau.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.isEmpty(dataRes.special_topic)) {
                this.hav = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.haG = true;
                                    dVar.haH = specialTopic.title;
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
            if (this.hav) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.fRQ = R.dimen.tbds78;
                cVar.hcg = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.fRQ = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.haE = this.haw;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean bMF() {
        return this.haw;
    }
}
