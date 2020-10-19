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
    private ArrayList<q> jwG;
    private bj jwJ;
    public boolean jwV;
    public int sortType;
    private f jwH = null;
    private n jwI = null;
    private PostForumData jwK = null;
    private i jwL = null;
    private a jwM = null;
    private a jwN = null;
    private a jwO = null;
    private g jwP = null;
    public d jwQ = null;
    private g jwR = null;
    private List<com.baidu.tieba.card.data.c> jwS = null;
    private List<q> jwT = null;
    private av pageData = null;
    private boolean hXq = true;
    private int jwU = 0;

    public e() {
        this.jwG = null;
        this.jwG = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hXq = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.jwH = new f();
                this.jwH.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.jwR = new g();
                this.jwR.a(dataRes.good_threads);
                this.jwS = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.nN(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.eji = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.hJx = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.ab(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.eji = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.Im("c10814");
                        this.jwS.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.jwI = new n();
                this.jwI.parserProtobuf(dataRes.relate_forum);
                this.jwJ = new bj();
                this.jwJ.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.jwJ.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.jwJ.title = dataRes.relate_forum_title;
                }
                this.jwJ.eon = R.color.cp_cont_c;
                ArrayList<bi> bhn = this.jwJ.bhn();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.cH(relateForum.forum_id.intValue());
                        biVar.Ao(relateForum.forum_name);
                        biVar.An(relateForum.avatar);
                        biVar.Ap(relateForum.desc);
                        biVar.nK(relateForum.thread_num.intValue());
                        biVar.nJ(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        bhn.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.jwK = new PostForumData();
                this.jwK.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.jwL = new i();
                this.jwL.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.jwM = new a();
                this.jwM.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.jwN = new a();
                this.jwN.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.jwO = new a();
                this.jwO.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.jwP = new g();
                this.jwP.a(dataRes.hot_thread);
                this.jwQ = new d();
                this.jwQ.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.jwV = this.pageData.bgX() != 0;
                }
                this.jwU = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.jwT = new ArrayList();
                boolean z = this.jwL != null;
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
                                cVar.kxi = false;
                                z2 = true;
                            }
                            this.jwT.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.jwT.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cHy();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fzF) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fzF) {
                this.jwG.add(cVar);
            }
        }
    }

    public void aE(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.eji = bwVar;
            lVar.eji.nN(5);
            this.jwG.add(0, lVar);
        }
    }

    public f cHp() {
        return this.jwH;
    }

    public i cHq() {
        return this.jwL;
    }

    public a cHr() {
        return this.jwM;
    }

    public a cHs() {
        return this.jwN;
    }

    public a cHt() {
        return this.jwO;
    }

    public n cHu() {
        return this.jwI;
    }

    public bj cHv() {
        return this.jwJ;
    }

    public ArrayList<q> cHw() {
        return this.jwG;
    }

    public List<q> cHx() {
        return this.jwT;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean cnq() {
        return this.hXq;
    }

    private ArrayList<q> cHy() {
        if (this.jwL != null) {
            this.jwG.add(this.jwL);
        }
        if (y.getCount(this.jwS) > 0) {
            this.jwG.add(this.jwR);
            if (this.jwS.size() > 5) {
                this.jwS = this.jwS.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.jwS) {
                this.jwG.add(cVar);
            }
        }
        if (this.jwI != null && this.jwI.getCount() > 0 && this.sortType == 1) {
            this.jwG.add(this.jwI);
        }
        if (this.jwQ != null && !y.isEmpty(this.jwQ.fzF)) {
            this.jwG.add(this.jwP);
            for (int i = 0; i < this.jwQ.fzF.size(); i++) {
                this.jwG.add((com.baidu.tieba.card.data.c) y.getItem(this.jwQ.fzF, i));
                if (this.jwI != null && this.jwI.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.jwG.add(this.jwI);
                }
            }
        }
        return this.jwG;
    }

    public int cHz() {
        return this.jwU;
    }
}
