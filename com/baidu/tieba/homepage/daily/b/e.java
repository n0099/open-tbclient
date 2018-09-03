package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUM = BdUniqueId.gen();
    public List<a> dUN;

    public static e bQ(List<DailyTopic> list) {
        if (w.z(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.dUN = arrayList;
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
        return dUM;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String dMa;
        private String dUO;
        private String dUP;
        private String dUQ;
        private String dUR;

        public void a(DailyTopic dailyTopic) {
            this.dUO = dailyTopic.topic_pic;
            this.dMa = dailyTopic.topic_title;
            this.dUP = dailyTopic.topic_abstract;
            this.dUQ = dailyTopic.topic_url;
            this.dUR = dailyTopic.topic_rank_url;
        }

        public String aDA() {
            return this.dUO;
        }

        public String uB() {
            return this.dMa;
        }

        public String aDB() {
            return this.dUP;
        }

        public String wF() {
            return this.dUQ;
        }

        public String aDC() {
            return this.dUR;
        }
    }
}
