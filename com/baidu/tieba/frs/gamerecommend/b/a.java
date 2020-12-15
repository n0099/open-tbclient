package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.f.c;
import com.baidu.tieba.f.d;
import com.baidu.tieba.f.e;
import com.baidu.tieba.f.f;
import com.baidu.tieba.f.g;
import com.baidu.tieba.f.h;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.b;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private Object[] jmt;
    private List<q> mData = new ArrayList();
    private List<by> jms = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jms.clear();
                this.jmt = new Object[aVar.jme + 10];
            }
            if (!y.isEmpty(aVar.jmf)) {
                ArrayList arrayList = new ArrayList(aVar.jmf.size());
                for (by byVar : aVar.jmf) {
                    if (byVar != null) {
                        arrayList.add(byVar);
                    }
                }
                this.jms.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cHJ();
            cHK();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.jmh)) {
            for (FeatureCardHot featureCardHot : aVar.jmh) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    AX(featureCardHot.floor.intValue());
                    this.jmt[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.jmi)) {
            for (FeatureCardTopic featureCardTopic : aVar.jmi) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    AX(featureCardTopic.floor.intValue());
                    this.jmt[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.jmj)) {
            for (b bVar : aVar.jmj) {
                if (bVar != null && bVar.isValid()) {
                    AX(bVar.floor.intValue());
                    this.jmt[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.jmk)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jmk) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    AX(featureCardCompetition.floor.intValue());
                    this.jmt[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.jml)) {
            for (FeatureCardGod featureCardGod : aVar.jml) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    AX(featureCardGod.floor.intValue());
                    this.jmt[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.jmm)) {
            for (FeatureCardGame featureCardGame : aVar.jmm) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    AX(featureCardGame.floor.intValue());
                    this.jmt[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void AX(int i) {
        if (i >= this.jmt.length) {
            this.jmt = Arrays.copyOf(this.jmt, i + 1);
        }
    }

    private void cHJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jms.size()) {
                by byVar = this.jms.get(i2);
                if (byVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.f.a aVar = new com.baidu.tieba.f.a();
                        aVar.setData(byVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.f.b bVar = new com.baidu.tieba.f.b();
                        bVar.setData(byVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cHK() {
        if (this.jmt != null && this.jmt.length > 0) {
            for (int i = 0; i < this.jmt.length; i++) {
                Object obj = this.jmt[i];
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
                        x xVar = new x();
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
        gVar.a(aVar.jmg);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
