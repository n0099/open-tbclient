package com.baidu.tieba.frs.gamerecommend.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
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
    private Object[] dwx;
    private List<h> mData = new ArrayList();
    private List<bc> dww = new ArrayList();

    public void a(int i, com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (aVar != null) {
            if (1 == i) {
                this.mData.clear();
                this.dww.clear();
                this.dwx = new Object[aVar.dwj + 10];
            }
            if (!w.A(aVar.dwk)) {
                ArrayList arrayList = new ArrayList(aVar.dwk.size());
                for (bc bcVar : aVar.dwk) {
                    if (bcVar != null) {
                        arrayList.add(bcVar);
                    }
                }
                this.dww.addAll(arrayList);
            }
            if (1 == i) {
                a(aVar);
            }
            this.mData.clear();
            axy();
            axz();
            b(aVar);
        }
    }

    private void a(com.baidu.tieba.frs.gamerecommend.data.a aVar) {
        if (!w.A(aVar.dwm)) {
            for (FeatureCardHot featureCardHot : aVar.dwm) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    kV(featureCardHot.floor.intValue());
                    this.dwx[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!w.A(aVar.dwn)) {
            for (FeatureCardTopic featureCardTopic : aVar.dwn) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    kV(featureCardTopic.floor.intValue());
                    this.dwx[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!w.A(aVar.dwo)) {
            for (b bVar : aVar.dwo) {
                if (bVar != null && bVar.isValid()) {
                    kV(bVar.floor.intValue());
                    this.dwx[bVar.floor.intValue()] = bVar;
                }
            }
        }
        if (!w.A(aVar.dwp)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.dwp) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    kV(featureCardCompetition.floor.intValue());
                    this.dwx[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!w.A(aVar.dwq)) {
            for (FeatureCardGod featureCardGod : aVar.dwq) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    kV(featureCardGod.floor.intValue());
                    this.dwx[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (!w.A(aVar.dwr)) {
            for (FeatureCardGame featureCardGame : aVar.dwr) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    kV(featureCardGame.floor.intValue());
                    this.dwx[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    private void kV(int i) {
        if (i >= this.dwx.length) {
            this.dwx = Arrays.copyOf(this.dwx, i + 1);
        }
    }

    private void axy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dww.size()) {
                bc bcVar = this.dww.get(i2);
                if (bcVar != null) {
                    if (i2 % 4 == 0) {
                        com.baidu.tieba.e.a aVar = new com.baidu.tieba.e.a();
                        aVar.setData(bcVar);
                        this.mData.add(aVar);
                    } else {
                        com.baidu.tieba.e.b bVar = new com.baidu.tieba.e.b();
                        bVar.setData(bcVar);
                        this.mData.add(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void axz() {
        if (this.dwx != null && this.dwx.length > 0) {
            for (int i = 0; i < this.dwx.length; i++) {
                Object obj = this.dwx[i];
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
        gVar.a(aVar.dwl);
        this.mData.add(0, gVar);
    }

    public List<h> getData() {
        return this.mData;
    }
}
