package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfY = BdUniqueId.gen();
    public List<a> gfZ;

    public static e cO(List<DailyTopic> list) {
        if (v.isEmpty(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.gfZ = arrayList;
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
        return gfY;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String gga;
        private String ggb;
        private String ggc;
        private String ggd;
        private String gge;

        public void a(DailyTopic dailyTopic) {
            this.gga = dailyTopic.topic_pic;
            this.ggb = dailyTopic.topic_title;
            this.ggc = dailyTopic.topic_abstract;
            this.ggd = dailyTopic.topic_url;
            this.gge = dailyTopic.topic_rank_url;
        }

        public String bto() {
            return this.gga;
        }

        public String ahP() {
            return this.ggb;
        }

        public String btp() {
            return this.ggc;
        }

        public String akn() {
            return this.ggd;
        }

        public String btq() {
            return this.gge;
        }
    }
}
