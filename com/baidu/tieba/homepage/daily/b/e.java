package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evM = BdUniqueId.gen();
    public List<a> evN;

    public static e cl(List<DailyTopic> list) {
        if (v.I(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.evN = arrayList;
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
        return evM;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String emG;
        private String evO;
        private String evP;
        private String evQ;
        private String evR;

        public void a(DailyTopic dailyTopic) {
            this.evO = dailyTopic.topic_pic;
            this.emG = dailyTopic.topic_title;
            this.evP = dailyTopic.topic_abstract;
            this.evQ = dailyTopic.topic_url;
            this.evR = dailyTopic.topic_rank_url;
        }

        public String aLH() {
            return this.evO;
        }

        public String zl() {
            return this.emG;
        }

        public String aLI() {
            return this.evP;
        }

        public String Bt() {
            return this.evQ;
        }

        public String aLJ() {
            return this.evR;
        }
    }
}
