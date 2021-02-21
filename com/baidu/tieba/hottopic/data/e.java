package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class e {
    public boolean kuJ;
    private ArrayList<com.baidu.adp.widget.ListView.n> kuu;
    private bo kux;
    public int sortType;
    private f kuv = null;
    private n kuw = null;
    private PostForumData kuy = null;
    private i kuz = null;
    private a kuA = null;
    private a kuB = null;
    private a kuC = null;
    private g kuD = null;
    public d kuE = null;
    private g kuF = null;
    private List<com.baidu.tieba.card.data.b> kuG = null;
    private List<com.baidu.adp.widget.ListView.n> kuH = null;
    private az pageData = null;
    private boolean iOY = true;
    private int kuI = 0;

    public e() {
        this.kuu = null;
        this.kuu = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iOY = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kuv = new f();
                this.kuv.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kuF = new g();
                this.kuF.a(dataRes.good_threads);
                this.kuG = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    cb cbVar = new cb();
                    cbVar.nj(5);
                    cbVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (cbVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.eJQ = cbVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(cbVar);
                        lVar.iAy = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eJQ = cbVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.IR("c10814");
                        this.kuG.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kuw = new n();
                this.kuw.parserProtobuf(dataRes.relate_forum);
                this.kux = new bo();
                this.kux.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kux.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kux.title = dataRes.relate_forum_title;
                }
                this.kux.ePm = R.color.CAM_X0108;
                ArrayList<bn> bmW = this.kux.bmW();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bn bnVar = new bn();
                        bnVar.dK(relateForum.forum_id.intValue());
                        bnVar.Ab(relateForum.forum_name);
                        bnVar.Aa(relateForum.avatar);
                        bnVar.Ac(relateForum.desc);
                        bnVar.ng(relateForum.thread_num.intValue());
                        bnVar.nf(relateForum.member_num.intValue());
                        bnVar.setLike(relateForum.is_liked.intValue() != 0);
                        bmW.add(bnVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.kuy = new PostForumData();
                this.kuy.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kuz = new i();
                this.kuz.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kuA = new a();
                this.kuA.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kuB = new a();
                this.kuB.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kuC = new a();
                this.kuC.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kuD = new g();
                this.kuD.a(dataRes.hot_thread);
                this.kuE = new d();
                this.kuE.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new az();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kuJ = this.pageData.bmF() != 0;
                }
                this.kuI = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kuH = new ArrayList();
                boolean z = this.kuz != null;
                Iterator<SpecialTopic> it = dataRes.special_topic.iterator();
                while (true) {
                    boolean z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    SpecialTopic next = it.next();
                    if (y.isEmpty(next.thread_list)) {
                        z = z2;
                    } else {
                        if (!TextUtils.isEmpty(next.title)) {
                            com.baidu.tieba.newdetail.a.c cVar = new com.baidu.tieba.newdetail.a.c(next.title);
                            if (!z2) {
                                cVar.lmz = false;
                                z2 = true;
                            }
                            this.kuH.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kuH.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cTx();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.gcy) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.gcy) {
                this.kuu.add(bVar);
            }
        }
    }

    public void aI(cb cbVar) {
        if (cbVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eJQ = cbVar;
            kVar.eJQ.nj(5);
            this.kuu.add(0, kVar);
        }
    }

    public f cTo() {
        return this.kuv;
    }

    public i cTp() {
        return this.kuz;
    }

    public a cTq() {
        return this.kuA;
    }

    public a cTr() {
        return this.kuB;
    }

    public a cTs() {
        return this.kuC;
    }

    public n cTt() {
        return this.kuw;
    }

    public bo cTu() {
        return this.kux;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTv() {
        return this.kuu;
    }

    public List<com.baidu.adp.widget.ListView.n> cTw() {
        return this.kuH;
    }

    public az getPageData() {
        return this.pageData;
    }

    public void a(az azVar) {
        this.pageData = azVar;
    }

    public boolean cxm() {
        return this.iOY;
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTx() {
        if (this.kuz != null) {
            this.kuu.add(this.kuz);
        }
        if (y.getCount(this.kuG) > 0) {
            this.kuu.add(this.kuF);
            if (this.kuG.size() > 5) {
                this.kuG = this.kuG.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kuG) {
                this.kuu.add(bVar);
            }
        }
        if (this.kuw != null && this.kuw.getCount() > 0 && this.sortType == 1) {
            this.kuu.add(this.kuw);
        }
        if (this.kuE != null && !y.isEmpty(this.kuE.gcy)) {
            this.kuu.add(this.kuD);
            for (int i = 0; i < this.kuE.gcy.size(); i++) {
                this.kuu.add((com.baidu.tieba.card.data.b) y.getItem(this.kuE.gcy, i));
                if (this.kuw != null && this.kuw.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kuu.add(this.kuw);
                }
            }
        }
        return this.kuu;
    }

    public int cTy() {
        return this.kuI;
    }
}
