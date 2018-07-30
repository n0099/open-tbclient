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
    private Object[] dzk;
    private List<h> mData = new ArrayList();
    private List<bb> dzj = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dzj.clear();
                this.dzk = new Object[aVar.dyW + 10];
            }
            if (!w.z(aVar.dyX)) {
                ArrayList arrayList = new ArrayList(aVar.dyX.size());
                for (bb bbVar : aVar.dyX) {
                    if (bbVar != null) {
                        arrayList.add(bbVar);
                    }
                }
                this.dzj.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            ayd();
            aye();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!w.z(aVar.dyZ)) {
            for (FeatureCardHot featureCardHot : aVar.dyZ) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    lg(featureCardHot.floor.intValue());
                    this.dzk[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!w.z(aVar.dza)) {
            for (FeatureCardTopic featureCardTopic : aVar.dza) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    lg(featureCardTopic.floor.intValue());
                    this.dzk[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!w.z(aVar.dzb)) {
            for (b bVar : aVar.dzb) {
                if (bVar != null && bVar.isValid()) {
                    lg(bVar.floor.intValue());
                    this.dzk[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!w.z(aVar.dzc)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dzc) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    lg(featureCardCompetition.floor.intValue());
                    this.dzk[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!w.z(aVar.dzd)) {
            for (FeatureCardGod featureCardGod : aVar.dzd) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    lg(featureCardGod.floor.intValue());
                    this.dzk[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!w.z(aVar.dze)) {
            for (FeatureCardGame featureCardGame : aVar.dze) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    lg(featureCardGame.floor.intValue());
                    this.dzk[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void lg(int i) {
        if (i >= this.dzk.length) {
            this.dzk = Arrays.copyOf(this.dzk, i + 1);
        }
    }

    private void ayd() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dzj.size()) {
                bb bbVar = this.dzj.get(i2);
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

    private void aye() {
        if (this.dzk != null && this.dzk.length > 0) {
            for (int i = 0; i < this.dzk.length; i++) {
                Object obj = this.dzk[i];
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
        gVar.a(aVar.dyY);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
