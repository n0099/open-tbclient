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
    private Object[] gCg;
    private List<m> mData = new ArrayList();
    private List<bj> gCf = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.gCf.clear();
                this.gCg = new Object[aVar.gBS + 10];
            }
            if (!v.isEmpty(aVar.gBT)) {
                ArrayList arrayList = new ArrayList(aVar.gBT.size());
                for (bj bjVar : aVar.gBT) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.gCf.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bHQ();
            bHR();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.gBV)) {
            for (FeatureCardHot featureCardHot : aVar.gBV) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    tz(featureCardHot.floor.intValue());
                    this.gCg[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.gBW)) {
            for (FeatureCardTopic featureCardTopic : aVar.gBW) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    tz(featureCardTopic.floor.intValue());
                    this.gCg[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.gBX)) {
            for (b bVar : aVar.gBX) {
                if (bVar != null && bVar.isValid()) {
                    tz(bVar.floor.intValue());
                    this.gCg[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.gBY)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.gBY) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    tz(featureCardCompetition.floor.intValue());
                    this.gCg[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.gBZ)) {
            for (FeatureCardGod featureCardGod : aVar.gBZ) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    tz(featureCardGod.floor.intValue());
                    this.gCg[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.gCa)) {
            for (FeatureCardGame featureCardGame : aVar.gCa) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    tz(featureCardGame.floor.intValue());
                    this.gCg[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void tz(int i) {
        if (i >= this.gCg.length) {
            this.gCg = Arrays.copyOf(this.gCg, i + 1);
        }
    }

    private void bHQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCf.size()) {
                bj bjVar = this.gCf.get(i2);
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

    private void bHR() {
        if (this.gCg != null && this.gCg.length > 0) {
            for (int i = 0; i < this.gCg.length; i++) {
                Object obj = this.gCg[i];
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
        gVar.a(aVar.gBU);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
