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
    private Object[] jAf;
    private List<n> mData = new ArrayList();
    private List<cb> jAe = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.jAe.clear();
                this.jAf = new Object[aVar.jzR + 10];
            }
            if (!y.isEmpty(aVar.jzS)) {
                ArrayList arrayList = new ArrayList(aVar.jzS.size());
                for (cb cbVar : aVar.jzS) {
                    if (cbVar != null) {
                        arrayList.add(cbVar);
                    }
                }
                this.jAe.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            cIm();
            cIn();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!y.isEmpty(aVar.jzU)) {
            for (FeatureCardHot featureCardHot : aVar.jzU) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    zN(featureCardHot.floor.intValue());
                    this.jAf[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!y.isEmpty(aVar.jzV)) {
            for (FeatureCardTopic featureCardTopic : aVar.jzV) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    zN(featureCardTopic.floor.intValue());
                    this.jAf[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!y.isEmpty(aVar.jzW)) {
            for (b bVar : aVar.jzW) {
                if (bVar != null && bVar.isValid()) {
                    zN(bVar.floor.intValue());
                    this.jAf[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!y.isEmpty(aVar.jzX)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.jzX) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    zN(featureCardCompetition.floor.intValue());
                    this.jAf[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!y.isEmpty(aVar.jzY)) {
            for (FeatureCardGod featureCardGod : aVar.jzY) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    zN(featureCardGod.floor.intValue());
                    this.jAf[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!y.isEmpty(aVar.jzZ)) {
            for (FeatureCardGame featureCardGame : aVar.jzZ) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    zN(featureCardGame.floor.intValue());
                    this.jAf[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void zN(int i) {
        if (i >= this.jAf.length) {
            this.jAf = Arrays.copyOf(this.jAf, i + 1);
        }
    }

    private void cIm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jAe.size()) {
                cb cbVar = this.jAe.get(i2);
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

    private void cIn() {
        if (this.jAf != null && this.jAf.length > 0) {
            for (int i = 0; i < this.jAf.length; i++) {
                Object obj = this.jAf[i];
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
        gVar.a(aVar.jzT);
        this.mData.add(0, gVar);
    }

    public List<n> getData() {
        return this.mData;
    }
}
