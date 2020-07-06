package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    public String dKw;
    public boolean hasMore;
    public String iyd;
    public b iye;
    private boolean iyf;
    private boolean iyg = false;
    public List<q> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iyf = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.dKw = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.iyd = dataRes.topic_info.share_pic;
                this.iye = new b();
                this.iye.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.iyf = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.iyg = true;
                this.iyf = true;
                if (this.iye == null) {
                    this.iye = new b();
                }
                this.iye.a(dataRes.pk_module);
            } else {
                this.iyg = false;
            }
            if (dataRes.time_line != null) {
                this.iyf = true;
                if (this.iye == null) {
                    this.iye = new b();
                }
                this.iye.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!w.isEmpty(dataRes.special_topic)) {
                this.iyf = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !w.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.iyq = true;
                                    dVar.iyr = specialTopic.title;
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
            if (this.iyf) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.hgk = R.dimen.tbds78;
                cVar.izO = R.color.cp_bg_line_d;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !w.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.hgk = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.iyo = this.iyg;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean ckF() {
        return this.iyg;
    }
}
