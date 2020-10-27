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
    private ArrayList<q> jJf;
    private bj jJi;
    public boolean jJu;
    public int sortType;
    private f jJg = null;
    private n jJh = null;
    private PostForumData jJj = null;
    private i jJk = null;
    private a jJl = null;
    private a jJm = null;
    private a jJn = null;
    private g jJo = null;
    public d jJp = null;
    private g jJq = null;
    private List<com.baidu.tieba.card.data.c> jJr = null;
    private List<q> jJs = null;
    private av pageData = null;
    private boolean ijQ = true;
    private int jJt = 0;

    public e() {
        this.jJf = null;
        this.jJf = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ijQ = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.jJg = new f();
                this.jJg.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.jJq = new g();
                this.jJq.a(dataRes.good_threads);
                this.jJr = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.nY(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.erH = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.hVU = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.erH = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.IL("c10814");
                        this.jJr.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.jJh = new n();
                this.jJh.parserProtobuf(dataRes.relate_forum);
                this.jJi = new bj();
                this.jJi.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.jJi.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.jJi.title = dataRes.relate_forum_title;
                }
                this.jJi.ewK = R.color.cp_cont_c;
                ArrayList<bi> bjg = this.jJi.bjg();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.cJ(relateForum.forum_id.intValue());
                        biVar.AH(relateForum.forum_name);
                        biVar.AG(relateForum.avatar);
                        biVar.AI(relateForum.desc);
                        biVar.nV(relateForum.thread_num.intValue());
                        biVar.nU(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        bjg.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.jJj = new PostForumData();
                this.jJj.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.jJk = new i();
                this.jJk.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.jJl = new a();
                this.jJl.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.jJm = new a();
                this.jJm.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.jJn = new a();
                this.jJn.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.jJo = new g();
                this.jJo.a(dataRes.hot_thread);
                this.jJp = new d();
                this.jJp.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.jJu = this.pageData.biQ() != 0;
                }
                this.jJt = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.jJs = new ArrayList();
                boolean z = this.jJk != null;
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
                                cVar.kJF = false;
                                z2 = true;
                            }
                            this.jJs.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.jJs.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cKF();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fIa) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fIa) {
                this.jJf.add(cVar);
            }
        }
    }

    public void aE(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.erH = bwVar;
            lVar.erH.nY(5);
            this.jJf.add(0, lVar);
        }
    }

    public f cKw() {
        return this.jJg;
    }

    public i cKx() {
        return this.jJk;
    }

    public a cKy() {
        return this.jJl;
    }

    public a cKz() {
        return this.jJm;
    }

    public a cKA() {
        return this.jJn;
    }

    public n cKB() {
        return this.jJh;
    }

    public bj cKC() {
        return this.jJi;
    }

    public ArrayList<q> cKD() {
        return this.jJf;
    }

    public List<q> cKE() {
        return this.jJs;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean cqx() {
        return this.ijQ;
    }

    private ArrayList<q> cKF() {
        if (this.jJk != null) {
            this.jJf.add(this.jJk);
        }
        if (y.getCount(this.jJr) > 0) {
            this.jJf.add(this.jJq);
            if (this.jJr.size() > 5) {
                this.jJr = this.jJr.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.jJr) {
                this.jJf.add(cVar);
            }
        }
        if (this.jJh != null && this.jJh.getCount() > 0 && this.sortType == 1) {
            this.jJf.add(this.jJh);
        }
        if (this.jJp != null && !y.isEmpty(this.jJp.fIa)) {
            this.jJf.add(this.jJo);
            for (int i = 0; i < this.jJp.fIa.size(); i++) {
                this.jJf.add((com.baidu.tieba.card.data.c) y.getItem(this.jJp.fIa, i));
                if (this.jJh != null && this.jJh.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.jJf.add(this.jJh);
                }
            }
        }
        return this.jJf;
    }

    public int cKG() {
        return this.jJt;
    }
}
