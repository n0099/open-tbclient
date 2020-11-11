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
/* loaded from: classes21.dex */
public class j {
    public List<p> jPQ;
    public o jPR;
    public List<c> jPS;
    private List<b> jPT;
    public List<NewTopicList> jPU;
    private ArrayList<q> jPd = null;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.jPQ = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.jPQ.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.jPR = new o();
                this.jPR.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.jPT = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.jPT.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.jPS = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.jPS.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.jPU = dataRes.topic_list;
        }
    }

    public List<TopicList> cNi() {
        return this.mTopicList;
    }

    public ArrayList<q> cNe() {
        return cNg();
    }

    private ArrayList<q> cNg() {
        this.jPd = new ArrayList<>();
        if (this.jPR != null && (!StringUtils.isNull(this.jPR.picUrl) || !StringUtils.isNull(this.jPR.videoUrl))) {
            this.jPd.add(this.jPR);
        }
        if (this.jPT != null && this.jPT.size() > 0) {
            int size = this.jPT.size() == 1 ? this.jPT.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.jPT.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cMR()) || !StringUtils.isNull(bVar.cMS()) || !StringUtils.isNull(bVar.getName()))) {
                    this.jPd.add(this.jPT.get(i));
                }
            }
        }
        if (this.jPS != null && this.jPS.size() > 0) {
            int size2 = this.jPS.size() <= 20 ? this.jPS.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.jPS.get(i2);
                cVar.Ce(i2 + 1);
                this.jPd.add(cVar);
            }
        }
        return this.jPd;
    }
}
