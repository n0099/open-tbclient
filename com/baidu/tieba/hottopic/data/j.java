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
    private ArrayList<q> iJY = null;
    public List<p> iKL;
    public o iKM;
    public List<c> iKN;
    private List<b> iKO;
    public List<NewTopicList> iKP;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !x.isEmpty(dataRes.tab_list)) {
                this.iKL = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.iKL.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.iKM = new o();
                this.iKM.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.iKO = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.iKO.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.iKN = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.iKN.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.iKP = dataRes.topic_list;
        }
    }

    public List<TopicList> cpq() {
        return this.mTopicList;
    }

    public ArrayList<q> cpm() {
        return cpo();
    }

    private ArrayList<q> cpo() {
        this.iJY = new ArrayList<>();
        if (this.iKM != null && (!StringUtils.isNull(this.iKM.picUrl) || !StringUtils.isNull(this.iKM.videoUrl))) {
            this.iJY.add(this.iKM);
        }
        if (this.iKO != null && this.iKO.size() > 0) {
            int size = this.iKO.size() == 1 ? this.iKO.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.iKO.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.coZ()) || !StringUtils.isNull(bVar.cpa()) || !StringUtils.isNull(bVar.getName()))) {
                    this.iJY.add(this.iKO.get(i));
                }
            }
        }
        if (this.iKN != null && this.iKN.size() > 0) {
            int size2 = this.iKN.size() <= 20 ? this.iKN.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.iKN.get(i2);
                cVar.xX(i2 + 1);
                this.iJY.add(cVar);
            }
        }
        return this.iJY;
    }
}
