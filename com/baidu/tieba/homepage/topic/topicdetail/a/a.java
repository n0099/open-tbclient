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
    public String ePt;
    public boolean hasMore;
    public String koH;
    public b koI;
    private boolean koJ;
    private boolean koK = false;
    public List<n> mDataList;
    public String shareTitle;
    public long topicId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.koJ = false;
            if (dataRes.topic_info != null) {
                this.topicId = dataRes.topic_info.topic_id.longValue();
                this.ePt = dataRes.topic_info.topic_name;
                this.shareTitle = dataRes.topic_info.share_title;
                this.koH = dataRes.topic_info.share_pic;
                this.koI = new b();
                this.koI.a(dataRes.topic_info);
                if (!StringUtils.isNull(dataRes.topic_info.topic_image)) {
                    this.koJ = true;
                }
            }
            if (dataRes.pk_module != null) {
                this.koK = true;
                this.koJ = true;
                if (this.koI == null) {
                    this.koI = new b();
                }
                this.koI.a(dataRes.pk_module);
            } else {
                this.koK = false;
            }
            if (dataRes.time_line != null) {
                this.koJ = true;
                if (this.koI == null) {
                    this.koI = new b();
                }
                this.koI.a(dataRes.time_line);
            }
            this.mDataList = new ArrayList();
            if (!y.isEmpty(dataRes.special_topic)) {
                this.koJ = true;
                int i = 1;
                for (SpecialTopic specialTopic : dataRes.special_topic) {
                    if (specialTopic != null && !y.isEmpty(specialTopic.thread_list)) {
                        boolean z = false;
                        int i2 = i;
                        for (ThreadInfo threadInfo : specialTopic.thread_list) {
                            if (threadInfo != null) {
                                d dVar = new d();
                                if (!z) {
                                    dVar.koU = true;
                                    dVar.koV = specialTopic.title;
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
            if (this.koJ) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar.iMy = R.dimen.tbds78;
                cVar.eWx = R.color.CAM_X0201;
                this.mDataList.add(cVar);
            }
            if (dataRes.relate_thread != null && !y.isEmpty(dataRes.relate_thread.thread_list)) {
                com.baidu.tieba.homepage.topic.topictab.b.c cVar2 = new com.baidu.tieba.homepage.topic.topictab.b.c();
                cVar2.iMy = R.dimen.tbds16;
                this.mDataList.add(cVar2);
                this.hasMore = dataRes.relate_thread.has_more.intValue() == 1;
                for (TopicThread topicThread : dataRes.relate_thread.thread_list) {
                    if (topicThread != null) {
                        c cVar3 = new c();
                        cVar3.a(topicThread);
                        cVar3.topicId = this.topicId;
                        cVar3.koS = this.koK;
                        this.mDataList.add(cVar3);
                    }
                }
            }
        }
    }

    public boolean cSo() {
        return this.koK;
    }
}
