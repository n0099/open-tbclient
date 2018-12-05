package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eso = BdUniqueId.gen();
    public List<a> esp;

    public static e cj(List<DailyTopic> list) {
        if (v.I(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.esp = arrayList;
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
        return eso;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String ejj;
        private String esq;
        private String esr;
        private String ess;
        private String est;

        public void a(DailyTopic dailyTopic) {
            this.esq = dailyTopic.topic_pic;
            this.ejj = dailyTopic.topic_title;
            this.esr = dailyTopic.topic_abstract;
            this.ess = dailyTopic.topic_url;
            this.est = dailyTopic.topic_rank_url;
        }

        public String aKu() {
            return this.esq;
        }

        public String yY() {
            return this.ejj;
        }

        public String aKv() {
            return this.esr;
        }

        public String Bg() {
            return this.ess;
        }

        public String aKw() {
            return this.est;
        }
    }
}
