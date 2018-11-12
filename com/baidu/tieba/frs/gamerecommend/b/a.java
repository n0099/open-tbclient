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
    private Object[] dOT;
    private List<h> mData = new ArrayList();
    private List<bb> dOS = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dOS.clear();
                this.dOT = new Object[aVar.dOF + 10];
            }
            if (!v.I(aVar.dOG)) {
                ArrayList arrayList = new ArrayList(aVar.dOG.size());
                for (bb bbVar : aVar.dOG) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dOS.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aDe();
            aDf();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.I(aVar.dOI)) {
            for (FeatureCardHot featureCardHot : aVar.dOI) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    mx(featureCardHot.floor.intValue());
                    this.dOT[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.I(aVar.dOJ)) {
            for (FeatureCardTopic featureCardTopic : aVar.dOJ) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    mx(featureCardTopic.floor.intValue());
                    this.dOT[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.I(aVar.dOK)) {
            for (b bVar : aVar.dOK) {
                if (bVar != null && bVar.isValid()) {
                    mx(bVar.floor.intValue());
                    this.dOT[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.I(aVar.dOL)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dOL) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    mx(featureCardCompetition.floor.intValue());
                    this.dOT[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.I(aVar.dOM)) {
            for (FeatureCardGod featureCardGod : aVar.dOM) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    mx(featureCardGod.floor.intValue());
                    this.dOT[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.I(aVar.dON)) {
            for (FeatureCardGame featureCardGame : aVar.dON) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    mx(featureCardGame.floor.intValue());
                    this.dOT[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void mx(int i) {
        if (i >= this.dOT.length) {
            this.dOT = Arrays.copyOf(this.dOT, i + 1);
        }
    }

    private void aDe() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dOS.size()) {
                bb bbVar = this.dOS.get(i2);
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

    private void aDf() {
        if (this.dOT != null && this.dOT.length > 0) {
            for (int i = 0; i < this.dOT.length; i++) {
                Object obj = this.dOT[i];
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
        gVar.a(aVar.dOH);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
