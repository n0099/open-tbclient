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
/* loaded from: classes15.dex */
public class j {
    public List<p> iZP;
    public o iZQ;
    public List<c> iZR;
    private List<b> iZS;
    public List<NewTopicList> iZT;
    private ArrayList<q> iZc = null;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.iZP = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.iZP.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.iZQ = new o();
                this.iZQ.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.iZS = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.iZS.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.iZR = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.iZR.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.iZT = dataRes.topic_list;
        }
    }

    public List<TopicList> cAk() {
        return this.mTopicList;
    }

    public ArrayList<q> cAg() {
        return cAi();
    }

    private ArrayList<q> cAi() {
        this.iZc = new ArrayList<>();
        if (this.iZQ != null && (!StringUtils.isNull(this.iZQ.picUrl) || !StringUtils.isNull(this.iZQ.videoUrl))) {
            this.iZc.add(this.iZQ);
        }
        if (this.iZS != null && this.iZS.size() > 0) {
            int size = this.iZS.size() == 1 ? this.iZS.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.iZS.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.czT()) || !StringUtils.isNull(bVar.czU()) || !StringUtils.isNull(bVar.getName()))) {
                    this.iZc.add(this.iZS.get(i));
                }
            }
        }
        if (this.iZR != null && this.iZR.size() > 0) {
            int size2 = this.iZR.size() <= 20 ? this.iZR.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.iZR.get(i2);
                cVar.Ar(i2 + 1);
                this.iZc.add(cVar);
            }
        }
        return this.iZc;
    }
}
