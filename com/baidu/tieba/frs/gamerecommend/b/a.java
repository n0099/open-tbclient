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
    private Object[] dYn;
    private List<h> mData = new ArrayList();
    private List<bb> dYm = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dYm.clear();
                this.dYn = new Object[aVar.dXZ + 10];
            }
            if (!v.I(aVar.dYa)) {
                ArrayList arrayList = new ArrayList(aVar.dYa.size());
                for (bb bbVar : aVar.dYa) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dYm.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aFF();
            aFG();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.I(aVar.dYc)) {
            for (FeatureCardHot featureCardHot : aVar.dYc) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    na(featureCardHot.floor.intValue());
                    this.dYn[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.I(aVar.dYd)) {
            for (FeatureCardTopic featureCardTopic : aVar.dYd) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    na(featureCardTopic.floor.intValue());
                    this.dYn[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.I(aVar.dYe)) {
            for (b bVar : aVar.dYe) {
                if (bVar != null && bVar.isValid()) {
                    na(bVar.floor.intValue());
                    this.dYn[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.I(aVar.dYf)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dYf) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    na(featureCardCompetition.floor.intValue());
                    this.dYn[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.I(aVar.dYg)) {
            for (FeatureCardGod featureCardGod : aVar.dYg) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    na(featureCardGod.floor.intValue());
                    this.dYn[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.I(aVar.dYh)) {
            for (FeatureCardGame featureCardGame : aVar.dYh) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    na(featureCardGame.floor.intValue());
                    this.dYn[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void na(int i) {
        if (i >= this.dYn.length) {
            this.dYn = Arrays.copyOf(this.dYn, i + 1);
        }
    }

    private void aFF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dYm.size()) {
                bb bbVar = this.dYm.get(i2);
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

    private void aFG() {
        if (this.dYn != null && this.dYn.length > 0) {
            for (int i = 0; i < this.dYn.length; i++) {
                Object obj = this.dYn[i];
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
        gVar.a(aVar.dYb);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
