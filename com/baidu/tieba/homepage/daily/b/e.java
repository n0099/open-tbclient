package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId geK = BdUniqueId.gen();
    public List<a> geL;

    public static e cB(List<DailyTopic> list) {
        if (v.aa(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.geL = arrayList;
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
        return geK;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String geM;
        private String geN;
        private String geO;
        private String geP;
        private String geQ;

        public void a(DailyTopic dailyTopic) {
            this.geM = dailyTopic.topic_pic;
            this.geN = dailyTopic.topic_title;
            this.geO = dailyTopic.topic_abstract;
            this.geP = dailyTopic.topic_url;
            this.geQ = dailyTopic.topic_rank_url;
        }

        public String bvv() {
            return this.geM;
        }

        public String adH() {
            return this.geN;
        }

        public String bvw() {
            return this.geO;
        }

        public String agg() {
            return this.geP;
        }

        public String bvx() {
            return this.geQ;
        }
    }
}
