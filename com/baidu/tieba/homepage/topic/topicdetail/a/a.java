package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.DataRes;
import tbclient.NewHottopic.SpecialTopic;
import tbclient.NewHottopic.TopicThread;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    public String eRS;
    public boolean hasMore;
    public String kkR;
    public b kkS;
    private boolean kkT;
    private boolean kkU = false;
    public List<n> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.kkT = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.eRS = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.kkR = dataRes.topic_info.share_pic;
                this.kkS = new b();
                this.kkS.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.kkT = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.kkU = true;
                this.kkT = true;
                if (this.kkS == null) {
                    this.kkS = new b();
                }
                this.kkS.a(dataRes.pk_module);
            } else {
                this.kkU = false;
            }
            if (dataRes.time_line != null) {
                this.kkT = true;
                if (this.kkS == null) {
                    this.kkS = new b();
                }
                this.kkS.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!x.isEmpty(dataRes.special_topic)) {
                this.kkT = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !x.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.kle = true;
                                    dVar.klf = specialTopic.title;
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
            if (this.kkT) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.iLi = R.dimen.tbds78;
                cVar.eYS = R.color.CAM_X0201;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !x.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.iLi = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.klc = this.kkU;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cUa() {
        return this.kkU;
    }
}
