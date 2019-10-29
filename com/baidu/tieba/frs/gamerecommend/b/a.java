package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
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
    private Object[] fJy;
    private List<m> mData = new ArrayList();
    private List<bh> fJx = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fJx.clear();
                this.fJy = new Object[aVar.fJk + 10];
            }
            if (!v.isEmpty(aVar.fJl)) {
                ArrayList arrayList = new ArrayList(aVar.fJl.size());
                for (bh bhVar : aVar.fJl) {
                    if (bhVar != null) {
                        arrayList.add(bhVar);
                    }
                }
                this.fJx.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bnR();
            bnS();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.fJn)) {
            for (FeatureCardHot featureCardHot : aVar.fJn) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    rj(featureCardHot.floor.intValue());
                    this.fJy[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.fJo)) {
            for (FeatureCardTopic featureCardTopic : aVar.fJo) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    rj(featureCardTopic.floor.intValue());
                    this.fJy[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.fJp)) {
            for (b bVar : aVar.fJp) {
                if (bVar != null && bVar.isValid()) {
                    rj(bVar.floor.intValue());
                    this.fJy[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.fJq)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fJq) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    rj(featureCardCompetition.floor.intValue());
                    this.fJy[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.fJr)) {
            for (FeatureCardGod featureCardGod : aVar.fJr) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    rj(featureCardGod.floor.intValue());
                    this.fJy[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.fJs)) {
            for (FeatureCardGame featureCardGame : aVar.fJs) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    rj(featureCardGame.floor.intValue());
                    this.fJy[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void rj(int i) {
        if (i >= this.fJy.length) {
            this.fJy = Arrays.copyOf(this.fJy, i + 1);
        }
    }

    private void bnR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fJx.size()) {
                bh bhVar = this.fJx.get(i2);
                if (bhVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bhVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bhVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bnS() {
        if (this.fJy != null && this.fJy.length > 0) {
            for (int i = 0; i < this.fJy.length; i++) {
                Object obj = this.fJy[i];
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
        gVar.a(aVar.fJm);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
