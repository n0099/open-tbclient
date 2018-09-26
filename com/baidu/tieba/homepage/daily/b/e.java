package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ecf = BdUniqueId.gen();
    public List<a> ecg;

    public static e bR(List<DailyTopic> list) {
        if (v.z(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.ecg = arrayList;
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
        return ecf;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String dTs;
        private String ech;
        private String eci;
        private String ecj;
        private String eck;

        public void a(DailyTopic dailyTopic) {
            this.ech = dailyTopic.topic_pic;
            this.dTs = dailyTopic.topic_title;
            this.eci = dailyTopic.topic_abstract;
            this.ecj = dailyTopic.topic_url;
            this.eck = dailyTopic.topic_rank_url;
        }

        public String aFN() {
            return this.ech;
        }

        public String vE() {
            return this.dTs;
        }

        public String aFO() {
            return this.eci;
        }

        public String xM() {
            return this.ecj;
        }

        public String aFP() {
            return this.eck;
        }
    }
}
