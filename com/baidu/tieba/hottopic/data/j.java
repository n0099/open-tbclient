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
    private ArrayList<q> kdq = null;
    public List<p> ked;
    public o kee;
    public List<c> kef;
    private List<b> keg;
    public List<NewTopicList> keh;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.ked = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.ked.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.kee = new o();
                this.kee.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.keg = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.keg.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kef = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kef.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.keh = dataRes.topic_list;
        }
    }

    public List<TopicList> cSd() {
        return this.mTopicList;
    }

    public ArrayList<q> cRZ() {
        return cSb();
    }

    private ArrayList<q> cSb() {
        this.kdq = new ArrayList<>();
        if (this.kee != null && (!StringUtils.isNull(this.kee.picUrl) || !StringUtils.isNull(this.kee.videoUrl))) {
            this.kdq.add(this.kee);
        }
        if (this.keg != null && this.keg.size() > 0) {
            int size = this.keg.size() == 1 ? this.keg.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.keg.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cRM()) || !StringUtils.isNull(bVar.cRN()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kdq.add(this.keg.get(i));
                }
            }
        }
        if (this.kef != null && this.kef.size() > 0) {
            int size2 = this.kef.size() <= 20 ? this.kef.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kef.get(i2);
                cVar.Dr(i2 + 1);
                this.kdq.add(cVar);
            }
        }
        return this.kdq;
    }
}
