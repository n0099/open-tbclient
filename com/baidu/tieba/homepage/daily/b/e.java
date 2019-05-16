package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fYT = BdUniqueId.gen();
    public List<a> fYU;

    public static e cB(List<DailyTopic> list) {
        if (v.aa(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.fYU = arrayList;
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
        return fYT;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String fYV;
        private String fYW;
        private String fYX;
        private String fYY;
        private String fYZ;

        public void a(DailyTopic dailyTopic) {
            this.fYV = dailyTopic.topic_pic;
            this.fYW = dailyTopic.topic_title;
            this.fYX = dailyTopic.topic_abstract;
            this.fYY = dailyTopic.topic_url;
            this.fYZ = dailyTopic.topic_rank_url;
        }

        public String btc() {
            return this.fYV;
        }

        public String acE() {
            return this.fYW;
        }

        public String btd() {
            return this.fYX;
        }

        public String afd() {
            return this.fYY;
        }

        public String bte() {
            return this.fYZ;
        }
    }
}
