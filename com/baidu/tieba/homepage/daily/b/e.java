package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ggB = BdUniqueId.gen();
    public List<a> ggC;

    public static e cB(List<DailyTopic> list) {
        if (v.aa(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.ggC = arrayList;
        int i = 0;
        Iterator<DailyTopic> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            DailyTopic next = it.next();
            if (next != null) {
                a aVar = new a();
                aVar.a(next);
                arrayList.add(aVar);
                i = i2 + 1;
                if (i == 4) {
                    break;
                }
            } else {
                i = i2;
            }
        }
        return eVar;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ggB;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String ggD;
        private String ggE;
        private String ggF;
        private String ggG;
        private String ggH;

        public void a(DailyTopic dailyTopic) {
            this.ggD = dailyTopic.topic_pic;
            this.ggE = dailyTopic.topic_title;
            this.ggF = dailyTopic.topic_abstract;
            this.ggG = dailyTopic.topic_url;
            this.ggH = dailyTopic.topic_rank_url;
        }

        public String bwj() {
            return this.ggD;
        }

        public String adL() {
            return this.ggE;
        }

        public String bwk() {
            return this.ggF;
        }

        public String agk() {
            return this.ggG;
        }

        public String bwl() {
            return this.ggH;
        }
    }
}
