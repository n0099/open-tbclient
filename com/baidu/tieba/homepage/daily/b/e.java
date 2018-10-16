package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejY = BdUniqueId.gen();
    public List<a> ejZ;

    public static e ch(List<DailyTopic> list) {
        if (v.J(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.ejZ = arrayList;
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

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ejY;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String ebl;
        private String eka;
        private String ekb;
        private String ekc;
        private String ekd;

        public void a(DailyTopic dailyTopic) {
            this.eka = dailyTopic.topic_pic;
            this.ebl = dailyTopic.topic_title;
            this.ekb = dailyTopic.topic_abstract;
            this.ekc = dailyTopic.topic_url;
            this.ekd = dailyTopic.topic_rank_url;
        }

        public String aJf() {
            return this.eka;
        }

        public String xN() {
            return this.ebl;
        }

        public String aJg() {
            return this.ekb;
        }

        public String zV() {
            return this.ekc;
        }

        public String aJh() {
            return this.ekd;
        }
    }
}
