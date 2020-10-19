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
    private ArrayList<q> jwG = null;
    public List<p> jxt;
    public o jxu;
    public List<c> jxv;
    private List<b> jxw;
    public List<NewTopicList> jxx;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !y.isEmpty(dataRes.tab_list)) {
                this.jxt = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.jxt.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.jxu = new o();
                this.jxu.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.jxw = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.jxw.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.jxv = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.jxv.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.jxx = dataRes.topic_list;
        }
    }

    public List<TopicList> cHA() {
        return this.mTopicList;
    }

    public ArrayList<q> cHw() {
        return cHy();
    }

    private ArrayList<q> cHy() {
        this.jwG = new ArrayList<>();
        if (this.jxu != null && (!StringUtils.isNull(this.jxu.picUrl) || !StringUtils.isNull(this.jxu.videoUrl))) {
            this.jwG.add(this.jxu);
        }
        if (this.jxw != null && this.jxw.size() > 0) {
            int size = this.jxw.size() == 1 ? this.jxw.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.jxw.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cHj()) || !StringUtils.isNull(bVar.cHk()) || !StringUtils.isNull(bVar.getName()))) {
                    this.jwG.add(this.jxw.get(i));
                }
            }
        }
        if (this.jxv != null && this.jxv.size() > 0) {
            int size2 = this.jxv.size() <= 20 ? this.jxv.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.jxv.get(i2);
                cVar.By(i2 + 1);
                this.jwG.add(cVar);
            }
        }
        return this.jwG;
    }
}
