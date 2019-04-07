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
    private Object[] fmi;
    private List<m> mData = new ArrayList();
    private List<bg> fmh = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fmh.clear();
                this.fmi = new Object[aVar.flU + 10];
            }
            if (!v.T(aVar.flV)) {
                ArrayList arrayList = new ArrayList(aVar.flV.size());
                for (bg bgVar : aVar.flV) {
                    if (bgVar != null) {
                        arrayList.add(bgVar);
                    }
                }
                this.fmh.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bgs();
            bgt();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.T(aVar.flX)) {
            for (FeatureCardHot featureCardHot : aVar.flX) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    qK(featureCardHot.floor.intValue());
                    this.fmi[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.T(aVar.flY)) {
            for (FeatureCardTopic featureCardTopic : aVar.flY) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    qK(featureCardTopic.floor.intValue());
                    this.fmi[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.T(aVar.flZ)) {
            for (b bVar : aVar.flZ) {
                if (bVar != null && bVar.isValid()) {
                    qK(bVar.floor.intValue());
                    this.fmi[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.T(aVar.fma)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fma) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    qK(featureCardCompetition.floor.intValue());
                    this.fmi[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.T(aVar.fmb)) {
            for (FeatureCardGod featureCardGod : aVar.fmb) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    qK(featureCardGod.floor.intValue());
                    this.fmi[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.T(aVar.fmc)) {
            for (FeatureCardGame featureCardGame : aVar.fmc) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    qK(featureCardGame.floor.intValue());
                    this.fmi[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void qK(int i) {
        if (i >= this.fmi.length) {
            this.fmi = Arrays.copyOf(this.fmi, i + 1);
        }
    }

    private void bgs() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fmh.size()) {
                bg bgVar = this.fmh.get(i2);
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

    private void bgt() {
        if (this.fmi != null && this.fmi.length > 0) {
            for (int i = 0; i < this.fmi.length; i++) {
                Object obj = this.fmi[i];
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
        gVar.a(aVar.flW);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
