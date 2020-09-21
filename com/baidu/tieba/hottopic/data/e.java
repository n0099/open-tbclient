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
/* loaded from: classes20.dex */
public class e {
    private ArrayList<q> jhH;
    private bj jhK;
    public boolean jhW;
    public int sortType;
    private f jhI = null;
    private n jhJ = null;
    private PostForumData jhL = null;
    private i jhM = null;
    private a jhN = null;
    private a jhO = null;
    private a jhP = null;
    private g jhQ = null;
    public d jhR = null;
    private g jhS = null;
    private List<com.baidu.tieba.card.data.c> jhT = null;
    private List<q> jhU = null;
    private av pageData = null;
    private boolean hIv = true;
    private int jhV = 0;

    public e() {
        this.jhH = null;
        this.jhH = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hIv = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.jhI = new f();
                this.jhI.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.jhS = new g();
                this.jhS.a(dataRes.good_threads);
                this.jhT = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.nq(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.dXg = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.huC = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.dXg = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.Hz("c10814");
                        this.jhT.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.jhJ = new n();
                this.jhJ.parserProtobuf(dataRes.relate_forum);
                this.jhK = new bj();
                this.jhK.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.jhK.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.jhK.title = dataRes.relate_forum_title;
                }
                this.jhK.eci = R.color.cp_cont_c;
                ArrayList<bi> beE = this.jhK.beE();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.cz(relateForum.forum_id.intValue());
                        biVar.zC(relateForum.forum_name);
                        biVar.zB(relateForum.avatar);
                        biVar.zD(relateForum.desc);
                        biVar.nn(relateForum.thread_num.intValue());
                        biVar.nm(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        beE.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.jhL = new PostForumData();
                this.jhL.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.jhM = new i();
                this.jhM.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.jhN = new a();
                this.jhN.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.jhO = new a();
                this.jhO.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.jhP = new a();
                this.jhP.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.jhQ = new g();
                this.jhQ.a(dataRes.hot_thread);
                this.jhR = new d();
                this.jhR.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.jhW = this.pageData.beo() != 0;
                }
                this.jhV = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.jhU = new ArrayList();
                boolean z = this.jhM != null;
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
                                cVar.khV = false;
                                z2 = true;
                            }
                            this.jhU.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.jhU.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cDP();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fnr) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fnr) {
                this.jhH.add(cVar);
            }
        }
    }

    public void aE(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.dXg = bwVar;
            lVar.dXg.nq(5);
            this.jhH.add(0, lVar);
        }
    }

    public f cDG() {
        return this.jhI;
    }

    public i cDH() {
        return this.jhM;
    }

    public a cDI() {
        return this.jhN;
    }

    public a cDJ() {
        return this.jhO;
    }

    public a cDK() {
        return this.jhP;
    }

    public n cDL() {
        return this.jhJ;
    }

    public bj cDM() {
        return this.jhK;
    }

    public ArrayList<q> cDN() {
        return this.jhH;
    }

    public List<q> cDO() {
        return this.jhU;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean cjU() {
        return this.hIv;
    }

    private ArrayList<q> cDP() {
        if (this.jhM != null) {
            this.jhH.add(this.jhM);
        }
        if (y.getCount(this.jhT) > 0) {
            this.jhH.add(this.jhS);
            if (this.jhT.size() > 5) {
                this.jhT = this.jhT.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.jhT) {
                this.jhH.add(cVar);
            }
        }
        if (this.jhJ != null && this.jhJ.getCount() > 0 && this.sortType == 1) {
            this.jhH.add(this.jhJ);
        }
        if (this.jhR != null && !y.isEmpty(this.jhR.fnr)) {
            this.jhH.add(this.jhQ);
            for (int i = 0; i < this.jhR.fnr.size(); i++) {
                this.jhH.add((com.baidu.tieba.card.data.c) y.getItem(this.jhR.fnr, i));
                if (this.jhJ != null && this.jhJ.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.jhH.add(this.jhJ);
                }
            }
        }
        return this.jhH;
    }

    public int cDQ() {
        return this.jhV;
    }
}
