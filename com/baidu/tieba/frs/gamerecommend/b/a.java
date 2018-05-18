package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.frs.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Object[] dka;
    private List<h> mData = new ArrayList();
    private List<bd> djZ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.djZ.clear();
                this.dka = new Object[aVar.djM + 10];
            }
            if (!v.w(aVar.djN)) {
                ArrayList arrayList = new ArrayList(aVar.djN.size());
                for (bd bdVar : aVar.djN) {
                    if (bdVar != null) {
                        arrayList.add(bdVar);
                    }
                }
                this.djZ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            asO();
            asP();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.w(aVar.djP)) {
            for (FeatureCardHot featureCardHot : aVar.djP) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    kJ(featureCardHot.floor.intValue());
                    this.dka[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.w(aVar.djQ)) {
            for (FeatureCardTopic featureCardTopic : aVar.djQ) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    kJ(featureCardTopic.floor.intValue());
                    this.dka[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.w(aVar.djR)) {
            for (b bVar : aVar.djR) {
                if (bVar != null && bVar.isValid()) {
                    kJ(bVar.floor.intValue());
                    this.dka[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.w(aVar.djS)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.djS) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    kJ(featureCardCompetition.floor.intValue());
                    this.dka[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.w(aVar.djT)) {
            for (FeatureCardGod featureCardGod : aVar.djT) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    kJ(featureCardGod.floor.intValue());
                    this.dka[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.w(aVar.djU)) {
            for (FeatureCardGame featureCardGame : aVar.djU) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    kJ(featureCardGame.floor.intValue());
                    this.dka[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void kJ(int i) {
        if (i >= this.dka.length) {
            this.dka = Arrays.copyOf(this.dka, i + 1);
        }
    }

    private void asO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.djZ.size()) {
                bd bdVar = this.djZ.get(i2);
                if (bdVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bdVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bdVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void asP() {
        if (this.dka != null && this.dka.length > 0) {
            for (int i = 0; i < this.dka.length; i++) {
                Object obj = this.dka[i];
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
                        o oVar = new o();
                        oVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, oVar);
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
        gVar.a(aVar.djO);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
