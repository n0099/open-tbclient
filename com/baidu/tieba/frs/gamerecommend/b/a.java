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
    private Object[] fCD;
    private List<m> mData = new ArrayList();
    private List<bg> fCC = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fCC.clear();
                this.fCD = new Object[aVar.fCp + 10];
            }
            if (!v.aa(aVar.fCq)) {
                ArrayList arrayList = new ArrayList(aVar.fCq.size());
                for (bg bgVar : aVar.fCq) {
                    if (bgVar != null) {
                        arrayList.add(bgVar);
                    }
                }
                this.fCC.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bnJ();
            bnK();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.aa(aVar.fCs)) {
            for (FeatureCardHot featureCardHot : aVar.fCs) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    rS(featureCardHot.floor.intValue());
                    this.fCD[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.aa(aVar.fCt)) {
            for (FeatureCardTopic featureCardTopic : aVar.fCt) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    rS(featureCardTopic.floor.intValue());
                    this.fCD[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.aa(aVar.fCu)) {
            for (b bVar : aVar.fCu) {
                if (bVar != null && bVar.isValid()) {
                    rS(bVar.floor.intValue());
                    this.fCD[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.aa(aVar.fCv)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fCv) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    rS(featureCardCompetition.floor.intValue());
                    this.fCD[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.aa(aVar.fCw)) {
            for (FeatureCardGod featureCardGod : aVar.fCw) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    rS(featureCardGod.floor.intValue());
                    this.fCD[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.aa(aVar.fCx)) {
            for (FeatureCardGame featureCardGame : aVar.fCx) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    rS(featureCardGame.floor.intValue());
                    this.fCD[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void rS(int i) {
        if (i >= this.fCD.length) {
            this.fCD = Arrays.copyOf(this.fCD, i + 1);
        }
    }

    private void bnJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fCC.size()) {
                bg bgVar = this.fCC.get(i2);
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

    private void bnK() {
        if (this.fCD != null && this.fCD.length > 0) {
            for (int i = 0; i < this.fCD.length; i++) {
                Object obj = this.fCD[i];
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
        gVar.a(aVar.fCr);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
