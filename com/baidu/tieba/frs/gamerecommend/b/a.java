package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private Object[] hPD;
    private List<q> mData = new ArrayList();
    private List<bu> hPC = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.hPC.clear();
                this.hPD = new Object[aVar.hPp + 10];
            }
            if (!w.isEmpty(aVar.hPq)) {
                ArrayList arrayList = new ArrayList(aVar.hPq.size());
                for (bu buVar : aVar.hPq) {
                    if (buVar != null) {
                        arrayList.add(buVar);
                    }
                }
                this.hPC.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            ccw();
            ccx();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!w.isEmpty(aVar.hPs)) {
            for (FeatureCardHot featureCardHot : aVar.hPs) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    vp(featureCardHot.floor.intValue());
                    this.hPD[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!w.isEmpty(aVar.hPt)) {
            for (FeatureCardTopic featureCardTopic : aVar.hPt) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    vp(featureCardTopic.floor.intValue());
                    this.hPD[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!w.isEmpty(aVar.hPu)) {
            for (b bVar : aVar.hPu) {
                if (bVar != null && bVar.isValid()) {
                    vp(bVar.floor.intValue());
                    this.hPD[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!w.isEmpty(aVar.hPv)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.hPv) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    vp(featureCardCompetition.floor.intValue());
                    this.hPD[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!w.isEmpty(aVar.hPw)) {
            for (FeatureCardGod featureCardGod : aVar.hPw) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    vp(featureCardGod.floor.intValue());
                    this.hPD[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!w.isEmpty(aVar.hPx)) {
            for (FeatureCardGame featureCardGame : aVar.hPx) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    vp(featureCardGame.floor.intValue());
                    this.hPD[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void vp(int i) {
        if (i >= this.hPD.length) {
            this.hPD = Arrays.copyOf(this.hPD, i + 1);
        }
    }

    private void ccw() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hPC.size()) {
                bu buVar = this.hPC.get(i2);
                if (buVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(buVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(buVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ccx() {
        if (this.hPD != null && this.hPD.length > 0) {
            for (int i = 0; i < this.hPD.length; i++) {
                Object obj = this.hPD[i];
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
                        x xVar = new x();
                        xVar.a((FeatureCardGod) obj);
                        this.mData.add(i2, xVar);
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
        gVar.a(aVar.hPr);
        this.mData.add(0, gVar);
    }

    public List<q> getData() {
        return this.mData;
    }
}
