package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] hBI;
    private List<o> mData = new ArrayList();
    private List<bk> hBH = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hBH.clear();
                this.hBI = new Object[aVar.hBu + 10];
            }
            if (!v.isEmpty(aVar.hBv)) {
                ArrayList arrayList = new ArrayList(aVar.hBv.size());
                for (bk bkVar : aVar.hBv) {
                    if (bkVar != null) {
                        arrayList.add(bkVar);
                    }
                }
                this.hBH.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bYY();
            bYZ();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.hBx)) {
            for (FeatureCardHot featureCardHot : aVar.hBx) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    uI(featureCardHot.floor.intValue());
                    this.hBI[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.hBy)) {
            for (FeatureCardTopic featureCardTopic : aVar.hBy) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    uI(featureCardTopic.floor.intValue());
                    this.hBI[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.hBz)) {
            for (b bVar : aVar.hBz) {
                if (bVar != null && bVar.isValid()) {
                    uI(bVar.floor.intValue());
                    this.hBI[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.hBA)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hBA) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    uI(featureCardCompetition.floor.intValue());
                    this.hBI[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.hBB)) {
            for (FeatureCardGod featureCardGod : aVar.hBB) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    uI(featureCardGod.floor.intValue());
                    this.hBI[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.hBC)) {
            for (FeatureCardGame featureCardGame : aVar.hBC) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    uI(featureCardGame.floor.intValue());
                    this.hBI[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void uI(int i) {
        if (i >= this.hBI.length) {
            this.hBI = Arrays.copyOf(this.hBI, i + 1);
        }
    }

    private void bYY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hBH.size()) {
                bk bkVar = this.hBH.get(i2);
                if (bkVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bkVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bkVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bYZ() {
        if (this.hBI != null && this.hBI.length > 0) {
            for (int i = 0; i < this.hBI.length; i++) {
                Object obj = this.hBI[i];
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
                        u uVar = new u();
                        uVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, uVar);
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
        gVar.a(aVar.hBw);
        this.mData.add(0, gVar);
    }

    public List<o> getData() {
        return this.mData;
    }
}
