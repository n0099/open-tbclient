package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private Object[] ijR;
    private List<q> mData = new ArrayList();
    private List<bw> ijQ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.ijQ.clear();
                this.ijR = new Object[aVar.ijD + 10];
            }
            if (!y.isEmpty(aVar.ijE)) {
                ArrayList arrayList = new ArrayList(aVar.ijE.size());
                for (bw bwVar : aVar.ijE) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.ijQ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cqB();
            cqC();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.ijG)) {
            for (FeatureCardHot featureCardHot : aVar.ijG) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    ya(featureCardHot.floor.intValue());
                    this.ijR[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.ijH)) {
            for (FeatureCardTopic featureCardTopic : aVar.ijH) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    ya(featureCardTopic.floor.intValue());
                    this.ijR[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.ijI)) {
            for (b bVar : aVar.ijI) {
                if (bVar != null && bVar.isValid()) {
                    ya(bVar.floor.intValue());
                    this.ijR[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.ijJ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.ijJ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    ya(featureCardCompetition.floor.intValue());
                    this.ijR[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.ijK)) {
            for (FeatureCardGod featureCardGod : aVar.ijK) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    ya(featureCardGod.floor.intValue());
                    this.ijR[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.ijL)) {
            for (FeatureCardGame featureCardGame : aVar.ijL) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    ya(featureCardGame.floor.intValue());
                    this.ijR[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void ya(int i) {
        if (i >= this.ijR.length) {
            this.ijR = Arrays.copyOf(this.ijR, i + 1);
        }
    }

    private void cqB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ijQ.size()) {
                bw bwVar = this.ijQ.get(i2);
                if (bwVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bwVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bwVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cqC() {
        if (this.ijR != null && this.ijR.length > 0) {
            for (int i = 0; i < this.ijR.length; i++) {
                Object obj = this.ijR[i];
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
        gVar.a(aVar.ijF);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
