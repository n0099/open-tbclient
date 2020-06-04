package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.frs.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] hCv;
    private List<o> mData = new ArrayList();
    private List<bk> hCu = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hCu.clear();
                this.hCv = new Object[aVar.hCh + 10];
            }
            if (!v.isEmpty(aVar.hCi)) {
                ArrayList arrayList = new ArrayList(aVar.hCi.size());
                for (bk bkVar : aVar.hCi) {
                    if (bkVar != null) {
                        arrayList.add(bkVar);
                    }
                }
                this.hCu.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            bZg();
            bZh();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!v.isEmpty(aVar.hCk)) {
            for (FeatureCardHot featureCardHot : aVar.hCk) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    uK(featureCardHot.floor.intValue());
                    this.hCv[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!v.isEmpty(aVar.hCl)) {
            for (FeatureCardTopic featureCardTopic : aVar.hCl) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    uK(featureCardTopic.floor.intValue());
                    this.hCv[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!v.isEmpty(aVar.hCm)) {
            for (b bVar : aVar.hCm) {
                if (bVar != null && bVar.isValid()) {
                    uK(bVar.floor.intValue());
                    this.hCv[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!v.isEmpty(aVar.hCn)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hCn) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    uK(featureCardCompetition.floor.intValue());
                    this.hCv[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!v.isEmpty(aVar.hCo)) {
            for (FeatureCardGod featureCardGod : aVar.hCo) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    uK(featureCardGod.floor.intValue());
                    this.hCv[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!v.isEmpty(aVar.hCp)) {
            for (FeatureCardGame featureCardGame : aVar.hCp) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    uK(featureCardGame.floor.intValue());
                    this.hCv[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void uK(int i) {
        if (i >= this.hCv.length) {
            this.hCv = Arrays.copyOf(this.hCv, i + 1);
        }
    }

    private void bZg() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hCu.size()) {
                bk bkVar = this.hCu.get(i2);
                if (bkVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bkVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bkVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void bZh() {
        if (this.hCv != null && this.hCv.length > 0) {
            for (int i = 0; i < this.hCv.length; i++) {
                Object obj = this.hCv[i];
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
                        u uVar = new u();
                        uVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, uVar);
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
        gVar.a(aVar.hCj);
        this.mData.add(0, gVar);
    }

    public List<o> getData() {
        return this.mData;
    }
}
