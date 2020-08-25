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
    private ArrayList<q> iYW = null;
    public List<p> iZJ;
    public o iZK;
    public List<c> iZL;
    private List<b> iZM;
    public List<NewTopicList> iZN;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.iZJ = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.iZJ.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.iZK = new o();
                this.iZK.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.iZM = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.iZM.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.iZL = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.iZL.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.iZN = dataRes.topic_list;
        }
    }

    public List<TopicList> cAj() {
        return this.mTopicList;
    }

    public ArrayList<q> cAf() {
        return cAh();
    }

    private ArrayList<q> cAh() {
        this.iYW = new ArrayList<>();
        if (this.iZK != null && (!StringUtils.isNull(this.iZK.picUrl) || !StringUtils.isNull(this.iZK.videoUrl))) {
            this.iYW.add(this.iZK);
        }
        if (this.iZM != null && this.iZM.size() > 0) {
            int size = this.iZM.size() == 1 ? this.iZM.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.iZM.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.czS()) || !StringUtils.isNull(bVar.czT()) || !StringUtils.isNull(bVar.getName()))) {
                    this.iYW.add(this.iZM.get(i));
                }
            }
        }
        if (this.iZL != null && this.iZL.size() > 0) {
            int size2 = this.iZL.size() <= 20 ? this.iZL.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.iZL.get(i2);
                cVar.Ar(i2 + 1);
                this.iYW.add(cVar);
            }
        }
        return this.iYW;
    }
}
