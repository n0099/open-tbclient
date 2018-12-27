package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evf = BdUniqueId.gen();
    public List<a> evg;

    public static e ck(List<DailyTopic> list) {
        if (v.I(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.evg = arrayList;
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
        return evf;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String elZ;
        private String evh;
        private String evi;
        private String evj;
        private String evk;

        public void a(DailyTopic dailyTopic) {
            this.evh = dailyTopic.topic_pic;
            this.elZ = dailyTopic.topic_title;
            this.evi = dailyTopic.topic_abstract;
            this.evj = dailyTopic.topic_url;
            this.evk = dailyTopic.topic_rank_url;
        }

        public String aLj() {
            return this.evh;
        }

        public String yY() {
            return this.elZ;
        }

        public String aLk() {
            return this.evi;
        }

        public String Bg() {
            return this.evj;
        }

        public String aLl() {
            return this.evk;
        }
    }
}
