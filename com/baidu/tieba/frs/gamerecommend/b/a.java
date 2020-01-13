package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private Object[] gAg;
    private List<m> mData = new ArrayList();
    private List<bj> gAf = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.gAf.clear();
                this.gAg = new Object[aVar.gzS + 10];
            }
            if (!v.isEmpty(aVar.gzT)) {
                ArrayList arrayList = new ArrayList(aVar.gzT.size());
                for (bj bjVar : aVar.gzT) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.gAf.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bGo();
            bGp();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.gzV)) {
            for (FeatureCardHot featureCardHot : aVar.gzV) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    tt(featureCardHot.floor.intValue());
                    this.gAg[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.gzW)) {
            for (FeatureCardTopic featureCardTopic : aVar.gzW) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    tt(featureCardTopic.floor.intValue());
                    this.gAg[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.gzX)) {
            for (b bVar : aVar.gzX) {
                if (bVar != null && bVar.isValid()) {
                    tt(bVar.floor.intValue());
                    this.gAg[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.gzY)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.gzY) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    tt(featureCardCompetition.floor.intValue());
                    this.gAg[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.gzZ)) {
            for (FeatureCardGod featureCardGod : aVar.gzZ) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    tt(featureCardGod.floor.intValue());
                    this.gAg[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.gAa)) {
            for (FeatureCardGame featureCardGame : aVar.gAa) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    tt(featureCardGame.floor.intValue());
                    this.gAg[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void tt(int i) {
        if (i >= this.gAg.length) {
            this.gAg = Arrays.copyOf(this.gAg, i + 1);
        }
    }

    private void bGo() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gAf.size()) {
                bj bjVar = this.gAf.get(i2);
                if (bjVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bjVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bjVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bGp() {
        if (this.gAg != null && this.gAg.length > 0) {
            for (int i = 0; i < this.gAg.length; i++) {
                Object obj = this.gAg[i];
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
                        r rVar = new r();
                        rVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, rVar);
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
        gVar.a(aVar.gzU);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
