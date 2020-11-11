package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.RelateForum;
import tbclient.Hottopic.SpecialTopic;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class e {
    private ArrayList<q> jPd;
    private bj jPg;
    public boolean jPs;
    public int sortType;
    private f jPe = null;
    private n jPf = null;
    private PostForumData jPh = null;
    private i jPi = null;
    private a jPj = null;
    private a jPk = null;
    private a jPl = null;
    private g jPm = null;
    public d jPn = null;
    private g jPo = null;
    private List<com.baidu.tieba.card.data.c> jPp = null;
    private List<q> jPq = null;
    private av pageData = null;
    private boolean ipP = true;
    private int jPr = 0;

    public e() {
        this.jPd = null;
        this.jPd = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ipP = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.jPe = new f();
                this.jPe.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.jPo = new g();
                this.jPo.a(dataRes.good_threads);
                this.jPp = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.oi(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.exA = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.ibR = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.exA = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.Jc("c10814");
                        this.jPp.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.jPf = new n();
                this.jPf.parserProtobuf(dataRes.relate_forum);
                this.jPg = new bj();
                this.jPg.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.jPg.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.jPg.title = dataRes.relate_forum_title;
                }
                this.jPg.eCC = R.color.cp_cont_c;
                ArrayList<bi> blG = this.jPg.blG();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.df(relateForum.forum_id.intValue());
                        biVar.AV(relateForum.forum_name);
                        biVar.AU(relateForum.avatar);
                        biVar.AW(relateForum.desc);
                        biVar.of(relateForum.thread_num.intValue());
                        biVar.oe(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        blG.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.jPh = new PostForumData();
                this.jPh.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.jPi = new i();
                this.jPi.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.jPj = new a();
                this.jPj.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.jPk = new a();
                this.jPk.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.jPl = new a();
                this.jPl.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.jPm = new g();
                this.jPm.a(dataRes.hot_thread);
                this.jPn = new d();
                this.jPn.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.jPs = this.pageData.blq() != 0;
                }
                this.jPr = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.jPq = new ArrayList();
                boolean z = this.jPi != null;
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
                                cVar.kPB = false;
                                z2 = true;
                            }
                            this.jPq.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.jPq.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cNg();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fNQ) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fNQ) {
                this.jPd.add(cVar);
            }
        }
    }

    public void aE(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.exA = bwVar;
            lVar.exA.oi(5);
            this.jPd.add(0, lVar);
        }
    }

    public f cMX() {
        return this.jPe;
    }

    public i cMY() {
        return this.jPi;
    }

    public a cMZ() {
        return this.jPj;
    }

    public a cNa() {
        return this.jPk;
    }

    public a cNb() {
        return this.jPl;
    }

    public n cNc() {
        return this.jPf;
    }

    public bj cNd() {
        return this.jPg;
    }

    public ArrayList<q> cNe() {
        return this.jPd;
    }

    public List<q> cNf() {
        return this.jPq;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean csY() {
        return this.ipP;
    }

    private ArrayList<q> cNg() {
        if (this.jPi != null) {
            this.jPd.add(this.jPi);
        }
        if (y.getCount(this.jPp) > 0) {
            this.jPd.add(this.jPo);
            if (this.jPp.size() > 5) {
                this.jPp = this.jPp.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.jPp) {
                this.jPd.add(cVar);
            }
        }
        if (this.jPf != null && this.jPf.getCount() > 0 && this.sortType == 1) {
            this.jPd.add(this.jPf);
        }
        if (this.jPn != null && !y.isEmpty(this.jPn.fNQ)) {
            this.jPd.add(this.jPm);
            for (int i = 0; i < this.jPn.fNQ.size(); i++) {
                this.jPd.add((com.baidu.tieba.card.data.c) y.getItem(this.jPn.fNQ, i));
                if (this.jPf != null && this.jPf.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.jPd.add(this.jPf);
                }
            }
        }
        return this.jPd;
    }

    public int cNh() {
        return this.jPr;
    }
}
