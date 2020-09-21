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
/* loaded from: classes21.dex */
public class a {
    private Object[] iqT;
    private List<q> mData = new ArrayList();
    private List<bw> iqS = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.iqS.clear();
                this.iqT = new Object[aVar.iqF + 10];
            }
            if (!y.isEmpty(aVar.iqG)) {
                ArrayList arrayList = new ArrayList(aVar.iqG.size());
                for (bw bwVar : aVar.iqG) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.iqS.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            ctO();
            ctP();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.iqI)) {
            for (FeatureCardHot featureCardHot : aVar.iqI) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    yz(featureCardHot.floor.intValue());
                    this.iqT[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.iqJ)) {
            for (FeatureCardTopic featureCardTopic : aVar.iqJ) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    yz(featureCardTopic.floor.intValue());
                    this.iqT[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.iqK)) {
            for (b bVar : aVar.iqK) {
                if (bVar != null && bVar.isValid()) {
                    yz(bVar.floor.intValue());
                    this.iqT[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.iqL)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.iqL) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    yz(featureCardCompetition.floor.intValue());
                    this.iqT[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.iqM)) {
            for (FeatureCardGod featureCardGod : aVar.iqM) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    yz(featureCardGod.floor.intValue());
                    this.iqT[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.iqN)) {
            for (FeatureCardGame featureCardGame : aVar.iqN) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    yz(featureCardGame.floor.intValue());
                    this.iqT[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void yz(int i) {
        if (i >= this.iqT.length) {
            this.iqT = Arrays.copyOf(this.iqT, i + 1);
        }
    }

    private void ctO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iqS.size()) {
                bw bwVar = this.iqS.get(i2);
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

    private void ctP() {
        if (this.iqT != null && this.iqT.length > 0) {
            for (int i = 0; i < this.iqT.length; i++) {
                Object obj = this.iqT[i];
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
        gVar.a(aVar.iqH);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
