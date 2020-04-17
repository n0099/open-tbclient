package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] hmO;
    private List<m> mData = new ArrayList();
    private List<bj> hmN = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hmN.clear();
                this.hmO = new Object[aVar.hmA + 10];
            }
            if (!v.isEmpty(aVar.hmB)) {
                ArrayList arrayList = new ArrayList(aVar.hmB.size());
                for (bj bjVar : aVar.hmB) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.hmN.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bSE();
            bSF();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.hmD)) {
            for (FeatureCardHot featureCardHot : aVar.hmD) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    ud(featureCardHot.floor.intValue());
                    this.hmO[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.hmE)) {
            for (FeatureCardTopic featureCardTopic : aVar.hmE) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    ud(featureCardTopic.floor.intValue());
                    this.hmO[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.hmF)) {
            for (b bVar : aVar.hmF) {
                if (bVar != null && bVar.isValid()) {
                    ud(bVar.floor.intValue());
                    this.hmO[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.hmG)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hmG) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    ud(featureCardCompetition.floor.intValue());
                    this.hmO[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.hmH)) {
            for (FeatureCardGod featureCardGod : aVar.hmH) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    ud(featureCardGod.floor.intValue());
                    this.hmO[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.hmI)) {
            for (FeatureCardGame featureCardGame : aVar.hmI) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    ud(featureCardGame.floor.intValue());
                    this.hmO[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void ud(int i) {
        if (i >= this.hmO.length) {
            this.hmO = Arrays.copyOf(this.hmO, i + 1);
        }
    }

    private void bSE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hmN.size()) {
                bj bjVar = this.hmN.get(i2);
                if (bjVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bjVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bjVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bSF() {
        if (this.hmO != null && this.hmO.length > 0) {
            for (int i = 0; i < this.hmO.length; i++) {
                Object obj = this.hmO[i];
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
                        u uVar = new u();
                        uVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, uVar);
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
        gVar.a(aVar.hmC);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
