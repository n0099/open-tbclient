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
    private Object[] fIH;
    private List<m> mData = new ArrayList();
    private List<bh> fIG = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.fIG.clear();
                this.fIH = new Object[aVar.fIt + 10];
            }
            if (!v.isEmpty(aVar.fIu)) {
                ArrayList arrayList = new ArrayList(aVar.fIu.size());
                for (bh bhVar : aVar.fIu) {
                    if (bhVar != null) {
                        arrayList.add(bhVar);
                    }
                }
                this.fIG.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bnP();
            bnQ();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.fIw)) {
            for (FeatureCardHot featureCardHot : aVar.fIw) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    ri(featureCardHot.floor.intValue());
                    this.fIH[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.fIx)) {
            for (FeatureCardTopic featureCardTopic : aVar.fIx) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    ri(featureCardTopic.floor.intValue());
                    this.fIH[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.fIy)) {
            for (b bVar : aVar.fIy) {
                if (bVar != null && bVar.isValid()) {
                    ri(bVar.floor.intValue());
                    this.fIH[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.fIz)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.fIz) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    ri(featureCardCompetition.floor.intValue());
                    this.fIH[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.fIA)) {
            for (FeatureCardGod featureCardGod : aVar.fIA) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    ri(featureCardGod.floor.intValue());
                    this.fIH[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.fIB)) {
            for (FeatureCardGame featureCardGame : aVar.fIB) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    ri(featureCardGame.floor.intValue());
                    this.fIH[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void ri(int i) {
        if (i >= this.fIH.length) {
            this.fIH = Arrays.copyOf(this.fIH, i + 1);
        }
    }

    private void bnP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fIG.size()) {
                bh bhVar = this.fIG.get(i2);
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

    private void bnQ() {
        if (this.fIH != null && this.fIH.length > 0) {
            for (int i = 0; i < this.fIH.length; i++) {
                Object obj = this.fIH[i];
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
        gVar.a(aVar.fIv);
        this.mData.add(0, gVar);
    }

    public List<m> getData() {
        return this.mData;
    }
}
