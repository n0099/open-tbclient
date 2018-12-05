package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
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
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Object[] dVw;
    private List<h> mData = new ArrayList();
    private List<bb> dVv = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dVv.clear();
                this.dVw = new Object[aVar.dVi + 10];
            }
            if (!v.I(aVar.dVj)) {
                ArrayList arrayList = new ArrayList(aVar.dVj.size());
                for (bb bbVar : aVar.dVj) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dVv.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            aEQ();
            aER();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.I(aVar.dVl)) {
            for (FeatureCardHot featureCardHot : aVar.dVl) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    mN(featureCardHot.floor.intValue());
                    this.dVw[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.I(aVar.dVm)) {
            for (FeatureCardTopic featureCardTopic : aVar.dVm) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    mN(featureCardTopic.floor.intValue());
                    this.dVw[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.I(aVar.dVn)) {
            for (b bVar : aVar.dVn) {
                if (bVar != null && bVar.isValid()) {
                    mN(bVar.floor.intValue());
                    this.dVw[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.I(aVar.dVo)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dVo) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    mN(featureCardCompetition.floor.intValue());
                    this.dVw[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.I(aVar.dVp)) {
            for (FeatureCardGod featureCardGod : aVar.dVp) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    mN(featureCardGod.floor.intValue());
                    this.dVw[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.I(aVar.dVq)) {
            for (FeatureCardGame featureCardGame : aVar.dVq) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    mN(featureCardGame.floor.intValue());
                    this.dVw[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void mN(int i) {
        if (i >= this.dVw.length) {
            this.dVw = Arrays.copyOf(this.dVw, i + 1);
        }
    }

    private void aEQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dVv.size()) {
                bb bbVar = this.dVv.get(i2);
                if (bbVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bbVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bbVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void aER() {
        if (this.dVw != null && this.dVw.length > 0) {
            for (int i = 0; i < this.dVw.length; i++) {
                Object obj = this.dVw[i];
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
        gVar.a(aVar.dVk);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
