package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class e {
    private ArrayList<q> jPN;
    private bk jPQ;
    public boolean jQc;
    public int sortType;
    private f jPO = null;
    private n jPP = null;
    private PostForumData jPR = null;
    private i jPS = null;
    private a jPT = null;
    private a jPU = null;
    private a jPV = null;
    private g jPW = null;
    public d jPX = null;
    private g jPY = null;
    private List<com.baidu.tieba.card.data.b> jPZ = null;
    private List<q> jQa = null;
    private aw pageData = null;
    private boolean iqD = true;
    private int jQb = 0;

    public e() {
        this.jPN = null;
        this.jPN = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iqD = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.jPO = new f();
                this.jPO.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.jPY = new g();
                this.jPY.a(dataRes.good_threads);
                this.jPZ = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bx bxVar = new bx();
                    bxVar.oe(5);
                    bxVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (bxVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.evQ = bxVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ad(bxVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(bxVar);
                        lVar.ibN = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(bxVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.evQ = bxVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.ID("c10814");
                        this.jPZ.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.jPP = new n();
                this.jPP.parserProtobuf(dataRes.relate_forum);
                this.jPQ = new bk();
                this.jPQ.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.jPQ.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.jPQ.title = dataRes.relate_forum_title;
                }
                this.jPQ.eAT = R.color.CAM_X0108;
                ArrayList<bj> bkI = this.jPQ.bkI();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bj bjVar = new bj();
                        bjVar.df(relateForum.forum_id.intValue());
                        bjVar.Aq(relateForum.forum_name);
                        bjVar.Ap(relateForum.avatar);
                        bjVar.Ar(relateForum.desc);
                        bjVar.ob(relateForum.thread_num.intValue());
                        bjVar.oa(relateForum.member_num.intValue());
                        bjVar.setLike(relateForum.is_liked.intValue() != 0);
                        bkI.add(bjVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.jPR = new PostForumData();
                this.jPR.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.jPS = new i();
                this.jPS.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.jPT = new a();
                this.jPT.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.jPU = new a();
                this.jPU.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.jPV = new a();
                this.jPV.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.jPW = new g();
                this.jPW.a(dataRes.hot_thread);
                this.jPX = new d();
                this.jPX.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new aw();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.jQc = this.pageData.bks() != 0;
                }
                this.jQb = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.jQa = new ArrayList();
                boolean z = this.jPS != null;
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
                                cVar.kPO = false;
                                z2 = true;
                            }
                            this.jQa.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.jQa.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cMN();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fNt) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.fNt) {
                this.jPN.add(bVar);
            }
        }
    }

    public void aG(bx bxVar) {
        if (bxVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.evQ = bxVar;
            kVar.evQ.oe(5);
            this.jPN.add(0, kVar);
        }
    }

    public f cME() {
        return this.jPO;
    }

    public i cMF() {
        return this.jPS;
    }

    public a cMG() {
        return this.jPT;
    }

    public a cMH() {
        return this.jPU;
    }

    public a cMI() {
        return this.jPV;
    }

    public n cMJ() {
        return this.jPP;
    }

    public bk cMK() {
        return this.jPQ;
    }

    public ArrayList<q> cML() {
        return this.jPN;
    }

    public List<q> cMM() {
        return this.jQa;
    }

    public aw getPageData() {
        return this.pageData;
    }

    public void a(aw awVar) {
        this.pageData = awVar;
    }

    public boolean csB() {
        return this.iqD;
    }

    private ArrayList<q> cMN() {
        if (this.jPS != null) {
            this.jPN.add(this.jPS);
        }
        if (y.getCount(this.jPZ) > 0) {
            this.jPN.add(this.jPY);
            if (this.jPZ.size() > 5) {
                this.jPZ = this.jPZ.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.jPZ) {
                this.jPN.add(bVar);
            }
        }
        if (this.jPP != null && this.jPP.getCount() > 0 && this.sortType == 1) {
            this.jPN.add(this.jPP);
        }
        if (this.jPX != null && !y.isEmpty(this.jPX.fNt)) {
            this.jPN.add(this.jPW);
            for (int i = 0; i < this.jPX.fNt.size(); i++) {
                this.jPN.add((com.baidu.tieba.card.data.b) y.getItem(this.jPX.fNt, i));
                if (this.jPP != null && this.jPP.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.jPN.add(this.jPP);
                }
            }
        }
        return this.jPN;
    }

    public int cMO() {
        return this.jQb;
    }
}
