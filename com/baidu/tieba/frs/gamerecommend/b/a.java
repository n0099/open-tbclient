package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
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
    private Object[] fHC;
    private List<m> mData = new ArrayList();
    private List<bg> fHB = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fHB.clear();
                this.fHC = new Object[aVar.fHo + 10];
            }
            if (!v.aa(aVar.fHp)) {
                ArrayList arrayList = new ArrayList(aVar.fHp.size());
                for (bg bgVar : aVar.fHp) {
                    if (bgVar != null) {
                        arrayList.add(bgVar);
                    }
                }
                this.fHB.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bpN();
            bpO();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.aa(aVar.fHr)) {
            for (FeatureCardHot featureCardHot : aVar.fHr) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    sk(featureCardHot.floor.intValue());
                    this.fHC[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.aa(aVar.fHs)) {
            for (FeatureCardTopic featureCardTopic : aVar.fHs) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    sk(featureCardTopic.floor.intValue());
                    this.fHC[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.aa(aVar.fHt)) {
            for (b bVar : aVar.fHt) {
                if (bVar != null && bVar.isValid()) {
                    sk(bVar.floor.intValue());
                    this.fHC[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.aa(aVar.fHu)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fHu) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    sk(featureCardCompetition.floor.intValue());
                    this.fHC[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.aa(aVar.fHv)) {
            for (FeatureCardGod featureCardGod : aVar.fHv) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    sk(featureCardGod.floor.intValue());
                    this.fHC[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.aa(aVar.fHw)) {
            for (FeatureCardGame featureCardGame : aVar.fHw) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    sk(featureCardGame.floor.intValue());
                    this.fHC[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void sk(int i) {
        if (i >= this.fHC.length) {
            this.fHC = Arrays.copyOf(this.fHC, i + 1);
        }
    }

    private void bpN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fHB.size()) {
                bg bgVar = this.fHB.get(i2);
                if (bgVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bgVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bgVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bpO() {
        if (this.fHC != null && this.fHC.length > 0) {
            for (int i = 0; i < this.fHC.length; i++) {
                Object obj = this.fHC[i];
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
        gVar.a(aVar.fHq);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
