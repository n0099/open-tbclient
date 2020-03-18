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
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] gDs;
    private List<m> mData = new ArrayList();
    private List<bj> gDr = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.gDr.clear();
                this.gDs = new Object[aVar.gDe + 10];
            }
            if (!v.isEmpty(aVar.gDf)) {
                ArrayList arrayList = new ArrayList(aVar.gDf.size());
                for (bj bjVar : aVar.gDf) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.gDr.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bIf();
            bIg();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.gDh)) {
            for (FeatureCardHot featureCardHot : aVar.gDh) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    tF(featureCardHot.floor.intValue());
                    this.gDs[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.gDi)) {
            for (FeatureCardTopic featureCardTopic : aVar.gDi) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    tF(featureCardTopic.floor.intValue());
                    this.gDs[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.gDj)) {
            for (b bVar : aVar.gDj) {
                if (bVar != null && bVar.isValid()) {
                    tF(bVar.floor.intValue());
                    this.gDs[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.gDk)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.gDk) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    tF(featureCardCompetition.floor.intValue());
                    this.gDs[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.gDl)) {
            for (FeatureCardGod featureCardGod : aVar.gDl) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    tF(featureCardGod.floor.intValue());
                    this.gDs[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.gDm)) {
            for (FeatureCardGame featureCardGame : aVar.gDm) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    tF(featureCardGame.floor.intValue());
                    this.gDs[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void tF(int i) {
        if (i >= this.gDs.length) {
            this.gDs = Arrays.copyOf(this.gDs, i + 1);
        }
    }

    private void bIf() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gDr.size()) {
                bj bjVar = this.gDr.get(i2);
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

    private void bIg() {
        if (this.gDs != null && this.gDs.length > 0) {
            for (int i = 0; i < this.gDs.length; i++) {
                Object obj = this.gDs[i];
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
                        s sVar = new s();
                        sVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, sVar);
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
        gVar.a(aVar.gDg);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
