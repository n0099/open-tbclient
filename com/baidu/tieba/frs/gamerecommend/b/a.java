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
    private Object[] iFM;
    private List<q> mData = new ArrayList();
    private List<bw> iFL = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.iFL.clear();
                this.iFM = new Object[aVar.iFy + 10];
            }
            if (!y.isEmpty(aVar.iFz)) {
                ArrayList arrayList = new ArrayList(aVar.iFz.size());
                for (bw bwVar : aVar.iFz) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.iFL.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cxl();
            cxm();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.iFB)) {
            for (FeatureCardHot featureCardHot : aVar.iFB) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zf(featureCardHot.floor.intValue());
                    this.iFM[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.iFC)) {
            for (FeatureCardTopic featureCardTopic : aVar.iFC) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zf(featureCardTopic.floor.intValue());
                    this.iFM[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.iFD)) {
            for (b bVar : aVar.iFD) {
                if (bVar != null && bVar.isValid()) {
                    zf(bVar.floor.intValue());
                    this.iFM[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.iFE)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.iFE) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zf(featureCardCompetition.floor.intValue());
                    this.iFM[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.iFF)) {
            for (FeatureCardGod featureCardGod : aVar.iFF) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zf(featureCardGod.floor.intValue());
                    this.iFM[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.iFG)) {
            for (FeatureCardGame featureCardGame : aVar.iFG) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zf(featureCardGame.floor.intValue());
                    this.iFM[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zf(int i) {
        if (i >= this.iFM.length) {
            this.iFM = Arrays.copyOf(this.iFM, i + 1);
        }
    }

    private void cxl() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iFL.size()) {
                bw bwVar = this.iFL.get(i2);
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

    private void cxm() {
        if (this.iFM != null && this.iFM.length > 0) {
            for (int i = 0; i < this.iFM.length; i++) {
                Object obj = this.iFM[i];
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
        gVar.a(aVar.iFA);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
