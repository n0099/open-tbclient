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
    private ArrayList<com.baidu.adp.widget.ListView.n> kuu = null;
    public List<p> kvi;
    public o kvj;
    public List<c> kvk;
    private List<b> kvl;
    public List<NewTopicList> kvm;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.kvi = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.kvi.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.kvj = new o();
                this.kvj.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.kvl = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.kvl.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kvk = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kvk.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.kvm = dataRes.topic_list;
        }
    }

    public List<TopicList> cTz() {
        return this.mTopicList;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTv() {
        return cTx();
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTx() {
        this.kuu = new ArrayList<>();
        if (this.kvj != null && (!StringUtils.isNull(this.kvj.picUrl) || !StringUtils.isNull(this.kvj.videoUrl))) {
            this.kuu.add(this.kvj);
        }
        if (this.kvl != null && this.kvl.size() > 0) {
            int size = this.kvl.size() == 1 ? this.kvl.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.kvl.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cTi()) || !StringUtils.isNull(bVar.cTj()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kuu.add(this.kvl.get(i));
                }
            }
        }
        if (this.kvk != null && this.kvk.size() > 0) {
            int size2 = this.kvk.size() <= 20 ? this.kvk.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kvk.get(i2);
                cVar.Cq(i2 + 1);
                this.kuu.add(cVar);
            }
        }
        return this.kuu;
    }
}
