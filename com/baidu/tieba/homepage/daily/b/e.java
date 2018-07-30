package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUR = BdUniqueId.gen();
    public List<a> dUS;

    public static e bQ(List<DailyTopic> list) {
        if (w.z(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.dUS = arrayList;
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
        return dUR;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String dMe;
        private String dUT;
        private String dUU;
        private String dUV;
        private String dUW;

        public void a(DailyTopic dailyTopic) {
            this.dUT = dailyTopic.topic_pic;
            this.dMe = dailyTopic.topic_title;
            this.dUU = dailyTopic.topic_abstract;
            this.dUV = dailyTopic.topic_url;
            this.dUW = dailyTopic.topic_rank_url;
        }

        public String aDD() {
            return this.dUT;
        }

        public String uC() {
            return this.dMe;
        }

        public String aDE() {
            return this.dUU;
        }

        public String wG() {
            return this.dUV;
        }

        public String aDF() {
            return this.dUW;
        }
    }
}
