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
/* loaded from: classes7.dex */
public class e {
    private ArrayList<com.baidu.adp.widget.ListView.n> klZ;
    private bm kmc;
    public boolean kmo;
    public int sortType;
    private f kma = null;
    private n kmb = null;
    private PostForumData kmd = null;
    private i kme = null;
    private a kmf = null;
    private a kmg = null;
    private a kmh = null;
    private g kmi = null;
    public d kmj = null;
    private g kmk = null;
    private List<com.baidu.tieba.card.data.b> kml = null;
    private List<com.baidu.adp.widget.ListView.n> kmm = null;
    private ax pageData = null;
    private boolean iJc = true;
    private int kmn = 0;

    public e() {
        this.klZ = null;
        this.klZ = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iJc = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kma = new f();
                this.kma.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && x.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kmk = new g();
                this.kmk.a(dataRes.good_threads);
                this.kml = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    bz bzVar = new bz();
                    bzVar.ng(5);
                    bzVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (bzVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.eHK = bzVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ad(bzVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(bzVar);
                        lVar.iuA = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ad(bzVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eHK = bzVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.If("c10814");
                        this.kml.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kmb = new n();
                this.kmb.parserProtobuf(dataRes.relate_forum);
                this.kmc = new bm();
                this.kmc.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kmc.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kmc.title = dataRes.relate_forum_title;
                }
                this.kmc.eNa = R.color.CAM_X0108;
                ArrayList<bl> bmD = this.kmc.bmD();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bl blVar = new bl();
                        blVar.dE(relateForum.forum_id.intValue());
                        blVar.zK(relateForum.forum_name);
                        blVar.zJ(relateForum.avatar);
                        blVar.zL(relateForum.desc);
                        blVar.nd(relateForum.thread_num.intValue());
                        blVar.nc(relateForum.member_num.intValue());
                        blVar.setLike(relateForum.is_liked.intValue() != 0);
                        bmD.add(blVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.kmd = new PostForumData();
                this.kmd.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kme = new i();
                this.kme.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kmf = new a();
                this.kmf.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kmg = new a();
                this.kmg.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kmh = new a();
                this.kmh.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && x.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kmi = new g();
                this.kmi.a(dataRes.hot_thread);
                this.kmj = new d();
                this.kmj.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new ax();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kmo = this.pageData.bmm() != 0;
                }
                this.kmn = dataRes.is_global_block.intValue();
            }
            if (!x.isEmpty(dataRes.special_topic)) {
                this.kmm = new ArrayList();
                boolean z = this.kme != null;
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
                                cVar.lei = false;
                                z2 = true;
                            }
                            this.kmm.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kmm.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cRr();
        }
    }

    public void a(d dVar) {
        if (dVar != null && x.getCount(dVar.gaa) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.gaa) {
                this.klZ.add(bVar);
            }
        }
    }

    public void aH(bz bzVar) {
        if (bzVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eHK = bzVar;
            kVar.eHK.ng(5);
            this.klZ.add(0, kVar);
        }
    }

    public f cRi() {
        return this.kma;
    }

    public i cRj() {
        return this.kme;
    }

    public a cRk() {
        return this.kmf;
    }

    public a cRl() {
        return this.kmg;
    }

    public a cRm() {
        return this.kmh;
    }

    public n cRn() {
        return this.kmb;
    }

    public bm cRo() {
        return this.kmc;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cRp() {
        return this.klZ;
    }

    public List<com.baidu.adp.widget.ListView.n> cRq() {
        return this.kmm;
    }

    public ax getPageData() {
        return this.pageData;
    }

    public void a(ax axVar) {
        this.pageData = axVar;
    }

    public boolean cvT() {
        return this.iJc;
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cRr() {
        if (this.kme != null) {
            this.klZ.add(this.kme);
        }
        if (x.getCount(this.kml) > 0) {
            this.klZ.add(this.kmk);
            if (this.kml.size() > 5) {
                this.kml = this.kml.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kml) {
                this.klZ.add(bVar);
            }
        }
        if (this.kmb != null && this.kmb.getCount() > 0 && this.sortType == 1) {
            this.klZ.add(this.kmb);
        }
        if (this.kmj != null && !x.isEmpty(this.kmj.gaa)) {
            this.klZ.add(this.kmi);
            for (int i = 0; i < this.kmj.gaa.size(); i++) {
                this.klZ.add((com.baidu.tieba.card.data.b) x.getItem(this.kmj.gaa, i));
                if (this.kmb != null && this.kmb.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.klZ.add(this.kmb);
                }
            }
        }
        return this.klZ;
    }

    public int cRs() {
        return this.kmn;
    }
}
