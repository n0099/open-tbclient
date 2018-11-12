package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId elt = BdUniqueId.gen();
    public List<a> elu;

    public static e cf(List<DailyTopic> list) {
        if (v.I(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.elu = arrayList;
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
        return elt;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String ecG;
        private String elv;
        private String elw;
        private String elx;
        private String ely;

        public void a(DailyTopic dailyTopic) {
            this.elv = dailyTopic.topic_pic;
            this.ecG = dailyTopic.topic_title;
            this.elw = dailyTopic.topic_abstract;
            this.elx = dailyTopic.topic_url;
            this.ely = dailyTopic.topic_rank_url;
        }

        public String aID() {
            return this.elv;
        }

        public String xU() {
            return this.ecG;
        }

        public String aIE() {
            return this.elw;
        }

        public String Ac() {
            return this.elx;
        }

        public String aIF() {
            return this.ely;
        }
    }
}
