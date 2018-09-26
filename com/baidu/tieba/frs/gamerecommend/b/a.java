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
    private Object[] dFR;
    private List<h> mData = new ArrayList();
    private List<bb> dFQ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dFQ.clear();
                this.dFR = new Object[aVar.dFD + 10];
            }
            if (!v.z(aVar.dFE)) {
                ArrayList arrayList = new ArrayList(aVar.dFE.size());
                for (bb bbVar : aVar.dFE) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dFQ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aAq();
            aAr();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.z(aVar.dFG)) {
            for (FeatureCardHot featureCardHot : aVar.dFG) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    lI(featureCardHot.floor.intValue());
                    this.dFR[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.z(aVar.dFH)) {
            for (FeatureCardTopic featureCardTopic : aVar.dFH) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    lI(featureCardTopic.floor.intValue());
                    this.dFR[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.z(aVar.dFI)) {
            for (b bVar : aVar.dFI) {
                if (bVar != null && bVar.isValid()) {
                    lI(bVar.floor.intValue());
                    this.dFR[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.z(aVar.dFJ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dFJ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    lI(featureCardCompetition.floor.intValue());
                    this.dFR[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.z(aVar.dFK)) {
            for (FeatureCardGod featureCardGod : aVar.dFK) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    lI(featureCardGod.floor.intValue());
                    this.dFR[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.z(aVar.dFL)) {
            for (FeatureCardGame featureCardGame : aVar.dFL) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    lI(featureCardGame.floor.intValue());
                    this.dFR[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void lI(int i) {
        if (i >= this.dFR.length) {
            this.dFR = Arrays.copyOf(this.dFR, i + 1);
        }
    }

    private void aAq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dFQ.size()) {
                bb bbVar = this.dFQ.get(i2);
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

    private void aAr() {
        if (this.dFR != null && this.dFR.length > 0) {
            for (int i = 0; i < this.dFR.length; i++) {
                Object obj = this.dFR[i];
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
        gVar.a(aVar.dFF);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
