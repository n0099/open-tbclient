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
    public String bJg;
    public String gok;
    public b gol;
    private boolean gom;
    private boolean gon = false;
    public boolean hasMore;
    public List<m> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gom = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.bJg = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.gok = dataRes.topic_info.share_pic;
                this.gol = new b();
                this.gol.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.gom = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.gon = true;
                this.gom = true;
                if (this.gol == null) {
                    this.gol = new b();
                }
                this.gol.a(dataRes.pk_module);
            } else {
                this.gon = false;
            }
            if (dataRes.time_line != null) {
                this.gom = true;
                if (this.gol == null) {
                    this.gol = new b();
                }
                this.gol.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!v.aa(dataRes.special_topic)) {
                this.gom = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !v.aa(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.gox = true;
                                    dVar.goy = specialTopic.title;
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
            if (this.gom) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.fbt = R.dimen.tbds78;
                cVar.gpX = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !v.aa(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.fbt = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.gov = this.gon;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean byp() {
        return this.gon;
    }
}
