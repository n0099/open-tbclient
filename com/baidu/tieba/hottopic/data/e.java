package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
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
    private ArrayList<q> iJY;
    private bi iKb;
    public boolean iKn;
    public int sortType;
    private f iJZ = null;
    private n iKa = null;
    private PostForumData iKc = null;
    private i iKd = null;
    private a iKe = null;
    private a iKf = null;
    private a iKg = null;
    private g iKh = null;
    public d iKi = null;
    private g iKj = null;
    private List<com.baidu.tieba.card.data.c> iKk = null;
    private List<q> iKl = null;
    private au pageData = null;
    private boolean how = true;
    private int iKm = 0;

    public e() {
        this.iJY = null;
        this.iJY = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.how = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.iJZ = new f();
                this.iJZ.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && x.getCount(dataRes.good_threads.thread_list) != 0) {
                this.iKj = new g();
                this.iKj.a(dataRes.good_threads);
                this.iKk = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bv bvVar = new bv();
                    bvVar.kZ(5);
                    bvVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (bvVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.dLK = bvVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.aa(bvVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(bvVar);
                        lVar.haD = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.aa(bvVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.dLK = bvVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.EC("c10814");
                        this.iKk.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.iKa = new n();
                this.iKa.parserProtobuf(dataRes.relate_forum);
                this.iKb = new bi();
                this.iKb.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.iKb.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.iKb.title = dataRes.relate_forum_title;
                }
                this.iKb.dQB = R.color.cp_cont_c;
                ArrayList<bh> aVr = this.iKb.aVr();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bh bhVar = new bh();
                        bhVar.co(relateForum.forum_id.intValue());
                        bhVar.wS(relateForum.forum_name);
                        bhVar.wR(relateForum.avatar);
                        bhVar.wT(relateForum.desc);
                        bhVar.kW(relateForum.thread_num.intValue());
                        bhVar.kV(relateForum.member_num.intValue());
                        bhVar.setLike(relateForum.is_liked.intValue() != 0);
                        aVr.add(bhVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.iKc = new PostForumData();
                this.iKc.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.iKd = new i();
                this.iKd.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.iKe = new a();
                this.iKe.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.iKf = new a();
                this.iKf.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.iKg = new a();
                this.iKg.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && x.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.iKh = new g();
                this.iKh.a(dataRes.hot_thread);
                this.iKi = new d();
                this.iKi.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new au();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.iKn = this.pageData.aVb() != 0;
                }
                this.iKm = dataRes.is_global_block.intValue();
            }
            if (!x.isEmpty(dataRes.special_topic)) {
                this.iKl = new ArrayList();
                boolean z = this.iKd != null;
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
                                cVar.jJU = false;
                                z2 = true;
                            }
                            this.iKl.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.iKl.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cpo();
        }
    }

    public void a(d dVar) {
        if (dVar != null && x.getCount(dVar.eZc) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.eZc) {
                this.iJY.add(cVar);
            }
        }
    }

    public void aC(bv bvVar) {
        if (bvVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.dLK = bvVar;
            kVar.dLK.kZ(5);
            this.iJY.add(0, kVar);
        }
    }

    public f cpf() {
        return this.iJZ;
    }

    public i cpg() {
        return this.iKd;
    }

    public a cph() {
        return this.iKe;
    }

    public a cpi() {
        return this.iKf;
    }

    public a cpj() {
        return this.iKg;
    }

    public n cpk() {
        return this.iKa;
    }

    public bi cpl() {
        return this.iKb;
    }

    public ArrayList<q> cpm() {
        return this.iJY;
    }

    public List<q> cpn() {
        return this.iKl;
    }

    public au getPageData() {
        return this.pageData;
    }

    public void a(au auVar) {
        this.pageData = auVar;
    }

    public boolean bWr() {
        return this.how;
    }

    private ArrayList<q> cpo() {
        if (this.iKd != null) {
            this.iJY.add(this.iKd);
        }
        if (x.getCount(this.iKk) > 0) {
            this.iJY.add(this.iKj);
            if (this.iKk.size() > 5) {
                this.iKk = this.iKk.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.iKk) {
                this.iJY.add(cVar);
            }
        }
        if (this.iKa != null && this.iKa.getCount() > 0 && this.sortType == 1) {
            this.iJY.add(this.iKa);
        }
        if (this.iKi != null && !x.isEmpty(this.iKi.eZc)) {
            this.iJY.add(this.iKh);
            for (int i = 0; i < this.iKi.eZc.size(); i++) {
                this.iJY.add((com.baidu.tieba.card.data.c) x.getItem(this.iKi.eZc, i));
                if (this.iKa != null && this.iKa.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.iJY.add(this.iKa);
                }
            }
        }
        return this.iJY;
    }

    public int cpp() {
        return this.iKm;
    }
}
