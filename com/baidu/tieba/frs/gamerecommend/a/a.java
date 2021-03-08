package com.baidu.tieba.frs.gamerecommend.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.frs.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private Object[] jBO;
    private List<n> mData = new ArrayList();
    private List<cb> jBN = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jBN.clear();
                this.jBO = new Object[aVar.jBA + 10];
            }
            if (!y.isEmpty(aVar.jBB)) {
                ArrayList arrayList = new ArrayList(aVar.jBB.size());
                for (cb cbVar : aVar.jBB) {
                    if (cbVar != null) {
                        arrayList.add(cbVar);
                    }
                }
                this.jBN.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cIs();
            cIt();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.jBD)) {
            for (FeatureCardHot featureCardHot : aVar.jBD) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zO(featureCardHot.floor.intValue());
                    this.jBO[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.jBE)) {
            for (FeatureCardTopic featureCardTopic : aVar.jBE) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zO(featureCardTopic.floor.intValue());
                    this.jBO[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.jBF)) {
            for (b bVar : aVar.jBF) {
                if (bVar != null && bVar.isValid()) {
                    zO(bVar.floor.intValue());
                    this.jBO[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.jBG)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jBG) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zO(featureCardCompetition.floor.intValue());
                    this.jBO[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.jBH)) {
            for (FeatureCardGod featureCardGod : aVar.jBH) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zO(featureCardGod.floor.intValue());
                    this.jBO[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.jBI)) {
            for (FeatureCardGame featureCardGame : aVar.jBI) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zO(featureCardGame.floor.intValue());
                    this.jBO[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zO(int i) {
        if (i >= this.jBO.length) {
            this.jBO = Arrays.copyOf(this.jBO, i + 1);
        }
    }

    private void cIs() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jBN.size()) {
                cb cbVar = this.jBN.get(i2);
                if (cbVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(cbVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(cbVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cIt() {
        if (this.jBO != null && this.jBO.length > 0) {
            for (int i = 0; i < this.jBO.length; i++) {
                Object obj = this.jBO[i];
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
                        w wVar = new w();
                        wVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, wVar);
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
        gVar.a(aVar.jBC);
        this.mData.add(0, gVar);
    }

    public List<n> getData() {
        return this.mData;
    }
}
