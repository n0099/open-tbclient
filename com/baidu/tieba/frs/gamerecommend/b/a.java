package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.f.c;
import com.baidu.tieba.f.d;
import com.baidu.tieba.f.e;
import com.baidu.tieba.f.f;
import com.baidu.tieba.f.g;
import com.baidu.tieba.f.h;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private Object[] iYR;
    private List<q> mData = new ArrayList();
    private List<bx> iYQ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.iYQ.clear();
                this.iYR = new Object[aVar.iYD + 10];
            }
            if (!y.isEmpty(aVar.iYE)) {
                ArrayList arrayList = new ArrayList(aVar.iYE.size());
                for (bx bxVar : aVar.iYE) {
                    if (bxVar != null) {
                        arrayList.add(bxVar);
                    }
                }
                this.iYQ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cCx();
            cCy();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.iYG)) {
            for (FeatureCardHot featureCardHot : aVar.iYG) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    Aj(featureCardHot.floor.intValue());
                    this.iYR[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.iYH)) {
            for (FeatureCardTopic featureCardTopic : aVar.iYH) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    Aj(featureCardTopic.floor.intValue());
                    this.iYR[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.iYI)) {
            for (b bVar : aVar.iYI) {
                if (bVar != null && bVar.isValid()) {
                    Aj(bVar.floor.intValue());
                    this.iYR[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.iYJ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.iYJ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    Aj(featureCardCompetition.floor.intValue());
                    this.iYR[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.iYK)) {
            for (FeatureCardGod featureCardGod : aVar.iYK) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    Aj(featureCardGod.floor.intValue());
                    this.iYR[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.iYL)) {
            for (FeatureCardGame featureCardGame : aVar.iYL) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    Aj(featureCardGame.floor.intValue());
                    this.iYR[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void Aj(int i) {
        if (i >= this.iYR.length) {
            this.iYR = Arrays.copyOf(this.iYR, i + 1);
        }
    }

    private void cCx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iYQ.size()) {
                bx bxVar = this.iYQ.get(i2);
                if (bxVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.f.a aVar = new com.baidu.tieba.f.a();
                        aVar.setData(bxVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.f.b bVar = new com.baidu.tieba.f.b();
                        bVar.setData(bxVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cCy() {
        if (this.iYR != null && this.iYR.length > 0) {
            for (int i = 0; i < this.iYR.length; i++) {
                Object obj = this.iYR[i];
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
                        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
                        yVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, yVar);
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
        gVar.a(aVar.iYF);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
