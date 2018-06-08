package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.frs.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private Object[] dto;
    private List<h> mData = new ArrayList();
    private List<bd> dtn = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dtn.clear();
                this.dto = new Object[aVar.dta + 10];
            }
            if (!w.z(aVar.dtb)) {
                ArrayList arrayList = new ArrayList(aVar.dtb.size());
                for (bd bdVar : aVar.dtb) {
                    if (bdVar != null) {
                        arrayList.add(bdVar);
                    }
                }
                this.dtn.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            awU();
            awV();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!w.z(aVar.dtd)) {
            for (FeatureCardHot featureCardHot : aVar.dtd) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    kO(featureCardHot.floor.intValue());
                    this.dto[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!w.z(aVar.dte)) {
            for (FeatureCardTopic featureCardTopic : aVar.dte) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    kO(featureCardTopic.floor.intValue());
                    this.dto[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!w.z(aVar.dtf)) {
            for (b bVar : aVar.dtf) {
                if (bVar != null && bVar.isValid()) {
                    kO(bVar.floor.intValue());
                    this.dto[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!w.z(aVar.dtg)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dtg) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    kO(featureCardCompetition.floor.intValue());
                    this.dto[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!w.z(aVar.dth)) {
            for (FeatureCardGod featureCardGod : aVar.dth) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    kO(featureCardGod.floor.intValue());
                    this.dto[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!w.z(aVar.dti)) {
            for (FeatureCardGame featureCardGame : aVar.dti) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    kO(featureCardGame.floor.intValue());
                    this.dto[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void kO(int i) {
        if (i >= this.dto.length) {
            this.dto = Arrays.copyOf(this.dto, i + 1);
        }
    }

    private void awU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dtn.size()) {
                bd bdVar = this.dtn.get(i2);
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

    private void awV() {
        if (this.dto != null && this.dto.length > 0) {
            for (int i = 0; i < this.dto.length; i++) {
                Object obj = this.dto[i];
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
        gVar.a(aVar.dtc);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
