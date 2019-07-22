package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gdT = BdUniqueId.gen();
    public List<a> gdU;

    public static e cC(List<DailyTopic> list) {
        if (v.aa(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.gdU = arrayList;
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
        return gdT;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String gdV;
        private String gdW;
        private String gdX;
        private String gdY;
        private String gdZ;

        public void a(DailyTopic dailyTopic) {
            this.gdV = dailyTopic.topic_pic;
            this.gdW = dailyTopic.topic_title;
            this.gdX = dailyTopic.topic_abstract;
            this.gdY = dailyTopic.topic_url;
            this.gdZ = dailyTopic.topic_rank_url;
        }

        public String bvi() {
            return this.gdV;
        }

        public String adG() {
            return this.gdW;
        }

        public String bvj() {
            return this.gdX;
        }

        public String agf() {
            return this.gdY;
        }

        public String bvk() {
            return this.gdZ;
        }
    }
}
