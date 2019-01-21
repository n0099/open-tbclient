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
    private Object[] dYU;
    private List<h> mData = new ArrayList();
    private List<bb> dYT = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dYT.clear();
                this.dYU = new Object[aVar.dYG + 10];
            }
            if (!v.I(aVar.dYH)) {
                ArrayList arrayList = new ArrayList(aVar.dYH.size());
                for (bb bbVar : aVar.dYH) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dYT.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aGc();
            aGd();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.I(aVar.dYJ)) {
            for (FeatureCardHot featureCardHot : aVar.dYJ) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    nb(featureCardHot.floor.intValue());
                    this.dYU[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.I(aVar.dYK)) {
            for (FeatureCardTopic featureCardTopic : aVar.dYK) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    nb(featureCardTopic.floor.intValue());
                    this.dYU[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.I(aVar.dYL)) {
            for (b bVar : aVar.dYL) {
                if (bVar != null && bVar.isValid()) {
                    nb(bVar.floor.intValue());
                    this.dYU[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.I(aVar.dYM)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dYM) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    nb(featureCardCompetition.floor.intValue());
                    this.dYU[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.I(aVar.dYN)) {
            for (FeatureCardGod featureCardGod : aVar.dYN) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    nb(featureCardGod.floor.intValue());
                    this.dYU[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.I(aVar.dYO)) {
            for (FeatureCardGame featureCardGame : aVar.dYO) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    nb(featureCardGame.floor.intValue());
                    this.dYU[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void nb(int i) {
        if (i >= this.dYU.length) {
            this.dYU = Arrays.copyOf(this.dYU, i + 1);
        }
    }

    private void aGc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dYT.size()) {
                bb bbVar = this.dYT.get(i2);
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

    private void aGd() {
        if (this.dYU != null && this.dYU.length > 0) {
            for (int i = 0; i < this.dYU.length; i++) {
                Object obj = this.dYU[i];
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
        gVar.a(aVar.dYI);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
