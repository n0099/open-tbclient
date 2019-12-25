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
/* loaded from: classes6.dex */
public class a {
    private Object[] gwW;
    private List<m> mData = new ArrayList();
    private List<bj> gwV = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.gwV.clear();
                this.gwW = new Object[aVar.gwI + 10];
            }
            if (!v.isEmpty(aVar.gwJ)) {
                ArrayList arrayList = new ArrayList(aVar.gwJ.size());
                for (bj bjVar : aVar.gwJ) {
                    if (bjVar != null) {
                        arrayList.add(bjVar);
                    }
                }
                this.gwV.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bFm();
            bFn();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.gwL)) {
            for (FeatureCardHot featureCardHot : aVar.gwL) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    to(featureCardHot.floor.intValue());
                    this.gwW[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.gwM)) {
            for (FeatureCardTopic featureCardTopic : aVar.gwM) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    to(featureCardTopic.floor.intValue());
                    this.gwW[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.gwN)) {
            for (b bVar : aVar.gwN) {
                if (bVar != null && bVar.isValid()) {
                    to(bVar.floor.intValue());
                    this.gwW[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.gwO)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.gwO) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    to(featureCardCompetition.floor.intValue());
                    this.gwW[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.gwP)) {
            for (FeatureCardGod featureCardGod : aVar.gwP) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    to(featureCardGod.floor.intValue());
                    this.gwW[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.gwQ)) {
            for (FeatureCardGame featureCardGame : aVar.gwQ) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    to(featureCardGame.floor.intValue());
                    this.gwW[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void to(int i) {
        if (i >= this.gwW.length) {
            this.gwW = Arrays.copyOf(this.gwW, i + 1);
        }
    }

    private void bFm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gwV.size()) {
                bj bjVar = this.gwV.get(i2);
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

    private void bFn() {
        if (this.gwW != null && this.gwW.length > 0) {
            for (int i = 0; i < this.gwW.length; i++) {
                Object obj = this.gwW[i];
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
        gVar.a(aVar.gwK);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
