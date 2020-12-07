package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.by;
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
    public boolean kdF;
    private ArrayList<q> kdq;
    private bl kdt;
    public int sortType;
    private f kdr = null;
    private n kds = null;
    private PostForumData kdu = null;
    private i kdv = null;
    private a kdw = null;
    private a kdx = null;
    private a kdy = null;
    private g kdz = null;
    public d kdA = null;
    private g kdB = null;
    private List<com.baidu.tieba.card.data.b> kdC = null;
    private List<q> kdD = null;
    private ax pageData = null;
    private boolean iBv = true;
    private int kdE = 0;

    public e() {
        this.kdq = null;
        this.kdq = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iBv = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kdr = new f();
                this.kdr.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kdB = new g();
                this.kdB.a(dataRes.good_threads);
                this.kdC = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    by byVar = new by();
                    byVar.oC(5);
                    byVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (byVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.eCR = byVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ad(byVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(byVar);
                        lVar.imK = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(byVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eCR = byVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.Jt("c10814");
                        this.kdC.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kds = new n();
                this.kds.parserProtobuf(dataRes.relate_forum);
                this.kdt = new bl();
                this.kdt.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kdt.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kdt.title = dataRes.relate_forum_title;
                }
                this.kdt.eHT = R.color.CAM_X0108;
                ArrayList<bk> bnV = this.kdt.bnV();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bk bkVar = new bk();
                        bkVar.dE(relateForum.forum_id.intValue());
                        bkVar.AX(relateForum.forum_name);
                        bkVar.AW(relateForum.avatar);
                        bkVar.AY(relateForum.desc);
                        bkVar.oz(relateForum.thread_num.intValue());
                        bkVar.oy(relateForum.member_num.intValue());
                        bkVar.setLike(relateForum.is_liked.intValue() != 0);
                        bnV.add(bkVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.kdu = new PostForumData();
                this.kdu.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kdv = new i();
                this.kdv.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kdw = new a();
                this.kdw.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kdx = new a();
                this.kdx.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kdy = new a();
                this.kdy.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kdz = new g();
                this.kdz.a(dataRes.hot_thread);
                this.kdA = new d();
                this.kdA.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new ax();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kdF = this.pageData.bnF() != 0;
                }
                this.kdE = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kdD = new ArrayList();
                boolean z = this.kdv != null;
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
                                cVar.ldg = false;
                                z2 = true;
                            }
                            this.kdD.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kdD.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cSb();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fVe) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.fVe) {
                this.kdq.add(bVar);
            }
        }
    }

    public void aG(by byVar) {
        if (byVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eCR = byVar;
            kVar.eCR.oC(5);
            this.kdq.add(0, kVar);
        }
    }

    public f cRS() {
        return this.kdr;
    }

    public i cRT() {
        return this.kdv;
    }

    public a cRU() {
        return this.kdw;
    }

    public a cRV() {
        return this.kdx;
    }

    public a cRW() {
        return this.kdy;
    }

    public n cRX() {
        return this.kds;
    }

    public bl cRY() {
        return this.kdt;
    }

    public ArrayList<q> cRZ() {
        return this.kdq;
    }

    public List<q> cSa() {
        return this.kdD;
    }

    public ax getPageData() {
        return this.pageData;
    }

    public void a(ax axVar) {
        this.pageData = axVar;
    }

    public boolean cwQ() {
        return this.iBv;
    }

    private ArrayList<q> cSb() {
        if (this.kdv != null) {
            this.kdq.add(this.kdv);
        }
        if (y.getCount(this.kdC) > 0) {
            this.kdq.add(this.kdB);
            if (this.kdC.size() > 5) {
                this.kdC = this.kdC.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kdC) {
                this.kdq.add(bVar);
            }
        }
        if (this.kds != null && this.kds.getCount() > 0 && this.sortType == 1) {
            this.kdq.add(this.kds);
        }
        if (this.kdA != null && !y.isEmpty(this.kdA.fVe)) {
            this.kdq.add(this.kdz);
            for (int i = 0; i < this.kdA.fVe.size(); i++) {
                this.kdq.add((com.baidu.tieba.card.data.b) y.getItem(this.kdA.fVe, i));
                if (this.kds != null && this.kds.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kdq.add(this.kds);
                }
            }
        }
        return this.kdq;
    }

    public int cSc() {
        return this.kdE;
    }
}
