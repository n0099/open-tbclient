package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.j;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Zj;
    private com.baidu.tieba.lego.card.view.f Zk;
    private String ezo;
    private com.baidu.tieba.frs.aggregation.a iPA;
    private boolean iPB;
    private ab<com.baidu.tieba.frs.aggregation.g> iPC;
    private boolean iPz;
    private a jlQ;
    private boolean jlR;
    private boolean jlS;
    private int jlT;
    private c jlp;
    private com.baidu.tieba.frs.videomiddlepage.a.a jlq;
    private b jlt;
    private com.baidu.tieba.lego.card.view.g jlv;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.iPH);
        this.Zj = new ArrayList();
        this.mHandler = new Handler();
        this.jlR = true;
        this.jlT = 1;
        this.iPC = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bx bxVar = new bx();
                    bxVar.setId(str3);
                    bxVar.setTid(str3);
                    bxVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bxVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bxVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.jlQ != null && e.this.jlQ != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jlQ.cAF();
                        }
                        if (e.this.jlQ != aVar2) {
                            e.this.jlQ = aVar2;
                        }
                        if (e.this.jlQ != null) {
                            e.this.jlQ.qz(e.this.jlR);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ar arVar = new ar("c12411");
                        arVar.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar);
                        if (e.this.jlQ != null && !e.this.jlQ.cGs()) {
                            com.baidu.tieba.t.c.dIO().b(e.this.mBdUniqueId, com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.ibH, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        ar arVar2 = new ar("c12414");
                        arVar2.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ar arVar3 = new ar("c12415");
                        arVar3.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar3);
                        com.baidu.tieba.t.c.dIO().b(e.this.mBdUniqueId, com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.ibH, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ar arVar4 = new ar("c12412");
                        arVar4.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar4);
                        com.baidu.tieba.t.c.dIO().b(e.this.mBdUniqueId, com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.ibH, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        ar arVar5 = new ar("c12413");
                        arVar5.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ar arVar6 = new ar("c12416");
                        arVar6.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iPA = aVar;
        this.iPB = z;
        this.jlp = cVar;
        this.mFrom = str;
        this.jlq = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.ezo = str2;
        this.Zk = fVar;
        this.jlt = bVar;
        this.jlv = gVar;
    }

    public void qE(boolean z) {
        this.jlS = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jlT) {
            this.jlT = i;
            if (this.jlQ != null) {
                this.iPz = true;
                this.jlQ.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.iPz) {
                                e.this.iPz = false;
                            }
                        }
                    }, 500L);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.iPB, this.mFrom, this.ezo, this.jlt);
        aVar.c(this.iPC);
        aVar.a(this.jlv);
        this.Zj.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bnv() != null) {
            gVar.bnv().keyFromHomePage = this.mFrom;
        }
        if (!this.jlS) {
            if (!this.iPz) {
                aVar.coz().a(gVar, i, this.iPA);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.rt();
                }
                aVar.coz().mPosition = i;
                aVar.coz().setOnVideoContainerForegroundClickListener(this.jlp);
            } else {
                aVar.coz().c(gVar, i, this.iPA);
            }
        }
        if (aVar.coz() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.coz().setCurrentPlayCallBack(this.Zk);
        }
        String a2 = com.baidu.tieba.t.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bx bxVar = new bx();
        bxVar.setId(gVar.threadId);
        bxVar.setTid(gVar.threadId);
        bxVar.setBaijiahaoData(gVar.mBaijiahao);
        bxVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bxVar.setThreadType(40);
        com.baidu.tieba.t.c.dIO().a(this.mBdUniqueId, a2, com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rx() {
        if (this.jlQ != null) {
            return this.jlQ.isPlaying();
        }
        return false;
    }

    public boolean cGk() {
        if (this.jlQ != null) {
            return this.jlQ.cGk();
        }
        return false;
    }

    public void rv() {
        if (this.jlQ != null) {
            this.jlQ.pauseVideo();
        }
    }

    public void rw() {
        if (this.jlQ != null) {
            this.jlQ.cAF();
        }
    }

    public void cGx() {
        if (this.jlQ != null) {
            this.jlQ.cGl();
        }
    }

    public void onDestroy() {
        if (this.jlq != null) {
            this.jlq.cGD();
        }
        for (a aVar : this.Zj) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean zK(int i) {
        if (this.jlQ == null) {
            return false;
        }
        return this.jlQ.zK(i);
    }

    public void cGy() {
        if (this.jlQ != null) {
            this.jlQ.cGr();
        }
    }
}
