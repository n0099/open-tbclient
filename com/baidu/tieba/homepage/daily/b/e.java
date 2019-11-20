package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DailyTopic;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfh = BdUniqueId.gen();
    public List<a> gfi;

    public static e cO(List<DailyTopic> list) {
        if (v.isEmpty(list)) {
            return null;
        }
        e eVar = new e();
        ArrayList arrayList = new ArrayList();
        eVar.gfi = arrayList;
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
        return gfh;
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String gfj;
        private String gfk;
        private String gfl;
        private String gfm;
        private String gfn;

        public void a(DailyTopic dailyTopic) {
            this.gfj = dailyTopic.topic_pic;
            this.gfk = dailyTopic.topic_title;
            this.gfl = dailyTopic.topic_abstract;
            this.gfm = dailyTopic.topic_url;
            this.gfn = dailyTopic.topic_rank_url;
        }

        public String btm() {
            return this.gfj;
        }

        public String ahN() {
            return this.gfk;
        }

        public String btn() {
            return this.gfl;
        }

        public String akl() {
            return this.gfm;
        }

        public String bto() {
            return this.gfn;
        }
    }
}
