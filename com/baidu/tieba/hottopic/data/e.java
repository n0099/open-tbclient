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
    private ArrayList<q> iYW;
    private bj iYZ;
    public boolean iZl;
    public int sortType;
    private f iYX = null;
    private n iYY = null;
    private PostForumData iZa = null;
    private i iZb = null;
    private a iZc = null;
    private a iZd = null;
    private a iZe = null;
    private g iZf = null;
    public d iZg = null;
    private g iZh = null;
    private List<com.baidu.tieba.card.data.c> iZi = null;
    private List<q> iZj = null;
    private av pageData = null;
    private boolean hBn = true;
    private int iZk = 0;

    public e() {
        this.iYW = null;
        this.iYW = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hBn = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.iYX = new f();
                this.iYX.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.iZh = new g();
                this.iZh.a(dataRes.good_threads);
                this.iZi = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bw bwVar = new bw();
                    bwVar.nf(5);
                    bwVar.a(threadInfo);
                    com.baidu.tieba.card.data.l lVar = null;
                    if (bwVar.isShareThread) {
                        com.baidu.tieba.card.data.l lVar2 = new com.baidu.tieba.card.data.l();
                        lVar2.dUS = bwVar;
                        lVar = lVar2;
                    } else if (com.baidu.tieba.card.data.m.aa(bwVar)) {
                        com.baidu.tieba.card.data.m mVar = new com.baidu.tieba.card.data.m(bwVar);
                        mVar.hnu = true;
                        lVar = mVar;
                    } else if (com.baidu.tieba.card.data.l.aa(bwVar)) {
                        com.baidu.tieba.card.data.l lVar3 = new com.baidu.tieba.card.data.l();
                        lVar3.dUS = bwVar;
                        lVar = lVar3;
                    }
                    if (lVar != null && lVar.isValid()) {
                        lVar.Hb("c10814");
                        this.iZi.add(lVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.iYY = new n();
                this.iYY.parserProtobuf(dataRes.relate_forum);
                this.iYZ = new bj();
                this.iYZ.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.iYZ.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.iYZ.title = dataRes.relate_forum_title;
                }
                this.iYZ.dZU = R.color.cp_cont_c;
                ArrayList<bi> bdK = this.iYZ.bdK();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bi biVar = new bi();
                        biVar.cy(relateForum.forum_id.intValue());
                        biVar.zg(relateForum.forum_name);
                        biVar.zf(relateForum.avatar);
                        biVar.zh(relateForum.desc);
                        biVar.nc(relateForum.thread_num.intValue());
                        biVar.nb(relateForum.member_num.intValue());
                        biVar.setLike(relateForum.is_liked.intValue() != 0);
                        bdK.add(biVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.iZa = new PostForumData();
                this.iZa.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.iZb = new i();
                this.iZb.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.iZc = new a();
                this.iZc.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.iZd = new a();
                this.iZd.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.iZe = new a();
                this.iZe.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.iZf = new g();
                this.iZf.a(dataRes.hot_thread);
                this.iZg = new d();
                this.iZg.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new av();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.iZl = this.pageData.bdu() != 0;
                }
                this.iZk = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.iZj = new ArrayList();
                boolean z = this.iZb != null;
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
                                cVar.jZl = false;
                                z2 = true;
                            }
                            this.iZj.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.iZj.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cAh();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fku) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.fku) {
                this.iYW.add(cVar);
            }
        }
    }

    public void aD(bw bwVar) {
        if (bwVar != null) {
            com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l();
            lVar.dUS = bwVar;
            lVar.dUS.nf(5);
            this.iYW.add(0, lVar);
        }
    }

    public f czY() {
        return this.iYX;
    }

    public i czZ() {
        return this.iZb;
    }

    public a cAa() {
        return this.iZc;
    }

    public a cAb() {
        return this.iZd;
    }

    public a cAc() {
        return this.iZe;
    }

    public n cAd() {
        return this.iYY;
    }

    public bj cAe() {
        return this.iYZ;
    }

    public ArrayList<q> cAf() {
        return this.iYW;
    }

    public List<q> cAg() {
        return this.iZj;
    }

    public av getPageData() {
        return this.pageData;
    }

    public void a(av avVar) {
        this.pageData = avVar;
    }

    public boolean cgE() {
        return this.hBn;
    }

    private ArrayList<q> cAh() {
        if (this.iZb != null) {
            this.iYW.add(this.iZb);
        }
        if (y.getCount(this.iZi) > 0) {
            this.iYW.add(this.iZh);
            if (this.iZi.size() > 5) {
                this.iZi = this.iZi.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.iZi) {
                this.iYW.add(cVar);
            }
        }
        if (this.iYY != null && this.iYY.getCount() > 0 && this.sortType == 1) {
            this.iYW.add(this.iYY);
        }
        if (this.iZg != null && !y.isEmpty(this.iZg.fku)) {
            this.iYW.add(this.iZf);
            for (int i = 0; i < this.iZg.fku.size(); i++) {
                this.iYW.add((com.baidu.tieba.card.data.c) y.getItem(this.iZg.fku, i));
                if (this.iYY != null && this.iYY.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.iYW.add(this.iYY);
                }
            }
        }
        return this.iYW;
    }

    public int cAi() {
        return this.iZk;
    }
}
