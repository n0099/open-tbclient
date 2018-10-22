package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.e.c;
import com.baidu.tieba.e.d;
import com.baidu.tieba.e.e;
import com.baidu.tieba.e.f;
import com.baidu.tieba.e.g;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.b;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Object[] dNQ;
    private List<h> mData = new ArrayList();
    private List<bb> dNP = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dNP.clear();
                this.dNQ = new Object[aVar.dNC + 10];
            }
            if (!v.J(aVar.dND)) {
                ArrayList arrayList = new ArrayList(aVar.dND.size());
                for (bb bbVar : aVar.dND) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dNP.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aDK();
            aDL();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.J(aVar.dNF)) {
            for (FeatureCardHot featureCardHot : aVar.dNF) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    mg(featureCardHot.floor.intValue());
                    this.dNQ[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.J(aVar.dNG)) {
            for (FeatureCardTopic featureCardTopic : aVar.dNG) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    mg(featureCardTopic.floor.intValue());
                    this.dNQ[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.J(aVar.dNH)) {
            for (b bVar : aVar.dNH) {
                if (bVar != null && bVar.isValid()) {
                    mg(bVar.floor.intValue());
                    this.dNQ[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.J(aVar.dNI)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dNI) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    mg(featureCardCompetition.floor.intValue());
                    this.dNQ[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.J(aVar.dNJ)) {
            for (FeatureCardGod featureCardGod : aVar.dNJ) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    mg(featureCardGod.floor.intValue());
                    this.dNQ[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.J(aVar.dNK)) {
            for (FeatureCardGame featureCardGame : aVar.dNK) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    mg(featureCardGame.floor.intValue());
                    this.dNQ[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void mg(int i) {
        if (i >= this.dNQ.length) {
            this.dNQ = Arrays.copyOf(this.dNQ, i + 1);
        }
    }

    private void aDK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dNP.size()) {
                bb bbVar = this.dNP.get(i2);
                if (bbVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bbVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bbVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void aDL() {
        if (this.dNQ != null && this.dNQ.length > 0) {
            for (int i = 0; i < this.dNQ.length; i++) {
                Object obj = this.dNQ[i];
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
                        com.baidu.tieba.e.h hVar = new com.baidu.tieba.e.h();
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
        gVar.a(aVar.dNE);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
