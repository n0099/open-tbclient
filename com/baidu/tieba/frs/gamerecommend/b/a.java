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
    private Object[] ijL;
    private List<q> mData = new ArrayList();
    private List<bw> ijK = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.ijK.clear();
                this.ijL = new Object[aVar.ijx + 10];
            }
            if (!y.isEmpty(aVar.ijy)) {
                ArrayList arrayList = new ArrayList(aVar.ijy.size());
                for (bw bwVar : aVar.ijy) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.ijK.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cqA();
            cqB();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.ijA)) {
            for (FeatureCardHot featureCardHot : aVar.ijA) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    ya(featureCardHot.floor.intValue());
                    this.ijL[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.ijB)) {
            for (FeatureCardTopic featureCardTopic : aVar.ijB) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    ya(featureCardTopic.floor.intValue());
                    this.ijL[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.ijC)) {
            for (b bVar : aVar.ijC) {
                if (bVar != null && bVar.isValid()) {
                    ya(bVar.floor.intValue());
                    this.ijL[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.ijD)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.ijD) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    ya(featureCardCompetition.floor.intValue());
                    this.ijL[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.ijE)) {
            for (FeatureCardGod featureCardGod : aVar.ijE) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    ya(featureCardGod.floor.intValue());
                    this.ijL[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.ijF)) {
            for (FeatureCardGame featureCardGame : aVar.ijF) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    ya(featureCardGame.floor.intValue());
                    this.ijL[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void ya(int i) {
        if (i >= this.ijL.length) {
            this.ijL = Arrays.copyOf(this.ijL, i + 1);
        }
    }

    private void cqA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ijK.size()) {
                bw bwVar = this.ijK.get(i2);
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

    private void cqB() {
        if (this.ijL != null && this.ijL.length > 0) {
            for (int i = 0; i < this.ijL.length; i++) {
                Object obj = this.ijL[i];
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
        gVar.a(aVar.ijz);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
