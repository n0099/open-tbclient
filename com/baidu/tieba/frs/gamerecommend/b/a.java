package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
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
    private Object[] hVC;
    private List<q> mData = new ArrayList();
    private List<bv> hVB = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hVB.clear();
                this.hVC = new Object[aVar.hVo + 10];
            }
            if (!x.isEmpty(aVar.hVp)) {
                ArrayList arrayList = new ArrayList(aVar.hVp.size());
                for (bv bvVar : aVar.hVp) {
                    if (bvVar != null) {
                        arrayList.add(bvVar);
                    }
                }
                this.hVB.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cfV();
            cfW();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!x.isEmpty(aVar.hVr)) {
            for (FeatureCardHot featureCardHot : aVar.hVr) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    vH(featureCardHot.floor.intValue());
                    this.hVC[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!x.isEmpty(aVar.hVs)) {
            for (FeatureCardTopic featureCardTopic : aVar.hVs) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    vH(featureCardTopic.floor.intValue());
                    this.hVC[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!x.isEmpty(aVar.hVt)) {
            for (b bVar : aVar.hVt) {
                if (bVar != null && bVar.isValid()) {
                    vH(bVar.floor.intValue());
                    this.hVC[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!x.isEmpty(aVar.hVu)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hVu) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    vH(featureCardCompetition.floor.intValue());
                    this.hVC[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!x.isEmpty(aVar.hVv)) {
            for (FeatureCardGod featureCardGod : aVar.hVv) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    vH(featureCardGod.floor.intValue());
                    this.hVC[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!x.isEmpty(aVar.hVw)) {
            for (FeatureCardGame featureCardGame : aVar.hVw) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    vH(featureCardGame.floor.intValue());
                    this.hVC[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void vH(int i) {
        if (i >= this.hVC.length) {
            this.hVC = Arrays.copyOf(this.hVC, i + 1);
        }
    }

    private void cfV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hVB.size()) {
                bv bvVar = this.hVB.get(i2);
                if (bvVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bvVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bvVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cfW() {
        if (this.hVC != null && this.hVC.length > 0) {
            for (int i = 0; i < this.hVC.length; i++) {
                Object obj = this.hVC[i];
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
                        com.baidu.tieba.frs.x xVar = new com.baidu.tieba.frs.x();
                        xVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, xVar);
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
        gVar.a(aVar.hVq);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
