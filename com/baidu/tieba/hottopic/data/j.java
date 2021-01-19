package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes7.dex */
public class j {
    private ArrayList<com.baidu.adp.widget.ListView.n> klZ = null;
    public List<p> kmN;
    public o kmO;
    public List<c> kmP;
    private List<b> kmQ;
    public List<NewTopicList> kmR;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !x.isEmpty(dataRes.tab_list)) {
                this.kmN = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.kmN.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.kmO = new o();
                this.kmO.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.kmQ = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.kmQ.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kmP = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kmP.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.kmR = dataRes.topic_list;
        }
    }

    public List<TopicList> cRt() {
        return this.mTopicList;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cRp() {
        return cRr();
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cRr() {
        this.klZ = new ArrayList<>();
        if (this.kmO != null && (!StringUtils.isNull(this.kmO.picUrl) || !StringUtils.isNull(this.kmO.videoUrl))) {
            this.klZ.add(this.kmO);
        }
        if (this.kmQ != null && this.kmQ.size() > 0) {
            int size = this.kmQ.size() == 1 ? this.kmQ.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.kmQ.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cRc()) || !StringUtils.isNull(bVar.cRd()) || !StringUtils.isNull(bVar.getName()))) {
                    this.klZ.add(this.kmQ.get(i));
                }
            }
        }
        if (this.kmP != null && this.kmP.size() > 0) {
            int size2 = this.kmP.size() <= 20 ? this.kmP.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kmP.get(i2);
                cVar.BY(i2 + 1);
                this.klZ.add(cVar);
            }
        }
        return this.klZ;
    }
}
