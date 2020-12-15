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
    public boolean kdH;
    private ArrayList<q> kds;
    private bl kdv;
    public int sortType;
    private f kdt = null;
    private n kdu = null;
    private PostForumData kdw = null;
    private i kdx = null;
    private a kdy = null;
    private a kdz = null;
    private a kdA = null;
    private g kdB = null;
    public d kdC = null;
    private g kdD = null;
    private List<com.baidu.tieba.card.data.b> kdE = null;
    private List<q> kdF = null;
    private ax pageData = null;
    private boolean iBx = true;
    private int kdG = 0;

    public e() {
        this.kds = null;
        this.kds = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iBx = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kdt = new f();
                this.kdt.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kdD = new g();
                this.kdD.a(dataRes.good_threads);
                this.kdE = new ArrayList();
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
                        lVar.imM = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(byVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eCR = byVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.Jt("c10814");
                        this.kdE.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kdu = new n();
                this.kdu.parserProtobuf(dataRes.relate_forum);
                this.kdv = new bl();
                this.kdv.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kdv.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kdv.title = dataRes.relate_forum_title;
                }
                this.kdv.eHT = R.color.CAM_X0108;
                ArrayList<bk> bnV = this.kdv.bnV();
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
                this.kdw = new PostForumData();
                this.kdw.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kdx = new i();
                this.kdx.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kdy = new a();
                this.kdy.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kdz = new a();
                this.kdz.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kdA = new a();
                this.kdA.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kdB = new g();
                this.kdB.a(dataRes.hot_thread);
                this.kdC = new d();
                this.kdC.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new ax();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kdH = this.pageData.bnF() != 0;
                }
                this.kdG = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kdF = new ArrayList();
                boolean z = this.kdx != null;
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
                                cVar.ldi = false;
                                z2 = true;
                            }
                            this.kdF.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kdF.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cSc();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.fVe) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.fVe) {
                this.kds.add(bVar);
            }
        }
    }

    public void aG(by byVar) {
        if (byVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eCR = byVar;
            kVar.eCR.oC(5);
            this.kds.add(0, kVar);
        }
    }

    public f cRT() {
        return this.kdt;
    }

    public i cRU() {
        return this.kdx;
    }

    public a cRV() {
        return this.kdy;
    }

    public a cRW() {
        return this.kdz;
    }

    public a cRX() {
        return this.kdA;
    }

    public n cRY() {
        return this.kdu;
    }

    public bl cRZ() {
        return this.kdv;
    }

    public ArrayList<q> cSa() {
        return this.kds;
    }

    public List<q> cSb() {
        return this.kdF;
    }

    public ax getPageData() {
        return this.pageData;
    }

    public void a(ax axVar) {
        this.pageData = axVar;
    }

    public boolean cwR() {
        return this.iBx;
    }

    private ArrayList<q> cSc() {
        if (this.kdx != null) {
            this.kds.add(this.kdx);
        }
        if (y.getCount(this.kdE) > 0) {
            this.kds.add(this.kdD);
            if (this.kdE.size() > 5) {
                this.kdE = this.kdE.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kdE) {
                this.kds.add(bVar);
            }
        }
        if (this.kdu != null && this.kdu.getCount() > 0 && this.sortType == 1) {
            this.kds.add(this.kdu);
        }
        if (this.kdC != null && !y.isEmpty(this.kdC.fVe)) {
            this.kds.add(this.kdB);
            for (int i = 0; i < this.kdC.fVe.size(); i++) {
                this.kds.add((com.baidu.tieba.card.data.b) y.getItem(this.kdC.fVe, i));
                if (this.kdu != null && this.kdu.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kds.add(this.kdu);
                }
            }
        }
        return this.kds;
    }

    public int cSd() {
        return this.kdG;
    }
}
