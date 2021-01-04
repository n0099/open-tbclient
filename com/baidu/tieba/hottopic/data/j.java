package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes8.dex */
public class j {
    private ArrayList<com.baidu.adp.widget.ListView.n> kqE = null;
    public List<p> krs;
    public o krt;
    public List<c> kru;
    private List<b> krv;
    public List<NewTopicList> krw;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !x.isEmpty(dataRes.tab_list)) {
                this.krs = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.krs.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.krt = new o();
                this.krt.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.krv = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.krv.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kru = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kru.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.krw = dataRes.topic_list;
        }
    }

    public List<TopicList> cVk() {
        return this.mTopicList;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cVg() {
        return cVi();
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cVi() {
        this.kqE = new ArrayList<>();
        if (this.krt != null && (!StringUtils.isNull(this.krt.picUrl) || !StringUtils.isNull(this.krt.videoUrl))) {
            this.kqE.add(this.krt);
        }
        if (this.krv != null && this.krv.size() > 0) {
            int size = this.krv.size() == 1 ? this.krv.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.krv.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cUT()) || !StringUtils.isNull(bVar.cUU()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kqE.add(this.krv.get(i));
                }
            }
        }
        if (this.kru != null && this.kru.size() > 0) {
            int size2 = this.kru.size() <= 20 ? this.kru.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kru.get(i2);
                cVar.DF(i2 + 1);
                this.kqE.add(cVar);
            }
        }
        return this.kqE;
    }
}
