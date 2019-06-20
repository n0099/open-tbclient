package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYW = BdUniqueId.gen();
    public List<a> fYX;

    public static e cB(List<DailyTopic> list) {
        if (v.aa(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.fYX = arrayList;
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
        return fYW;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String fYY;
        private String fYZ;
        private String fZa;
        private String fZb;
        private String fZc;

        public void a(DailyTopic dailyTopic) {
            this.fYY = dailyTopic.topic_pic;
            this.fYZ = dailyTopic.topic_title;
            this.fZa = dailyTopic.topic_abstract;
            this.fZb = dailyTopic.topic_url;
            this.fZc = dailyTopic.topic_rank_url;
        }

        public String btg() {
            return this.fYY;
        }

        public String acE() {
            return this.fYZ;
        }

        public String bth() {
            return this.fZa;
        }

        public String afd() {
            return this.fZb;
        }

        public String bti() {
            return this.fZc;
        }
    }
}
