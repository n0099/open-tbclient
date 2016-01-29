package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.a.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.GoodThread;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class e {
    private ArrayList<u> bKR;
    private f bKS = null;
    private List<l> bKT = null;
    private m bKU = null;
    private h bKV = null;
    private a bKW = null;
    private a bKX = null;
    private g bKY = null;
    private d bKZ = null;
    private g bLa = null;
    private List<com.baidu.tieba.card.a.c> bLb = null;
    private com.baidu.tbadk.core.data.u bKQ = null;
    private boolean bLc = true;

    public e() {
        this.bKR = null;
        this.bKR = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bLc = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.bKS = new f();
                this.bKS.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && x.o(dataRes.good_threads.thread_list) != 0) {
                this.bLa = new g();
                this.bLa.a(dataRes.good_threads);
                this.bLb = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    ah ahVar = new ah();
                    ahVar.a(threadInfo);
                    r rVar = null;
                    if (r.b(ahVar)) {
                        rVar = new r(ahVar);
                    } else if (s.b(ahVar)) {
                        rVar = new s(ahVar);
                    } else if (q.b(ahVar)) {
                        q qVar = new q();
                        qVar.aSc = ahVar;
                        rVar = qVar;
                    }
                    if (rVar != null && rVar.isValid()) {
                        rVar.gT("c10814");
                        this.bLb.add(rVar);
                    }
                }
            }
            if (dataRes.thread_module != null) {
                this.bKT = new ArrayList();
                if (dataRes.thread_module.thread_module_1 != null && dataRes.thread_module.thread_module_1.thread_list != null && dataRes.thread_module.thread_module_1.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_1.module_name)) {
                    l lVar = new l();
                    lVar.a(dataRes.thread_module.thread_module_1);
                    this.bKT.add(lVar);
                    int size = dataRes.thread_module.thread_module_1.thread_list.size();
                    int i = size > 3 ? 3 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        GoodThread goodThread = dataRes.thread_module.thread_module_1.thread_list.get(i2);
                        if (!StringUtils.isNull(goodThread.title)) {
                            l lVar2 = new l();
                            lVar2.a(goodThread);
                            this.bKT.add(lVar2);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_2 != null && dataRes.thread_module.thread_module_2.thread_list != null && dataRes.thread_module.thread_module_2.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_2.module_name)) {
                    l lVar3 = new l();
                    lVar3.a(dataRes.thread_module.thread_module_2);
                    this.bKT.add(lVar3);
                    int size2 = dataRes.thread_module.thread_module_2.thread_list.size();
                    int i3 = size2 > 3 ? 3 : size2;
                    for (int i4 = 0; i4 < i3; i4++) {
                        GoodThread goodThread2 = dataRes.thread_module.thread_module_2.thread_list.get(i4);
                        if (!StringUtils.isNull(goodThread2.title)) {
                            l lVar4 = new l();
                            lVar4.a(goodThread2);
                            this.bKT.add(lVar4);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_3 != null && dataRes.thread_module.thread_module_3.thread_list != null && dataRes.thread_module.thread_module_3.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_3.module_name)) {
                    l lVar5 = new l();
                    lVar5.a(dataRes.thread_module.thread_module_3);
                    this.bKT.add(lVar5);
                    int size3 = dataRes.thread_module.thread_module_3.thread_list.size();
                    int i5 = size3 <= 3 ? size3 : 3;
                    for (int i6 = 0; i6 < i5; i6++) {
                        GoodThread goodThread3 = dataRes.thread_module.thread_module_3.thread_list.get(i6);
                        if (!StringUtils.isNull(goodThread3.title)) {
                            l lVar6 = new l();
                            lVar6.a(goodThread3);
                            this.bKT.add(lVar6);
                        }
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.bKU = new m();
                this.bKU.aM(dataRes.relate_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.bKV = new h();
                this.bKV.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.bKW = new a();
                this.bKW.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.bKX = new a();
                this.bKX.a(dataRes.candle_module);
            }
            if (dataRes.hot_thread != null && x.o(dataRes.hot_thread.thread_list) != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.bKY = new g();
                this.bKY.a(dataRes.hot_thread);
                this.bKZ = new d();
                this.bKZ.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.bKQ = new com.baidu.tbadk.core.data.u();
                    this.bKQ.a(dataRes.hot_thread.page);
                }
            }
            XW();
        }
    }

    public void a(d dVar) {
        if (dVar != null && x.o(dVar.bfi) != 0) {
            for (com.baidu.tieba.card.a.c cVar : dVar.bfi) {
                this.bKR.add(cVar);
            }
        }
    }

    public f XO() {
        return this.bKS;
    }

    public h XP() {
        return this.bKV;
    }

    public a XQ() {
        return this.bKW;
    }

    public a XR() {
        return this.bKX;
    }

    public m XS() {
        return this.bKU;
    }

    public ArrayList<u> XT() {
        return this.bKR;
    }

    public com.baidu.tbadk.core.data.u XU() {
        return this.bKQ;
    }

    public boolean XV() {
        return this.bLc;
    }

    private ArrayList<u> XW() {
        if (this.bKS != null && !StringUtils.isNull(this.bKS.Wm)) {
            this.bKR.add(this.bKS);
        }
        if (x.o(this.bLb) > 0) {
            this.bKR.add(this.bLa);
            if (this.bLb.size() > 3) {
                this.bLb = this.bLb.subList(0, 3);
            }
            for (com.baidu.tieba.card.a.c cVar : this.bLb) {
                this.bKR.add(cVar);
            }
        }
        if (this.bKU != null && this.bKU.getCount() > 0) {
            this.bKR.add(this.bKU);
        }
        if (this.bKV != null) {
            this.bKR.add(this.bKV);
        }
        if (this.bKT != null && this.bKT.size() != 0) {
            for (l lVar : this.bKT) {
                this.bKR.add(lVar);
            }
        }
        if (this.bKZ != null && this.bKZ.bfi != null && this.bKZ.bfi.size() > 0) {
            this.bKR.add(this.bKY);
            for (com.baidu.tieba.card.a.c cVar2 : this.bKZ.bfi) {
                this.bKR.add(cVar2);
            }
        }
        return this.bKR;
    }
}
