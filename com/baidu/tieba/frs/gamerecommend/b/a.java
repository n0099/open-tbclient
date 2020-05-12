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
    private Object[] hmU;
    private List<m> mData = new ArrayList();
    private List<bj> hmT = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hmT.clear();
                this.hmU = new Object[aVar.hmG + 10];
            }
            if (!v.isEmpty(aVar.hmH)) {
                ArrayList arrayList = new ArrayList(aVar.hmH.size());
                for (bj bjVar : aVar.hmH) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.hmT.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bSD();
            bSE();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.hmJ)) {
            for (FeatureCardHot featureCardHot : aVar.hmJ) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    ud(featureCardHot.floor.intValue());
                    this.hmU[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.hmK)) {
            for (FeatureCardTopic featureCardTopic : aVar.hmK) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    ud(featureCardTopic.floor.intValue());
                    this.hmU[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.hmL)) {
            for (b bVar : aVar.hmL) {
                if (bVar != null && bVar.isValid()) {
                    ud(bVar.floor.intValue());
                    this.hmU[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.hmM)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hmM) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    ud(featureCardCompetition.floor.intValue());
                    this.hmU[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.hmN)) {
            for (FeatureCardGod featureCardGod : aVar.hmN) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    ud(featureCardGod.floor.intValue());
                    this.hmU[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.hmO)) {
            for (FeatureCardGame featureCardGame : aVar.hmO) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    ud(featureCardGame.floor.intValue());
                    this.hmU[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void ud(int i) {
        if (i >= this.hmU.length) {
            this.hmU = Arrays.copyOf(this.hmU, i + 1);
        }
    }

    private void bSD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hmT.size()) {
                bj bjVar = this.hmT.get(i2);
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

    private void bSE() {
        if (this.hmU != null && this.hmU.length > 0) {
            for (int i = 0; i < this.hmU.length; i++) {
                Object obj = this.hmU[i];
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
        gVar.a(aVar.hmI);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
