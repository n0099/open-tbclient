package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes15.dex */
public class j {
    private ArrayList<q> iJW = null;
    public List<p> iKJ;
    public o iKK;
    public List<c> iKL;
    private List<b> iKM;
    public List<NewTopicList> iKN;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !x.isEmpty(dataRes.tab_list)) {
                this.iKJ = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.iKJ.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.iKK = new o();
                this.iKK.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.iKM = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.iKM.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.iKL = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.iKL.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.iKN = dataRes.topic_list;
        }
    }

    public List<TopicList> cpq() {
        return this.mTopicList;
    }

    public ArrayList<q> cpm() {
        return cpo();
    }

    private ArrayList<q> cpo() {
        this.iJW = new ArrayList<>();
        if (this.iKK != null && (!StringUtils.isNull(this.iKK.picUrl) || !StringUtils.isNull(this.iKK.videoUrl))) {
            this.iJW.add(this.iKK);
        }
        if (this.iKM != null && this.iKM.size() > 0) {
            int size = this.iKM.size() == 1 ? this.iKM.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.iKM.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.coZ()) || !StringUtils.isNull(bVar.cpa()) || !StringUtils.isNull(bVar.getName()))) {
                    this.iJW.add(this.iKM.get(i));
                }
            }
        }
        if (this.iKL != null && this.iKL.size() > 0) {
            int size2 = this.iKL.size() <= 20 ? this.iKL.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.iKL.get(i2);
                cVar.xX(i2 + 1);
                this.iJW.add(cVar);
            }
        }
        return this.iJW;
    }
}
