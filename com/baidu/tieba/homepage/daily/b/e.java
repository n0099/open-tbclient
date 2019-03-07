package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fIl = BdUniqueId.gen();
    public List<a> fIm;

    public static e cw(List<DailyTopic> list) {
        if (v.T(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.fIm = arrayList;
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
        return fIl;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String fIn;
        private String fIo;
        private String fIp;
        private String fIq;
        private String fIr;

        public void a(DailyTopic dailyTopic) {
            this.fIn = dailyTopic.topic_pic;
            this.fIo = dailyTopic.topic_title;
            this.fIp = dailyTopic.topic_abstract;
            this.fIq = dailyTopic.topic_url;
            this.fIr = dailyTopic.topic_rank_url;
        }

        public String blJ() {
            return this.fIn;
        }

        public String Ya() {
            return this.fIo;
        }

        public String blK() {
            return this.fIp;
        }

        public String aaz() {
            return this.fIq;
        }

        public String blL() {
            return this.fIr;
        }
    }
}
