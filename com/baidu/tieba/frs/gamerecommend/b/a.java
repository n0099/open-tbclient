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
    private Object[] fKf;
    private List<m> mData = new ArrayList();
    private List<bh> fKe = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fKe.clear();
                this.fKf = new Object[aVar.fJR + 10];
            }
            if (!v.aa(aVar.fJS)) {
                ArrayList arrayList = new ArrayList(aVar.fJS.size());
                for (bh bhVar : aVar.fJS) {
                    if (bhVar != null) {
                        arrayList.add(bhVar);
                    }
                }
                this.fKe.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bqM();
            bqN();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.aa(aVar.fJU)) {
            for (FeatureCardHot featureCardHot : aVar.fJU) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    sq(featureCardHot.floor.intValue());
                    this.fKf[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.aa(aVar.fJV)) {
            for (FeatureCardTopic featureCardTopic : aVar.fJV) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    sq(featureCardTopic.floor.intValue());
                    this.fKf[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.aa(aVar.fJW)) {
            for (b bVar : aVar.fJW) {
                if (bVar != null && bVar.isValid()) {
                    sq(bVar.floor.intValue());
                    this.fKf[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.aa(aVar.fJX)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fJX) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    sq(featureCardCompetition.floor.intValue());
                    this.fKf[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.aa(aVar.fJY)) {
            for (FeatureCardGod featureCardGod : aVar.fJY) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    sq(featureCardGod.floor.intValue());
                    this.fKf[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.aa(aVar.fJZ)) {
            for (FeatureCardGame featureCardGame : aVar.fJZ) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    sq(featureCardGame.floor.intValue());
                    this.fKf[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void sq(int i) {
        if (i >= this.fKf.length) {
            this.fKf = Arrays.copyOf(this.fKf, i + 1);
        }
    }

    private void bqM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fKe.size()) {
                bh bhVar = this.fKe.get(i2);
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

    private void bqN() {
        if (this.fKf != null && this.fKf.length > 0) {
            for (int i = 0; i < this.fKf.length; i++) {
                Object obj = this.fKf[i];
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
        gVar.a(aVar.fJT);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
