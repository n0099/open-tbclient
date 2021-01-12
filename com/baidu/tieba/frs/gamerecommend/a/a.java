package com.baidu.tieba.frs.gamerecommend.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
    private Object[] jul;
    private List<n> mData = new ArrayList();
    private List<bz> juk = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.juk.clear();
                this.jul = new Object[aVar.jtX + 10];
            }
            if (!x.isEmpty(aVar.jtY)) {
                ArrayList arrayList = new ArrayList(aVar.jtY.size());
                for (bz bzVar : aVar.jtY) {
                    if (bzVar != null) {
                        arrayList.add(bzVar);
                    }
                }
                this.juk.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cGS();
            cGT();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!x.isEmpty(aVar.jua)) {
            for (FeatureCardHot featureCardHot : aVar.jua) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zD(featureCardHot.floor.intValue());
                    this.jul[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!x.isEmpty(aVar.jub)) {
            for (FeatureCardTopic featureCardTopic : aVar.jub) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zD(featureCardTopic.floor.intValue());
                    this.jul[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!x.isEmpty(aVar.juc)) {
            for (b bVar : aVar.juc) {
                if (bVar != null && bVar.isValid()) {
                    zD(bVar.floor.intValue());
                    this.jul[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!x.isEmpty(aVar.jud)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jud) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zD(featureCardCompetition.floor.intValue());
                    this.jul[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!x.isEmpty(aVar.jue)) {
            for (FeatureCardGod featureCardGod : aVar.jue) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zD(featureCardGod.floor.intValue());
                    this.jul[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!x.isEmpty(aVar.juf)) {
            for (FeatureCardGame featureCardGame : aVar.juf) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zD(featureCardGame.floor.intValue());
                    this.jul[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zD(int i) {
        if (i >= this.jul.length) {
            this.jul = Arrays.copyOf(this.jul, i + 1);
        }
    }

    private void cGS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juk.size()) {
                bz bzVar = this.juk.get(i2);
                if (bzVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bzVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bzVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void cGT() {
        if (this.jul != null && this.jul.length > 0) {
            for (int i = 0; i < this.jul.length; i++) {
                Object obj = this.jul[i];
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
        gVar.a(aVar.jtZ);
        this.mData.add(0, gVar);
    }

    public List<n> getData() {
        return this.mData;
    }
}
