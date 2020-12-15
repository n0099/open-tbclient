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
    private ArrayList<q> kds = null;
    public List<p> kef;
    public o keg;
    public List<c> keh;
    private List<b> kei;
    public List<NewTopicList> kej;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.kef = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.kef.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.keg = new o();
                this.keg.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.kei = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.kei.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.keh = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.keh.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.kej = dataRes.topic_list;
        }
    }

    public List<TopicList> cSe() {
        return this.mTopicList;
    }

    public ArrayList<q> cSa() {
        return cSc();
    }

    private ArrayList<q> cSc() {
        this.kds = new ArrayList<>();
        if (this.keg != null && (!StringUtils.isNull(this.keg.picUrl) || !StringUtils.isNull(this.keg.videoUrl))) {
            this.kds.add(this.keg);
        }
        if (this.kei != null && this.kei.size() > 0) {
            int size = this.kei.size() == 1 ? this.kei.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.kei.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cRN()) || !StringUtils.isNull(bVar.cRO()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kds.add(this.kei.get(i));
                }
            }
        }
        if (this.keh != null && this.keh.size() > 0) {
            int size2 = this.keh.size() <= 20 ? this.keh.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.keh.get(i2);
                cVar.Dr(i2 + 1);
                this.kds.add(cVar);
            }
        }
        return this.kds;
    }
}
