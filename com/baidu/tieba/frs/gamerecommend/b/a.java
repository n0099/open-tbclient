package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
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
    private Object[] dzh;
    private List<h> mData = new ArrayList();
    private List<bb> dzg = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dzg.clear();
                this.dzh = new Object[aVar.dyT + 10];
            }
            if (!w.z(aVar.dyU)) {
                ArrayList arrayList = new ArrayList(aVar.dyU.size());
                for (bb bbVar : aVar.dyU) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dzg.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            ayb();
            ayc();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!w.z(aVar.dyW)) {
            for (FeatureCardHot featureCardHot : aVar.dyW) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    lf(featureCardHot.floor.intValue());
                    this.dzh[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!w.z(aVar.dyX)) {
            for (FeatureCardTopic featureCardTopic : aVar.dyX) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    lf(featureCardTopic.floor.intValue());
                    this.dzh[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!w.z(aVar.dyY)) {
            for (b bVar : aVar.dyY) {
                if (bVar != null && bVar.isValid()) {
                    lf(bVar.floor.intValue());
                    this.dzh[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!w.z(aVar.dyZ)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dyZ) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    lf(featureCardCompetition.floor.intValue());
                    this.dzh[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!w.z(aVar.dza)) {
            for (FeatureCardGod featureCardGod : aVar.dza) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    lf(featureCardGod.floor.intValue());
                    this.dzh[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!w.z(aVar.dzb)) {
            for (FeatureCardGame featureCardGame : aVar.dzb) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    lf(featureCardGame.floor.intValue());
                    this.dzh[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void lf(int i) {
        if (i >= this.dzh.length) {
            this.dzh = Arrays.copyOf(this.dzh, i + 1);
        }
    }

    private void ayb() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dzg.size()) {
                bb bbVar = this.dzg.get(i2);
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

    private void ayc() {
        if (this.dzh != null && this.dzh.length > 0) {
            for (int i = 0; i < this.dzh.length; i++) {
                Object obj = this.dzh[i];
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
        gVar.a(aVar.dyV);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
