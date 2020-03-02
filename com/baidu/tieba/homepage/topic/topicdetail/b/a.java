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
/* loaded from: classes9.dex */
public class a {
    public String cQB;
    public boolean hasMore;
    public String hfZ;
    public b hga;
    private boolean hgb;
    private boolean hgc = false;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hgb = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.cQB = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.hfZ = dataRes.topic_info.share_pic;
                this.hga = new b();
                this.hga.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.hgb = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.hgc = true;
                this.hgb = true;
                if (this.hga == null) {
                    this.hga = new b();
                }
                this.hga.a(dataRes.pk_module);
            } else {
                this.hgc = false;
            }
            if (dataRes.time_line != null) {
                this.hgb = true;
                if (this.hga == null) {
                    this.hga = new b();
                }
                this.hga.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.isEmpty(dataRes.special_topic)) {
                this.hgb = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.hgm = true;
                                    dVar.hgn = specialTopic.title;
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
            if (this.hgb) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.fXd = R.dimen.tbds78;
                cVar.hhL = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.fXd = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.hgk = this.hgc;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean bPr() {
        return this.hgc;
    }
}
