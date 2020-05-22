package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
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
    public String dDW;
    public boolean hasMore;
    public String igl;
    public b igm;
    private boolean ign;
    private boolean igo = false;
    public List<o> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ign = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.dDW = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.igl = dataRes.topic_info.share_pic;
                this.igm = new b();
                this.igm.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.ign = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.igo = true;
                this.ign = true;
                if (this.igm == null) {
                    this.igm = new b();
                }
                this.igm.a(dataRes.pk_module);
            } else {
                this.igo = false;
            }
            if (dataRes.time_line != null) {
                this.ign = true;
                if (this.igm == null) {
                    this.igm = new b();
                }
                this.igm.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.isEmpty(dataRes.special_topic)) {
                this.ign = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.igy = true;
                                    dVar.igz = specialTopic.title;
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
            if (this.ign) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.gTq = R.dimen.tbds78;
                cVar.ihX = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.gTq = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.igw = this.igo;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cgI() {
        return this.igo;
    }
}
