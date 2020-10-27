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
/* loaded from: classes22.dex */
public class a {
    private Object[] iSi;
    private List<q> mData = new ArrayList();
    private List<bw> iSh = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.iSh.clear();
                this.iSi = new Object[aVar.iRU + 10];
            }
            if (!y.isEmpty(aVar.iRV)) {
                ArrayList arrayList = new ArrayList(aVar.iRV.size());
                for (bw bwVar : aVar.iRV) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.iSh.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cAs();
            cAt();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.iRX)) {
            for (FeatureCardHot featureCardHot : aVar.iRX) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zy(featureCardHot.floor.intValue());
                    this.iSi[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.iRY)) {
            for (FeatureCardTopic featureCardTopic : aVar.iRY) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zy(featureCardTopic.floor.intValue());
                    this.iSi[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.iRZ)) {
            for (b bVar : aVar.iRZ) {
                if (bVar != null && bVar.isValid()) {
                    zy(bVar.floor.intValue());
                    this.iSi[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.iSa)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.iSa) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zy(featureCardCompetition.floor.intValue());
                    this.iSi[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.iSb)) {
            for (FeatureCardGod featureCardGod : aVar.iSb) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zy(featureCardGod.floor.intValue());
                    this.iSi[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.iSc)) {
            for (FeatureCardGame featureCardGame : aVar.iSc) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zy(featureCardGame.floor.intValue());
                    this.iSi[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zy(int i) {
        if (i >= this.iSi.length) {
            this.iSi = Arrays.copyOf(this.iSi, i + 1);
        }
    }

    private void cAs() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iSh.size()) {
                bw bwVar = this.iSh.get(i2);
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

    private void cAt() {
        if (this.iSi != null && this.iSi.length > 0) {
            for (int i = 0; i < this.iSi.length; i++) {
                Object obj = this.iSi[i];
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
        gVar.a(aVar.iRW);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
