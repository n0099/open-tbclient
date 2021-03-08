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
/* loaded from: classes7.dex */
public class e {
    public boolean kwL;
    private ArrayList<com.baidu.adp.widget.ListView.n> kww;
    private bo kwz;
    public int sortType;
    private f kwx = null;
    private n kwy = null;
    private PostForumData kwA = null;
    private i kwB = null;
    private a kwC = null;
    private a kwD = null;
    private a kwE = null;
    private g kwF = null;
    public d kwG = null;
    private g kwH = null;
    private List<com.baidu.tieba.card.data.b> kwI = null;
    private List<com.baidu.adp.widget.ListView.n> kwJ = null;
    private az pageData = null;
    private boolean iQH = true;
    private int kwK = 0;

    public e() {
        this.kww = null;
        this.kww = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iQH = dataRes.is_new_url.intValue() == 1;
            if (dataRes.topic_info != null) {
                this.kwx = new f();
                this.kwx.a(dataRes.topic_info);
            }
            if (dataRes.good_threads != null && !StringUtils.isNull(dataRes.good_threads.hot_title) && y.getCount(dataRes.good_threads.thread_list) != 0) {
                this.kwH = new g();
                this.kwH.a(dataRes.good_threads);
                this.kwI = new ArrayList();
                for (ThreadInfo threadInfo : dataRes.good_threads.thread_list) {
                    cb cbVar = new cb();
                    cbVar.nk(5);
                    cbVar.a(threadInfo);
                    com.baidu.tieba.card.data.k kVar = null;
                    if (cbVar.isShareThread) {
                        com.baidu.tieba.card.data.k kVar2 = new com.baidu.tieba.card.data.k();
                        kVar2.eLr = cbVar;
                        kVar = kVar2;
                    } else if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                        com.baidu.tieba.card.data.l lVar = new com.baidu.tieba.card.data.l(cbVar);
                        lVar.iCh = true;
                        kVar = lVar;
                    } else if (com.baidu.tieba.card.data.k.ae(cbVar)) {
                        com.baidu.tieba.card.data.k kVar3 = new com.baidu.tieba.card.data.k();
                        kVar3.eLr = cbVar;
                        kVar = kVar3;
                    }
                    if (kVar != null && kVar.isValid()) {
                        kVar.Ja("c10814");
                        this.kwI.add(kVar);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.kwy = new n();
                this.kwy.parserProtobuf(dataRes.relate_forum);
                this.kwz = new bo();
                this.kwz.floorPosition = 2;
                if (TextUtils.isEmpty(dataRes.relate_forum_title)) {
                    this.kwz.title = TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_recommend_forum_list_title);
                } else {
                    this.kwz.title = dataRes.relate_forum_title;
                }
                this.kwz.eQN = R.color.CAM_X0108;
                ArrayList<bn> bmY = this.kwz.bmY();
                for (RelateForum relateForum : dataRes.relate_forum) {
                    if (!StringUtils.isNull(relateForum.forum_name)) {
                        bn bnVar = new bn();
                        bnVar.dK(relateForum.forum_id.intValue());
                        bnVar.Ai(relateForum.forum_name);
                        bnVar.Ah(relateForum.avatar);
                        bnVar.Aj(relateForum.desc);
                        bnVar.nh(relateForum.thread_num.intValue());
                        bnVar.ng(relateForum.member_num.intValue());
                        bnVar.setLike(relateForum.is_liked.intValue() != 0);
                        bmY.add(bnVar);
                    }
                }
            }
            if (dataRes.post_forum != null && dataRes.post_forum.size() != 0) {
                this.kwA = new PostForumData();
                this.kwA.parserProtobuf(dataRes.post_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.kwB = new i();
                this.kwB.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.kwC = new a();
                this.kwC.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.kwD = new a();
                this.kwD.a(dataRes.candle_module);
            }
            if (dataRes.weiguan_module != null) {
                this.kwE = new a();
                this.kwE.a(dataRes.weiguan_module);
            }
            if (dataRes.hot_thread != null && y.getCount(dataRes.hot_thread.thread_list) != 0) {
                this.kwF = new g();
                this.kwF.a(dataRes.hot_thread);
                this.kwG = new d();
                this.kwG.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.pageData = new az();
                    this.pageData.a(dataRes.hot_thread.page);
                    this.kwL = this.pageData.bmH() != 0;
                }
                this.kwK = dataRes.is_global_block.intValue();
            }
            if (!y.isEmpty(dataRes.special_topic)) {
                this.kwJ = new ArrayList();
                boolean z = this.kwB != null;
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
                                cVar.loG = false;
                                z2 = true;
                            }
                            this.kwJ.add(cVar);
                        }
                        boolean z3 = z2;
                        int size = next.thread_list.size();
                        for (int i = 0; i < size; i++) {
                            this.kwJ.add(new com.baidu.tieba.newdetail.a.b(next.thread_list.get(i), i + 1 == size));
                        }
                        z = z3;
                    }
                }
            }
            cTE();
        }
    }

    public void a(d dVar) {
        if (dVar != null && y.getCount(dVar.gdY) != 0) {
            for (com.baidu.tieba.card.data.b bVar : dVar.gdY) {
                this.kww.add(bVar);
            }
        }
    }

    public void aI(cb cbVar) {
        if (cbVar != null) {
            com.baidu.tieba.card.data.k kVar = new com.baidu.tieba.card.data.k();
            kVar.eLr = cbVar;
            kVar.eLr.nk(5);
            this.kww.add(0, kVar);
        }
    }

    public f cTv() {
        return this.kwx;
    }

    public i cTw() {
        return this.kwB;
    }

    public a cTx() {
        return this.kwC;
    }

    public a cTy() {
        return this.kwD;
    }

    public a cTz() {
        return this.kwE;
    }

    public n cTA() {
        return this.kwy;
    }

    public bo cTB() {
        return this.kwz;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTC() {
        return this.kww;
    }

    public List<com.baidu.adp.widget.ListView.n> cTD() {
        return this.kwJ;
    }

    public az getPageData() {
        return this.pageData;
    }

    public void a(az azVar) {
        this.pageData = azVar;
    }

    public boolean cxs() {
        return this.iQH;
    }

    private ArrayList<com.baidu.adp.widget.ListView.n> cTE() {
        if (this.kwB != null) {
            this.kww.add(this.kwB);
        }
        if (y.getCount(this.kwI) > 0) {
            this.kww.add(this.kwH);
            if (this.kwI.size() > 5) {
                this.kwI = this.kwI.subList(0, 5);
            }
            for (com.baidu.tieba.card.data.b bVar : this.kwI) {
                this.kww.add(bVar);
            }
        }
        if (this.kwy != null && this.kwy.getCount() > 0 && this.sortType == 1) {
            this.kww.add(this.kwy);
        }
        if (this.kwG != null && !y.isEmpty(this.kwG.gdY)) {
            this.kww.add(this.kwF);
            for (int i = 0; i < this.kwG.gdY.size(); i++) {
                this.kww.add((com.baidu.tieba.card.data.b) y.getItem(this.kwG.gdY, i));
                if (this.kwy != null && this.kwy.getCount() > 0 && i == 2 && this.sortType == 0) {
                    this.kww.add(this.kwy);
                }
            }
        }
        return this.kww;
    }

    public int cTF() {
        return this.kwK;
    }
}
