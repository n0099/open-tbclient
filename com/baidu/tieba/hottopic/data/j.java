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
    public List<p> jJS;
    public o jJT;
    public List<c> jJU;
    private List<b> jJV;
    public List<NewTopicList> jJW;
    private ArrayList<q> jJf = null;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.jJS = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.jJS.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.jJT = new o();
                this.jJT.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.jJV = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.jJV.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.jJU = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.jJU.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.jJW = dataRes.topic_list;
        }
    }

    public List<TopicList> cKH() {
        return this.mTopicList;
    }

    public ArrayList<q> cKD() {
        return cKF();
    }

    private ArrayList<q> cKF() {
        this.jJf = new ArrayList<>();
        if (this.jJT != null && (!StringUtils.isNull(this.jJT.picUrl) || !StringUtils.isNull(this.jJT.videoUrl))) {
            this.jJf.add(this.jJT);
        }
        if (this.jJV != null && this.jJV.size() > 0) {
            int size = this.jJV.size() == 1 ? this.jJV.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.jJV.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cKq()) || !StringUtils.isNull(bVar.cKr()) || !StringUtils.isNull(bVar.getName()))) {
                    this.jJf.add(this.jJV.get(i));
                }
            }
        }
        if (this.jJU != null && this.jJU.size() > 0) {
            int size2 = this.jJU.size() <= 20 ? this.jJU.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.jJU.get(i2);
                cVar.BR(i2 + 1);
                this.jJf.add(cVar);
            }
        }
        return this.jJf;
    }
}
