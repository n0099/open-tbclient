package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
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
    private Object[] fCE;
    private List<m> mData = new ArrayList();
    private List<bg> fCD = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fCD.clear();
                this.fCE = new Object[aVar.fCq + 10];
            }
            if (!v.aa(aVar.fCr)) {
                ArrayList arrayList = new ArrayList(aVar.fCr.size());
                for (bg bgVar : aVar.fCr) {
                    if (bgVar != null) {
                        arrayList.add(bgVar);
                    }
                }
                this.fCD.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bnM();
            bnN();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.aa(aVar.fCt)) {
            for (FeatureCardHot featureCardHot : aVar.fCt) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    rS(featureCardHot.floor.intValue());
                    this.fCE[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.aa(aVar.fCu)) {
            for (FeatureCardTopic featureCardTopic : aVar.fCu) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    rS(featureCardTopic.floor.intValue());
                    this.fCE[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.aa(aVar.fCv)) {
            for (b bVar : aVar.fCv) {
                if (bVar != null && bVar.isValid()) {
                    rS(bVar.floor.intValue());
                    this.fCE[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.aa(aVar.fCw)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fCw) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    rS(featureCardCompetition.floor.intValue());
                    this.fCE[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.aa(aVar.fCx)) {
            for (FeatureCardGod featureCardGod : aVar.fCx) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    rS(featureCardGod.floor.intValue());
                    this.fCE[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.aa(aVar.fCy)) {
            for (FeatureCardGame featureCardGame : aVar.fCy) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    rS(featureCardGame.floor.intValue());
                    this.fCE[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void rS(int i) {
        if (i >= this.fCE.length) {
            this.fCE = Arrays.copyOf(this.fCE, i + 1);
        }
    }

    private void bnM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fCD.size()) {
                bg bgVar = this.fCD.get(i2);
                if (bgVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bgVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bgVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bnN() {
        if (this.fCE != null && this.fCE.length > 0) {
            for (int i = 0; i < this.fCE.length; i++) {
                Object obj = this.fCE[i];
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
        gVar.a(aVar.fCs);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
