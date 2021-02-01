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
    private ArrayList<com.baidu.adp.widget.ListView.n> kug;
    private bo kuj;
    public boolean kuv;
    public int sortType;
    private f kuh = null;
    private n kui = null;
    private PostForumData kuk = null;
    private i kul = null;
    private a kum = null;
    private a kun = null;
    private a kuo = null;
    private g kup = null;
    public d kuq = null;
    private g kur = null;
    private List<com.baidu.tieba.card.data.b> kus = null;
    private List<com.baidu.adp.widget.ListView.n> kut = null;
    private az pageData = null;
    private boolean iOK = true;
    private int kuu = 0;

    public e() {
        this.kug = null;
        this.kug = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iOK = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kuh = new f();
                this.kuh.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kur = new g();
                this.kur.a(dataRes.good_threads);
                this.kus = new ArrayList();
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
                        lVar.iAk = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eJQ = cbVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.IQ("c10814");
                        this.kus.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kui = new n();
                this.kui.parserProtobuf(dataRes.relate_forum);
                this.kuj = new bo();
                this.kuj.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kuj.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kuj.title = dataRes.relate_forum_title;
                }
                this.kuj.ePm = R.color.CAM_X0108;
                ArrayList<bn> bmW = this.kuj.bmW();
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
                this.kuk = new PostForumData();
                this.kuk.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kul = new i();
                this.kul.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kum = new a();
                this.kum.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kun = new a();
                this.kun.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kuo = new a();
                this.kuo.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kup = new g();
                this.kup.a(dataRes.hot_thread);
                this.kuq = new d();
                this.kuq.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new az();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kuv = this.pageData.bmF() != 0;
                }
                this.kuu = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kut = new ArrayList();
                boolean z = this.kul != null;
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
                                cVar.lml = false;
                                z2 = true;
                            }
                            this.kut.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kut.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cTq();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.gcs) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.gcs) {
                this.kug.add(bVar);
            }
        }
    }

    public void aI(cb cbVar) {
        if (cbVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eJQ = cbVar;
            kVar.eJQ.nj(5);
            this.kug.add(0, kVar);
        }
    }

    public f cTh() {
        return this.kuh;
    }

    public i cTi() {
        return this.kul;
    }

    public a cTj() {
        return this.kum;
    }

    public a cTk() {
        return this.kun;
    }

    public a cTl() {
        return this.kuo;
    }

    public n cTm() {
        return this.kui;
    }

    public bo cTn() {
        return this.kuj;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTo() {
        return this.kug;
    }

    public List<com.baidu.adp.widget.ListView.n> cTp() {
        return this.kut;
    }

    public az getPageData() {
        return this.pageData;
    }

    public void a(az azVar) {
        this.pageData = azVar;
    }

    public boolean cxf() {
        return this.iOK;
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTq() {
        if (this.kul != null) {
            this.kug.add(this.kul);
        }
        if (y.getCount(this.kus) > 0) {
            this.kug.add(this.kur);
            if (this.kus.size() > 5) {
                this.kus = this.kus.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kus) {
                this.kug.add(bVar);
            }
        }
        if (this.kui != null && this.kui.getCount() > 0 && this.sortType == 1) {
            this.kug.add(this.kui);
        }
        if (this.kuq != null && !y.isEmpty(this.kuq.gcs)) {
            this.kug.add(this.kup);
            for (int i = 0; i < this.kuq.gcs.size(); i++) {
                this.kug.add((com.baidu.tieba.card.data.b) y.getItem(this.kuq.gcs, i));
                if (this.kui != null && this.kui.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kug.add(this.kui);
                }
            }
        }
        return this.kug;
    }

    public int cTr() {
        return this.kuu;
    }
}
