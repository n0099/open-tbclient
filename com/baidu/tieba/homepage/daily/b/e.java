package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fHY = BdUniqueId.gen();
    public List<a> fHZ;

    public static e ct(List<DailyTopic> list) {
        if (v.T(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.fHZ = arrayList;
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
        return fHY;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String fIa;
        private String fIb;
        private String fIc;
        private String fId;
        private String fIe;

        public void a(DailyTopic dailyTopic) {
            this.fIa = dailyTopic.topic_pic;
            this.fIb = dailyTopic.topic_title;
            this.fIc = dailyTopic.topic_abstract;
            this.fId = dailyTopic.topic_url;
            this.fIe = dailyTopic.topic_rank_url;
        }

        public String blG() {
            return this.fIa;
        }

        public String XX() {
            return this.fIb;
        }

        public String blH() {
            return this.fIc;
        }

        public String aaw() {
            return this.fId;
        }

        public String blI() {
            return this.fIe;
        }
    }
}
