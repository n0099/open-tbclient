package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
    private ArrayList<com.baidu.adp.widget.ListView.n> kqE;
    private bm kqH;
    public boolean kqT;
    public int sortType;
    private f kqF = null;
    private n kqG = null;
    private PostForumData kqI = null;
    private i kqJ = null;
    private a kqK = null;
    private a kqL = null;
    private a kqM = null;
    private g kqN = null;
    public d kqO = null;
    private g kqP = null;
    private List<com.baidu.tieba.card.data.b> kqQ = null;
    private List<com.baidu.adp.widget.ListView.n> kqR = null;
    private ax pageData = null;
    private boolean iNJ = true;
    private int kqS = 0;

    public e() {
        this.kqE = null;
        this.kqE = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iNJ = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kqF = new f();
                this.kqF.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && x.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kqP = new g();
                this.kqP.a(dataRes.good_threads);
                this.kqQ = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bz bzVar = new bz();
                    bzVar.oM(5);
                    bzVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (bzVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.eMv = bzVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ad(bzVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(bzVar);
                        lVar.izh = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(bzVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eMv = bzVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.Jq("c10814");
                        this.kqQ.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kqG = new n();
                this.kqG.parserProtobuf(dataRes.relate_forum);
                this.kqH = new bm();
                this.kqH.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kqH.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kqH.title = dataRes.relate_forum_title;
                }
                this.kqH.eRL = R.color.CAM_X0108;
                ArrayList<bl> bqx = this.kqH.bqx();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bl blVar = new bl();
                        blVar.dE(relateForum.forum_id.intValue());
                        blVar.AV(relateForum.forum_name);
                        blVar.AU(relateForum.avatar);
                        blVar.AW(relateForum.desc);
                        blVar.oJ(relateForum.thread_num.intValue());
                        blVar.oI(relateForum.member_num.intValue());
                        blVar.setLike(relateForum.is_liked.intValue() != 0);
                        bqx.add(blVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.kqI = new PostForumData();
                this.kqI.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kqJ = new i();
                this.kqJ.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kqK = new a();
                this.kqK.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kqL = new a();
                this.kqL.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kqM = new a();
                this.kqM.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && x.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kqN = new g();
                this.kqN.a(dataRes.hot_thread);
                this.kqO = new d();
                this.kqO.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new ax();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kqT = this.pageData.bqg() != 0;
                }
                this.kqS = dataRes.is_global_block.intValue();
            }
            if (!x.isEmpty(dataRes.special_topic)) {
                this.kqR = new ArrayList();
                boolean z = this.kqJ != null;
                Iterator<SpecialTopic> it = dataRes.special_topic.iterator();
                while (true) {
                    boolean z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    SpecialTopic next = it.next();
                    if (x.isEmpty(next.thread_list)) {
                        z = z2;
                    } else {
                        if (!TextUtils.isEmpty(next.title)) {
                            com.baidu.tieba.newdetail.a.c cVar = new com.baidu.tieba.newdetail.a.c(next.title);
                            if (!z2) {
                                cVar.liO = false;
                                z2 = true;
                            }
                            this.kqR.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kqR.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cVj();
        }
    }

    public void a(d dVar) {
        if (dVar != null && x.getCount(dVar.geK) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.geK) {
                this.kqE.add(bVar);
            }
        }
    }

    public void aH(bz bzVar) {
        if (bzVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eMv = bzVar;
            kVar.eMv.oM(5);
            this.kqE.add(0, kVar);
        }
    }

    public f cVa() {
        return this.kqF;
    }

    public i cVb() {
        return this.kqJ;
    }

    public a cVc() {
        return this.kqK;
    }

    public a cVd() {
        return this.kqL;
    }

    public a cVe() {
        return this.kqM;
    }

    public n cVf() {
        return this.kqG;
    }

    public bm cVg() {
        return this.kqH;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cVh() {
        return this.kqE;
    }

    public List<com.baidu.adp.widget.ListView.n> cVi() {
        return this.kqR;
    }

    public ax getPageData() {
        return this.pageData;
    }

    public void a(ax axVar) {
        this.pageData = axVar;
    }

    public boolean czL() {
        return this.iNJ;
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cVj() {
        if (this.kqJ != null) {
            this.kqE.add(this.kqJ);
        }
        if (x.getCount(this.kqQ) > 0) {
            this.kqE.add(this.kqP);
            if (this.kqQ.size() > 5) {
                this.kqQ = this.kqQ.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kqQ) {
                this.kqE.add(bVar);
            }
        }
        if (this.kqG != null && this.kqG.getCount() > 0 && this.sortType == 1) {
            this.kqE.add(this.kqG);
        }
        if (this.kqO != null && !x.isEmpty(this.kqO.geK)) {
            this.kqE.add(this.kqN);
            for (int i = 0; i < this.kqO.geK.size(); i++) {
                this.kqE.add((com.baidu.tieba.card.data.b) x.getItem(this.kqO.geK, i));
                if (this.kqG != null && this.kqG.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kqE.add(this.kqG);
                }
            }
        }
        return this.kqE;
    }

    public int cVk() {
        return this.kqS;
    }
}
