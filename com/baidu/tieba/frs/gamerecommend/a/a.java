package com.baidu.tieba.frs.gamerecommend.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private Object[] jyR;
    private List<n> mData = new ArrayList();
    private List<bz> jyQ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jyQ.clear();
                this.jyR = new Object[aVar.jyD + 10];
            }
            if (!x.isEmpty(aVar.jyE)) {
                ArrayList arrayList = new ArrayList(aVar.jyE.size());
                for (bz bzVar : aVar.jyE) {
                    if (bzVar != null) {
                        arrayList.add(bzVar);
                    }
                }
                this.jyQ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cKJ();
            cKK();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!x.isEmpty(aVar.jyG)) {
            for (FeatureCardHot featureCardHot : aVar.jyG) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    Bj(featureCardHot.floor.intValue());
                    this.jyR[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!x.isEmpty(aVar.jyH)) {
            for (FeatureCardTopic featureCardTopic : aVar.jyH) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    Bj(featureCardTopic.floor.intValue());
                    this.jyR[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!x.isEmpty(aVar.jyI)) {
            for (b bVar : aVar.jyI) {
                if (bVar != null && bVar.isValid()) {
                    Bj(bVar.floor.intValue());
                    this.jyR[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!x.isEmpty(aVar.jyJ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jyJ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    Bj(featureCardCompetition.floor.intValue());
                    this.jyR[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!x.isEmpty(aVar.jyK)) {
            for (FeatureCardGod featureCardGod : aVar.jyK) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    Bj(featureCardGod.floor.intValue());
                    this.jyR[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!x.isEmpty(aVar.jyL)) {
            for (FeatureCardGame featureCardGame : aVar.jyL) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    Bj(featureCardGame.floor.intValue());
                    this.jyR[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void Bj(int i) {
        if (i >= this.jyR.length) {
            this.jyR = Arrays.copyOf(this.jyR, i + 1);
        }
    }

    private void cKJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jyQ.size()) {
                bz bzVar = this.jyQ.get(i2);
                if (bzVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bzVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bzVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cKK() {
        if (this.jyR != null && this.jyR.length > 0) {
            for (int i = 0; i < this.jyR.length; i++) {
                Object obj = this.jyR[i];
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
                        w wVar = new w();
                        wVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, wVar);
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
        gVar.a(aVar.jyF);
        this.mData.add(0, gVar);
    }

    public List<n> getData() {
        return this.mData;
    }
}
