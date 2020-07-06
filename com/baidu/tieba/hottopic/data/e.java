package com.baidu.tieba.hottopic.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
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
    private ArrayList<q> iDS;
    private bh iDV;
    public boolean iEh;
    public int sortType;
    private f iDT = null;
    private n iDU = null;
    private PostForumData iDW = null;
    private i iDX = null;
    private a iDY = null;
    private a iDZ = null;
    private a iEa = null;
    private g iEb = null;
    public d iEc = null;
    private g iEd = null;
    private List<com.baidu.tieba.card.data.c> iEe = null;
    private List<q> iEf = null;
    private at pageData = null;
    private boolean hiN = true;
    private int iEg = 0;

    public e() {
        this.iDS = null;
        this.iDS = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hiN = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.iDT = new f();
                this.iDT.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && w.getCount(dataRes.good_threads.thread_list) != 0) {
                this.iEd = new g();
                this.iEd.a(dataRes.good_threads);
                this.iEe = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bu buVar = new bu();
                    buVar.kF(5);
                    buVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (buVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.dLi = buVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ad(buVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(buVar);
                        lVar.gUZ = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(buVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.dLi = buVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.DR("c10814");
                        this.iEe.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.iDU = new n();
                this.iDU.parserProtobuf(dataRes.relate_forum);
                this.iDV = new bh();
                this.iDV.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.iDV.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.iDV.title = dataRes.relate_forum_title;
                }
                this.iDV.dKp = R.color.cp_cont_c;
                ArrayList<bg> aRv = this.iDV.aRv();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bg bgVar = new bg();
                        bgVar.bZ(relateForum.forum_id.intValue());
                        bgVar.vL(relateForum.forum_name);
                        bgVar.vK(relateForum.avatar);
                        bgVar.vM(relateForum.desc);
                        bgVar.kC(relateForum.thread_num.intValue());
                        bgVar.kB(relateForum.member_num.intValue());
                        bgVar.setLike(relateForum.is_liked.intValue() != 0);
                        aRv.add(bgVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.iDW = new PostForumData();
                this.iDW.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.iDX = new i();
                this.iDX.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.iDY = new a();
                this.iDY.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.iDZ = new a();
                this.iDZ.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.iEa = new a();
                this.iEa.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && w.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.iEb = new g();
                this.iEb.a(dataRes.hot_thread);
                this.iEc = new d();
                this.iEc.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new at();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.iEh = this.pageData.aRf() != 0;
                }
                this.iEg = dataRes.is_global_block.intValue();
            }
            if (!w.isEmpty(dataRes.special_topic)) {
                this.iEf = new ArrayList();
                boolean z = this.iDX != null;
                Iterator<SpecialTopic> it = dataRes.special_topic.iterator();
                while (true) {
                    boolean z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    SpecialTopic next = it.next();
                    if (w.isEmpty(next.thread_list)) {
                        z = z2;
                    } else {
                        if (!TextUtils.isEmpty(next.title)) {
                            com.baidu.tieba.newdetail.a.c cVar = new com.baidu.tieba.newdetail.a.c(next.title);
                            if (!z2) {
                                cVar.jBo = false;
                                z2 = true;
                            }
                            this.iEf.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.iEf.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            clO();
        }
    }

    public void a(d dVar) {
        if (dVar != null && w.getCount(dVar.eSH) != 0) {
            for (com.baidu.tieba.card.data.c cVar : dVar.eSH) {
                this.iDS.add(cVar);
            }
        }
    }

    public void aF(bu buVar) {
        if (buVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.dLi = buVar;
            kVar.dLi.kF(5);
            this.iDS.add(0, kVar);
        }
    }

    public f clF() {
        return this.iDT;
    }

    public i clG() {
        return this.iDX;
    }

    public a clH() {
        return this.iDY;
    }

    public a clI() {
        return this.iDZ;
    }

    public a clJ() {
        return this.iEa;
    }

    public n clK() {
        return this.iDU;
    }

    public bh clL() {
        return this.iDV;
    }

    public ArrayList<q> clM() {
        return this.iDS;
    }

    public List<q> clN() {
        return this.iEf;
    }

    public at getPageData() {
        return this.pageData;
    }

    public void a(at atVar) {
        this.pageData = atVar;
    }

    public boolean bTa() {
        return this.hiN;
    }

    private ArrayList<q> clO() {
        if (this.iDX != null) {
            this.iDS.add(this.iDX);
        }
        if (w.getCount(this.iEe) > 0) {
            this.iDS.add(this.iEd);
            if (this.iEe.size() > 5) {
                this.iEe = this.iEe.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.c cVar : this.iEe) {
                this.iDS.add(cVar);
            }
        }
        if (this.iDU != null && this.iDU.getCount() > 0 && this.sortType == 1) {
            this.iDS.add(this.iDU);
        }
        if (this.iEc != null && !w.isEmpty(this.iEc.eSH)) {
            this.iDS.add(this.iEb);
            for (int i = 0; i < this.iEc.eSH.size(); i++) {
                this.iDS.add((com.baidu.tieba.card.data.c) w.getItem(this.iEc.eSH, i));
                if (this.iDU != null && this.iDU.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.iDS.add(this.iDU);
                }
            }
        }
        return this.iDS;
    }

    public int clP() {
        return this.iEg;
    }
}
