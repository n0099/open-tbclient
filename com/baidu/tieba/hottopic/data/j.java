package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes7.dex */
public class j {
    private ArrayList<com.baidu.adp.widget.ListView.n> kww = null;
    public List<p> kxk;
    public o kxl;
    public List<c> kxm;
    private List<b> kxn;
    public List<NewTopicList> kxo;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.kxk = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.kxk.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.kxl = new o();
                this.kxl.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.kxn = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.kxn.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.kxm = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.kxm.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.kxo = dataRes.topic_list;
        }
    }

    public List<TopicList> cTG() {
        return this.mTopicList;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTC() {
        return cTE();
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTE() {
        this.kww = new ArrayList<>();
        if (this.kxl != null && (!StringUtils.isNull(this.kxl.picUrl) || !StringUtils.isNull(this.kxl.videoUrl))) {
            this.kww.add(this.kxl);
        }
        if (this.kxn != null && this.kxn.size() > 0) {
            int size = this.kxn.size() == 1 ? this.kxn.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.kxn.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cTp()) || !StringUtils.isNull(bVar.cTq()) || !StringUtils.isNull(bVar.getName()))) {
                    this.kww.add(this.kxn.get(i));
                }
            }
        }
        if (this.kxm != null && this.kxm.size() > 0) {
            int size2 = this.kxm.size() <= 20 ? this.kxm.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.kxm.get(i2);
                cVar.Ct(i2 + 1);
                this.kww.add(cVar);
            }
        }
        return this.kww;
    }
}
