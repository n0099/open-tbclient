package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
/* loaded from: classes8.dex */
public class j {
    private ArrayList<q> iDS = null;
    public List<p> iEF;
    public o iEG;
    public List<c> iEH;
    private List<b> iEI;
    public List<NewTopicList> iEJ;
    private List<TopicList> mTopicList;
    public String type;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.tab_list != null && !w.isEmpty(dataRes.tab_list)) {
                this.iEF = new ArrayList();
                for (TabList tabList : dataRes.tab_list) {
                    p pVar = new p();
                    pVar.a(tabList);
                    this.iEF.add(pVar);
                }
            }
            if (dataRes.media_topic != null) {
                this.iEG = new o();
                this.iEG.a(dataRes.media_topic);
            }
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.iEI = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.iEI.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.iEH = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.iEH.add(cVar);
                }
            }
            this.mTopicList = dataRes.frs_tab_topic;
            this.iEJ = dataRes.topic_list;
        }
    }

    public List<TopicList> clP() {
        return this.mTopicList;
    }

    public ArrayList<q> clL() {
        return clN();
    }

    private ArrayList<q> clN() {
        this.iDS = new ArrayList<>();
        if (this.iEG != null && (!StringUtils.isNull(this.iEG.picUrl) || !StringUtils.isNull(this.iEG.videoUrl))) {
            this.iDS.add(this.iEG);
        }
        if (this.iEI != null && this.iEI.size() > 0) {
            int size = this.iEI.size() == 1 ? this.iEI.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.iEI.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.cly()) || !StringUtils.isNull(bVar.clz()) || !StringUtils.isNull(bVar.getName()))) {
                    this.iDS.add(this.iEI.get(i));
                }
            }
        }
        if (this.iEH != null && this.iEH.size() > 0) {
            int size2 = this.iEH.size() <= 20 ? this.iEH.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.iEH.get(i2);
                cVar.xF(i2 + 1);
                this.iDS.add(cVar);
            }
        }
        return this.iDS;
    }
}
