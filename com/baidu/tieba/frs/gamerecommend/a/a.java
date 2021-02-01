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
    private Object[] jzR;
    private List<n> mData = new ArrayList();
    private List<cb> jzQ = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jzQ.clear();
                this.jzR = new Object[aVar.jzD + 10];
            }
            if (!y.isEmpty(aVar.jzE)) {
                ArrayList arrayList = new ArrayList(aVar.jzE.size());
                for (cb cbVar : aVar.jzE) {
                    if (cbVar != null) {
                        arrayList.add(cbVar);
                    }
                }
                this.jzQ.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cIf();
            cIg();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.jzG)) {
            for (FeatureCardHot featureCardHot : aVar.jzG) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zN(featureCardHot.floor.intValue());
                    this.jzR[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.jzH)) {
            for (FeatureCardTopic featureCardTopic : aVar.jzH) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zN(featureCardTopic.floor.intValue());
                    this.jzR[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.jzI)) {
            for (b bVar : aVar.jzI) {
                if (bVar != null && bVar.isValid()) {
                    zN(bVar.floor.intValue());
                    this.jzR[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.jzJ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jzJ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zN(featureCardCompetition.floor.intValue());
                    this.jzR[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.jzK)) {
            for (FeatureCardGod featureCardGod : aVar.jzK) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zN(featureCardGod.floor.intValue());
                    this.jzR[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.jzL)) {
            for (FeatureCardGame featureCardGame : aVar.jzL) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zN(featureCardGame.floor.intValue());
                    this.jzR[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zN(int i) {
        if (i >= this.jzR.length) {
            this.jzR = Arrays.copyOf(this.jzR, i + 1);
        }
    }

    private void cIf() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jzQ.size()) {
                cb cbVar = this.jzQ.get(i2);
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

    private void cIg() {
        if (this.jzR != null && this.jzR.length > 0) {
            for (int i = 0; i < this.jzR.length; i++) {
                Object obj = this.jzR[i];
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
        gVar.a(aVar.jzF);
        this.mData.add(0, gVar);
    }

    public List<n> getData() {
        return this.mData;
    }
}
