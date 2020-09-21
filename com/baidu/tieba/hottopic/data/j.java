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
    private ArrayList<q> jhH = null;
    public List<p> jiv;
    public o jiw;
    public List<c> jix;
    private List<b> jiy;
    public List<NewTopicList> jiz;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.jiv = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.jiv.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.jiw = new o();
                this.jiw.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.jiy = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.jiy.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.jix = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.jix.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.jiz = dataRes.topic_list;
        }
    }

    public List<TopicList> cDR() {
        return this.mTopicList;
    }

    public ArrayList<q> cDN() {
        return cDP();
    }

    private ArrayList<q> cDP() {
        this.jhH = new ArrayList<>();
        if (this.jiw != null && (!StringUtils.isNull(this.jiw.picUrl) || !StringUtils.isNull(this.jiw.videoUrl))) {
            this.jhH.add(this.jiw);
        }
        if (this.jiy != null && this.jiy.size() > 0) {
            int size = this.jiy.size() == 1 ? this.jiy.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.jiy.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cDA()) || !StringUtils.isNull(bVar.cDB()) || !StringUtils.isNull(bVar.getName()))) {
                    this.jhH.add(this.jiy.get(i));
                }
            }
        }
        if (this.jix != null && this.jix.size() > 0) {
            int size2 = this.jix.size() <= 20 ? this.jix.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.jix.get(i2);
                cVar.AS(i2 + 1);
                this.jhH.add(cVar);
            }
        }
        return this.jhH;
    }
}
