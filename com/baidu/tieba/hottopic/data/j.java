package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes8.dex */
public class j {
    public List<p> kuU;
    public o kuV;
    public List<c> kuW;
    private List<b> kuX;
    public List<NewTopicList> kuY;
    private ArrayList<com.baidu.adp.widget.ListView.n> kug = null;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.kuU = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.kuU.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.kuV = new o();
                this.kuV.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.kuX = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.kuX.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kuW = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kuW.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.kuY = dataRes.topic_list;
        }
    }

    public List<TopicList> cTs() {
        return this.mTopicList;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTo() {
        return cTq();
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTq() {
        this.kug = new ArrayList<>();
        if (this.kuV != null && (!StringUtils.isNull(this.kuV.picUrl) || !StringUtils.isNull(this.kuV.videoUrl))) {
            this.kug.add(this.kuV);
        }
        if (this.kuX != null && this.kuX.size() > 0) {
            int size = this.kuX.size() == 1 ? this.kuX.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.kuX.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cTb()) || !StringUtils.isNull(bVar.cTc()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kug.add(this.kuX.get(i));
                }
            }
        }
        if (this.kuW != null && this.kuW.size() > 0) {
            int size2 = this.kuW.size() <= 20 ? this.kuW.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kuW.get(i2);
                cVar.Cq(i2 + 1);
                this.kug.add(cVar);
            }
        }
        return this.kug;
    }
}
