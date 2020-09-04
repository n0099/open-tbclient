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
/* loaded from: classes15.dex */
public class e {
    private ArrayList<q> iZc;
    private bj iZf;
    public boolean iZr;
    public int sortType;
    private f iZd = null;
    private n iZe = null;
    private PostForumData iZg = null;
    private i iZh = null;
    private a iZi = null;
    private a iZj = null;
    private a iZk = null;
    private g iZl = null;
    public d iZm = null;
    private g iZn = null;
    private List<com.baidu.tieba.card.data.c> iZo = null;
    private List<q> iZp = null;
    private av pageData = null;
    private boolean hBt = true;
    private int iZq = 0;

    public e() {
        this.iZc = null;
        this.iZc = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hBt = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.iZd = new f();
                this.iZd.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.iZn = new g();
                this.iZn.a(dataRes.good_threads);
                this.iZo = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.nf(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.dUW = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.aa(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.hny = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.aa(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.dUW = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.Hc("c10814");
                        this.iZo.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.iZe = new n();
                this.iZe.parserProtobuf(dataRes.relate_forum);
                this.iZf = new bj();
                this.iZf.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.iZf.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.iZf.title = dataRes.relate_forum_title;
                }
                this.iZf.dZY = R.color.cp_cont_c;
                ArrayList<bi> bdK = this.iZf.bdK();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.cy(relateForum.forum_id.intValue());
                        biVar.zh(relateForum.forum_name);
                        biVar.zg(relateForum.avatar);
                        biVar.zi(relateForum.desc);
                        biVar.nc(relateForum.thread_num.intValue());
                        biVar.nb(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        bdK.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.iZg = new PostForumData();
                this.iZg.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.iZh = new i();
                this.iZh.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.iZi = new a();
                this.iZi.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.iZj = new a();
                this.iZj.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.iZk = new a();
                this.iZk.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.iZl = new g();
                this.iZl.a(dataRes.hot_thread);
                this.iZm = new d();
                this.iZm.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.iZr = this.pageData.bdu() != 0;
                }
                this.iZq = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.iZp = new ArrayList();
                boolean z = this.iZh != null;
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
                                cVar.jZs = false;
                                z2 = true;
                            }
                            this.iZp.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.iZp.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cAi();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fky) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fky) {
                this.iZc.add(cVar);
            }
        }
    }

    public void aD(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.dUW = bwVar;
            lVar.dUW.nf(5);
            this.iZc.add(0, lVar);
        }
    }

    public f czZ() {
        return this.iZd;
    }

    public i cAa() {
        return this.iZh;
    }

    public a cAb() {
        return this.iZi;
    }

    public a cAc() {
        return this.iZj;
    }

    public a cAd() {
        return this.iZk;
    }

    public n cAe() {
        return this.iZe;
    }

    public bj cAf() {
        return this.iZf;
    }

    public ArrayList<q> cAg() {
        return this.iZc;
    }

    public List<q> cAh() {
        return this.iZp;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean cgF() {
        return this.hBt;
    }

    private ArrayList<q> cAi() {
        if (this.iZh != null) {
            this.iZc.add(this.iZh);
        }
        if (y.getCount(this.iZo) > 0) {
            this.iZc.add(this.iZn);
            if (this.iZo.size() > 5) {
                this.iZo = this.iZo.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.iZo) {
                this.iZc.add(cVar);
            }
        }
        if (this.iZe != null && this.iZe.getCount() > 0 && this.sortType == 1) {
            this.iZc.add(this.iZe);
        }
        if (this.iZm != null && !y.isEmpty(this.iZm.fky)) {
            this.iZc.add(this.iZl);
            for (int i = 0; i < this.iZm.fky.size(); i++) {
                this.iZc.add((com.baidu.tieba.card.data.c) y.getItem(this.iZm.fky, i));
                if (this.iZe != null && this.iZe.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.iZc.add(this.iZe);
                }
            }
        }
        return this.iZc;
    }

    public int cAj() {
        return this.iZq;
    }
}
