package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Xq;
    private com.baidu.tieba.lego.card.view.f Xr;
    private String dCp;
    private c hNL;
    private com.baidu.tieba.frs.videomiddlepage.a.a hNM;
    private b hNP;
    private com.baidu.tieba.lego.card.view.g hNR;
    private a hOm;
    private boolean hOn;
    private boolean hOo;
    private int hOp;
    private boolean hth;
    private com.baidu.tieba.frs.aggregation.a hti;
    private boolean htj;
    private aa<com.baidu.tieba.frs.aggregation.g> htk;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.htp);
        this.Xq = new ArrayList();
        this.mHandler = new Handler();
        this.hOn = true;
        this.hOp = 1;
        this.htk = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bk bkVar = new bk();
                    bkVar.setId(str3);
                    bkVar.setTid(str3);
                    bkVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bkVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bkVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.hOm != null && e.this.hOm != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.hOm.bXt();
                        }
                        if (e.this.hOm != aVar2) {
                            e.this.hOm = aVar2;
                        }
                        if (e.this.hOm != null) {
                            e.this.hOm.nN(e.this.hOn);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.hOm != null && !e.this.hOm.ccJ()) {
                            com.baidu.tieba.s.c.dct().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.gGQ, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.s.c.dct().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.gGQ, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.dct().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.gGQ, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.dh("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hti = aVar;
        this.htj = z;
        this.hNL = cVar;
        this.mFrom = str;
        this.hNM = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dCp = str2;
        this.Xr = fVar;
        this.hNP = bVar;
        this.hNR = gVar;
    }

    public void nS(boolean z) {
        this.hOo = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.hOp) {
            this.hOp = i;
            if (this.hOm != null) {
                this.hth = true;
                this.hOm.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.hth) {
                                e.this.hth = false;
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
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.htj, this.mFrom, this.dCp, this.hNP);
        aVar.c(this.htk);
        aVar.a(this.hNR);
        this.Xq.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hOo) {
            if (!this.hth) {
                aVar.bLU().a(gVar, i, this.hti);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.px();
                }
                aVar.bLU().mPosition = i;
                aVar.bLU().setOnVideoContainerForegroundClickListener(this.hNL);
            } else {
                aVar.bLU().c(gVar, i, this.hti);
            }
        }
        if (aVar.bLU() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bLU().setCurrentPlayCallBack(this.Xr);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bk bkVar = new bk();
        bkVar.setId(gVar.threadId);
        bkVar.setTid(gVar.threadId);
        bkVar.setBaijiahaoData(gVar.mBaijiahao);
        bkVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bkVar.setThreadType(40);
        com.baidu.tieba.s.c.dct().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pB() {
        if (this.hOm != null) {
            return this.hOm.isPlaying();
        }
        return false;
    }

    public boolean ccB() {
        if (this.hOm != null) {
            return this.hOm.ccB();
        }
        return false;
    }

    public void pz() {
        if (this.hOm != null) {
            this.hOm.bXs();
        }
    }

    public void pA() {
        if (this.hOm != null) {
            this.hOm.bXt();
        }
    }

    public void ccO() {
        if (this.hOm != null) {
            this.hOm.ccC();
        }
    }

    public void onDestroy() {
        if (this.hNM != null) {
            this.hNM.ccU();
        }
        for (a aVar : this.Xq) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean uk(int i) {
        if (this.hOm == null) {
            return false;
        }
        return this.hOm.uk(i);
    }

    public void ccP() {
        if (this.hOm != null) {
            this.hOm.ccI();
        }
    }
}
