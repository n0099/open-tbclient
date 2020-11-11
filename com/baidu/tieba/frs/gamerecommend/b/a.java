package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private Object[] iYf;
    private List<q> mData = new ArrayList();
    private List<bw> iYe = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.iYe.clear();
                this.iYf = new Object[aVar.iXR + 10];
            }
            if (!y.isEmpty(aVar.iXS)) {
                ArrayList arrayList = new ArrayList(aVar.iXS.size());
                for (bw bwVar : aVar.iXS) {
                    if (bwVar != null) {
                        arrayList.add(bwVar);
                    }
                }
                this.iYe.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cCT();
            cCU();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.iXU)) {
            for (FeatureCardHot featureCardHot : aVar.iXU) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zL(featureCardHot.floor.intValue());
                    this.iYf[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.iXV)) {
            for (FeatureCardTopic featureCardTopic : aVar.iXV) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zL(featureCardTopic.floor.intValue());
                    this.iYf[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.iXW)) {
            for (b bVar : aVar.iXW) {
                if (bVar != null && bVar.isValid()) {
                    zL(bVar.floor.intValue());
                    this.iYf[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.iXX)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.iXX) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zL(featureCardCompetition.floor.intValue());
                    this.iYf[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.iXY)) {
            for (FeatureCardGod featureCardGod : aVar.iXY) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zL(featureCardGod.floor.intValue());
                    this.iYf[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.iXZ)) {
            for (FeatureCardGame featureCardGame : aVar.iXZ) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zL(featureCardGame.floor.intValue());
                    this.iYf[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zL(int i) {
        if (i >= this.iYf.length) {
            this.iYf = Arrays.copyOf(this.iYf, i + 1);
        }
    }

    private void cCT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iYe.size()) {
                bw bwVar = this.iYe.get(i2);
                if (bwVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bwVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bwVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cCU() {
        if (this.iYf != null && this.iYf.length > 0) {
            for (int i = 0; i < this.iYf.length; i++) {
                Object obj = this.iYf[i];
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
                        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
                        yVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, yVar);
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
        gVar.a(aVar.iXT);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
