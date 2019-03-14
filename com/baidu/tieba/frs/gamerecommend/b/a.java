package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private Object[] fmw;
    private List<m> mData = new ArrayList();
    private List<bg> fmv = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fmv.clear();
                this.fmw = new Object[aVar.fmi + 10];
            }
            if (!v.T(aVar.fmj)) {
                ArrayList arrayList = new ArrayList(aVar.fmj.size());
                for (bg bgVar : aVar.fmj) {
                    if (bgVar != null) {
                        arrayList.add(bgVar);
                    }
                }
                this.fmv.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bgu();
            bgv();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.T(aVar.fml)) {
            for (FeatureCardHot featureCardHot : aVar.fml) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    qO(featureCardHot.floor.intValue());
                    this.fmw[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.T(aVar.fmm)) {
            for (FeatureCardTopic featureCardTopic : aVar.fmm) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    qO(featureCardTopic.floor.intValue());
                    this.fmw[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.T(aVar.fmn)) {
            for (b bVar : aVar.fmn) {
                if (bVar != null && bVar.isValid()) {
                    qO(bVar.floor.intValue());
                    this.fmw[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.T(aVar.fmo)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fmo) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    qO(featureCardCompetition.floor.intValue());
                    this.fmw[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.T(aVar.fmp)) {
            for (FeatureCardGod featureCardGod : aVar.fmp) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    qO(featureCardGod.floor.intValue());
                    this.fmw[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.T(aVar.fmq)) {
            for (FeatureCardGame featureCardGame : aVar.fmq) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    qO(featureCardGame.floor.intValue());
                    this.fmw[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void qO(int i) {
        if (i >= this.fmw.length) {
            this.fmw = Arrays.copyOf(this.fmw, i + 1);
        }
    }

    private void bgu() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fmv.size()) {
                bg bgVar = this.fmv.get(i2);
                if (bgVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bgVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bgVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bgv() {
        if (this.fmw != null && this.fmw.length > 0) {
            for (int i = 0; i < this.fmw.length; i++) {
                Object obj = this.fmw[i];
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
        gVar.a(aVar.fmk);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
