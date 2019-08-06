package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.e.c;
import com.baidu.tieba.e.d;
import com.baidu.tieba.e.e;
import com.baidu.tieba.e.f;
import com.baidu.tieba.e.g;
import com.baidu.tieba.e.h;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.b;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private Object[] fIq;
    private List<m> mData = new ArrayList();
    private List<bh> fIp = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fIp.clear();
                this.fIq = new Object[aVar.fIc + 10];
            }
            if (!v.aa(aVar.fId)) {
                ArrayList arrayList = new ArrayList(aVar.fId.size());
                for (bh bhVar : aVar.fId) {
                    if (bhVar != null) {
                        arrayList.add(bhVar);
                    }
                }
                this.fIp.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bqa();
            bqb();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.aa(aVar.fIf)) {
            for (FeatureCardHot featureCardHot : aVar.fIf) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    sm(featureCardHot.floor.intValue());
                    this.fIq[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.aa(aVar.fIg)) {
            for (FeatureCardTopic featureCardTopic : aVar.fIg) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    sm(featureCardTopic.floor.intValue());
                    this.fIq[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.aa(aVar.fIh)) {
            for (b bVar : aVar.fIh) {
                if (bVar != null && bVar.isValid()) {
                    sm(bVar.floor.intValue());
                    this.fIq[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.aa(aVar.fIi)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fIi) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    sm(featureCardCompetition.floor.intValue());
                    this.fIq[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.aa(aVar.fIj)) {
            for (FeatureCardGod featureCardGod : aVar.fIj) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    sm(featureCardGod.floor.intValue());
                    this.fIq[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.aa(aVar.fIk)) {
            for (FeatureCardGame featureCardGame : aVar.fIk) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    sm(featureCardGame.floor.intValue());
                    this.fIq[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void sm(int i) {
        if (i >= this.fIq.length) {
            this.fIq = Arrays.copyOf(this.fIq, i + 1);
        }
    }

    private void bqa() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fIp.size()) {
                bh bhVar = this.fIp.get(i2);
                if (bhVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bhVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bhVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bqb() {
        if (this.fIq != null && this.fIq.length > 0) {
            for (int i = 0; i < this.fIq.length; i++) {
                Object obj = this.fIq[i];
                if (obj != null) {
                    int i2 = i - 1;
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 >= this.mData.size()) {
                        i2 = this.mData.size();
                    }
                    if (obj instanceof FeatureCardHot) {
                        e eVar = new e();
                        eVar.a((FeatureCardHot) obj);
                        this.mData.add(i2, eVar);
                    } else if (obj instanceof FeatureCardTopic) {
                        h hVar = new h();
                        hVar.a((FeatureCardTopic) obj);
                        this.mData.add(i2, hVar);
                    } else if (obj instanceof b) {
                        d dVar = new d();
                        dVar.a((b) obj);
                        this.mData.add(i2, dVar);
                    } else if (obj instanceof FeatureCardCompetition) {
                        c cVar = new c();
                        cVar.a((FeatureCardCompetition) obj);
                        this.mData.add(i2, cVar);
                    } else if (obj instanceof FeatureCardGod) {
                        q qVar = new q();
                        qVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, qVar);
                    } else if (obj instanceof FeatureCardGame) {
                        f fVar = new f();
                        fVar.a((FeatureCardGame) obj);
                        this.mData.add(i2, fVar);
                    }
                }
            }
        }
    }

    private void b(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        g gVar = new g();
        gVar.a(aVar.fIe);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
