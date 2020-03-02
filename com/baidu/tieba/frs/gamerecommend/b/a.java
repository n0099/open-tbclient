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
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] gCi;
    private List<m> mData = new ArrayList();
    private List<bj> gCh = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.gCh.clear();
                this.gCi = new Object[aVar.gBU + 10];
            }
            if (!v.isEmpty(aVar.gBV)) {
                ArrayList arrayList = new ArrayList(aVar.gBV.size());
                for (bj bjVar : aVar.gBV) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.gCh.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bHS();
            bHT();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.gBX)) {
            for (FeatureCardHot featureCardHot : aVar.gBX) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    tz(featureCardHot.floor.intValue());
                    this.gCi[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.gBY)) {
            for (FeatureCardTopic featureCardTopic : aVar.gBY) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    tz(featureCardTopic.floor.intValue());
                    this.gCi[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.gBZ)) {
            for (b bVar : aVar.gBZ) {
                if (bVar != null && bVar.isValid()) {
                    tz(bVar.floor.intValue());
                    this.gCi[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.gCa)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.gCa) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    tz(featureCardCompetition.floor.intValue());
                    this.gCi[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.gCb)) {
            for (FeatureCardGod featureCardGod : aVar.gCb) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    tz(featureCardGod.floor.intValue());
                    this.gCi[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.gCc)) {
            for (FeatureCardGame featureCardGame : aVar.gCc) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    tz(featureCardGame.floor.intValue());
                    this.gCi[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void tz(int i) {
        if (i >= this.gCi.length) {
            this.gCi = Arrays.copyOf(this.gCi, i + 1);
        }
    }

    private void bHS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCh.size()) {
                bj bjVar = this.gCh.get(i2);
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

    private void bHT() {
        if (this.gCi != null && this.gCi.length > 0) {
            for (int i = 0; i < this.gCi.length; i++) {
                Object obj = this.gCi[i];
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
                        r rVar = new r();
                        rVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, rVar);
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
        gVar.a(aVar.gBW);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
