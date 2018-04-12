package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.frs.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Object[] diW;
    private List<h> mData = new ArrayList();
    private List<bd> diV = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.diV.clear();
                this.diW = new Object[aVar.diI + 10];
            }
            if (!v.w(aVar.diJ)) {
                ArrayList arrayList = new ArrayList(aVar.diJ.size());
                for (bd bdVar : aVar.diJ) {
                    if (bdVar != null) {
                        arrayList.add(bdVar);
                    }
                }
                this.diV.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            asP();
            asQ();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.w(aVar.diL)) {
            for (FeatureCardHot featureCardHot : aVar.diL) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    kL(featureCardHot.floor.intValue());
                    this.diW[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.w(aVar.diM)) {
            for (FeatureCardTopic featureCardTopic : aVar.diM) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    kL(featureCardTopic.floor.intValue());
                    this.diW[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.w(aVar.diN)) {
            for (b bVar : aVar.diN) {
                if (bVar != null && bVar.isValid()) {
                    kL(bVar.floor.intValue());
                    this.diW[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.w(aVar.diO)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.diO) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    kL(featureCardCompetition.floor.intValue());
                    this.diW[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.w(aVar.diP)) {
            for (FeatureCardGod featureCardGod : aVar.diP) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    kL(featureCardGod.floor.intValue());
                    this.diW[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.w(aVar.diQ)) {
            for (FeatureCardGame featureCardGame : aVar.diQ) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    kL(featureCardGame.floor.intValue());
                    this.diW[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void kL(int i) {
        if (i >= this.diW.length) {
            this.diW = Arrays.copyOf(this.diW, i + 1);
        }
    }

    private void asP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.diV.size()) {
                bd bdVar = this.diV.get(i2);
                if (bdVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bdVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bdVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void asQ() {
        if (this.diW != null && this.diW.length > 0) {
            for (int i = 0; i < this.diW.length; i++) {
                Object obj = this.diW[i];
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
                        o oVar = new o();
                        oVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, oVar);
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
        gVar.a(aVar.diK);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
