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
    private ArrayList<q> iJW;
    private bi iJZ;
    public boolean iKl;
    public int sortType;
    private f iJX = null;
    private n iJY = null;
    private PostForumData iKa = null;
    private i iKb = null;
    private a iKc = null;
    private a iKd = null;
    private a iKe = null;
    private g iKf = null;
    public d iKg = null;
    private g iKh = null;
    private List<com.baidu.tieba.card.data.c> iKi = null;
    private List<q> iKj = null;
    private au pageData = null;
    private boolean how = true;
    private int iKk = 0;

    public e() {
        this.iJW = null;
        this.iJW = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.how = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.iJX = new f();
                this.iJX.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && x.getCount(dataRes.good_threads.thread_list) != 0) {
                this.iKh = new g();
                this.iKh.a(dataRes.good_threads);
                this.iKi = new ArrayList();
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
                        this.iKi.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.iJY = new n();
                this.iJY.parserProtobuf(dataRes.relate_forum);
                this.iJZ = new bi();
                this.iJZ.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.iJZ.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.iJZ.title = dataRes.relate_forum_title;
                }
                this.iJZ.dQB = R.color.cp_cont_c;
                ArrayList<bh> aVr = this.iJZ.aVr();
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
                this.iKa = new PostForumData();
                this.iKa.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.iKb = new i();
                this.iKb.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.iKc = new a();
                this.iKc.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.iKd = new a();
                this.iKd.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.iKe = new a();
                this.iKe.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && x.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.iKf = new g();
                this.iKf.a(dataRes.hot_thread);
                this.iKg = new d();
                this.iKg.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new au();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.iKl = this.pageData.aVb() != 0;
                }
                this.iKk = dataRes.is_global_block.intValue();
            }
            if (!x.isEmpty(dataRes.special_topic)) {
                this.iKj = new ArrayList();
                boolean z = this.iKb != null;
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
                                cVar.jJS = false;
                                z2 = true;
                            }
                            this.iKj.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.iKj.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
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
                this.iJW.add(cVar);
            }
        }
    }

    public void aC(bv bvVar) {
        if (bvVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.dLK = bvVar;
            kVar.dLK.kZ(5);
            this.iJW.add(0, kVar);
        }
    }

    public f cpf() {
        return this.iJX;
    }

    public i cpg() {
        return this.iKb;
    }

    public a cph() {
        return this.iKc;
    }

    public a cpi() {
        return this.iKd;
    }

    public a cpj() {
        return this.iKe;
    }

    public n cpk() {
        return this.iJY;
    }

    public bi cpl() {
        return this.iJZ;
    }

    public ArrayList<q> cpm() {
        return this.iJW;
    }

    public List<q> cpn() {
        return this.iKj;
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
        if (this.iKb != null) {
            this.iJW.add(this.iKb);
        }
        if (x.getCount(this.iKi) > 0) {
            this.iJW.add(this.iKh);
            if (this.iKi.size() > 5) {
                this.iKi = this.iKi.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.iKi) {
                this.iJW.add(cVar);
            }
        }
        if (this.iJY != null && this.iJY.getCount() > 0 && this.sortType == 1) {
            this.iJW.add(this.iJY);
        }
        if (this.iKg != null && !x.isEmpty(this.iKg.eZc)) {
            this.iJW.add(this.iKf);
            for (int i = 0; i < this.iKg.eZc.size(); i++) {
                this.iJW.add((com.baidu.tieba.card.data.c) x.getItem(this.iKg.eZc, i));
                if (this.iJY != null && this.iJY.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.iJW.add(this.iJY);
                }
            }
        }
        return this.iJW;
    }

    public int cpp() {
        return this.iKk;
    }
}
