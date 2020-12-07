package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private Object[] jmr;
    private List<q> mData = new ArrayList();
    private List<by> jmq = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jmq.clear();
                this.jmr = new Object[aVar.jmc + 10];
            }
            if (!y.isEmpty(aVar.jmd)) {
                ArrayList arrayList = new ArrayList(aVar.jmd.size());
                for (by byVar : aVar.jmd) {
                    if (byVar != null) {
                        arrayList.add(byVar);
                    }
                }
                this.jmq.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cHI();
            cHJ();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.jmf)) {
            for (FeatureCardHot featureCardHot : aVar.jmf) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    AX(featureCardHot.floor.intValue());
                    this.jmr[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.jmg)) {
            for (FeatureCardTopic featureCardTopic : aVar.jmg) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    AX(featureCardTopic.floor.intValue());
                    this.jmr[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.jmh)) {
            for (b bVar : aVar.jmh) {
                if (bVar != null && bVar.isValid()) {
                    AX(bVar.floor.intValue());
                    this.jmr[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.jmi)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jmi) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    AX(featureCardCompetition.floor.intValue());
                    this.jmr[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.jmj)) {
            for (FeatureCardGod featureCardGod : aVar.jmj) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    AX(featureCardGod.floor.intValue());
                    this.jmr[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.jmk)) {
            for (FeatureCardGame featureCardGame : aVar.jmk) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    AX(featureCardGame.floor.intValue());
                    this.jmr[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void AX(int i) {
        if (i >= this.jmr.length) {
            this.jmr = Arrays.copyOf(this.jmr, i + 1);
        }
    }

    private void cHI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jmq.size()) {
                by byVar = this.jmq.get(i2);
                if (byVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.f.a aVar = new com.baidu.tieba.f.a();
                        aVar.setData(byVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.f.b bVar = new com.baidu.tieba.f.b();
                        bVar.setData(byVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cHJ() {
        if (this.jmr != null && this.jmr.length > 0) {
            for (int i = 0; i < this.jmr.length; i++) {
                Object obj = this.jmr[i];
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
                        x xVar = new x();
                        xVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, xVar);
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
        gVar.a(aVar.jme);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
