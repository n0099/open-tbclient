package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes20.dex */
public class j {
    private ArrayList<q> jPN = null;
    public List<p> jQA;
    public o jQB;
    public List<c> jQC;
    private List<b> jQD;
    public List<NewTopicList> jQE;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.jQA = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.jQA.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.jQB = new o();
                this.jQB.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.jQD = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.jQD.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.jQC = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.jQC.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.jQE = dataRes.topic_list;
        }
    }

    public List<TopicList> cMP() {
        return this.mTopicList;
    }

    public ArrayList<q> cML() {
        return cMN();
    }

    private ArrayList<q> cMN() {
        this.jPN = new ArrayList<>();
        if (this.jQB != null && (!StringUtils.isNull(this.jQB.picUrl) || !StringUtils.isNull(this.jQB.videoUrl))) {
            this.jPN.add(this.jQB);
        }
        if (this.jQD != null && this.jQD.size() > 0) {
            int size = this.jQD.size() == 1 ? this.jQD.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.jQD.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cMy()) || !StringUtils.isNull(bVar.cMz()) || !StringUtils.isNull(bVar.getName()))) {
                    this.jPN.add(this.jQD.get(i));
                }
            }
        }
        if (this.jQC != null && this.jQC.size() > 0) {
            int size2 = this.jQC.size() <= 20 ? this.jQC.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.jQC.get(i2);
                cVar.CC(i2 + 1);
                this.jPN.add(cVar);
            }
        }
        return this.jPN;
    }
}
