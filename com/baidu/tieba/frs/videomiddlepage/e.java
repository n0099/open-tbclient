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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, CardViewHolder<a>> {
    private List<a> aaI;
    private com.baidu.tieba.lego.card.view.f aaJ;
    private String eNE;
    private a jMS;
    private boolean jMT;
    private boolean jMU;
    private int jMV;
    private c jMr;
    private com.baidu.tieba.frs.videomiddlepage.a.a jMs;
    private b jMv;
    private com.baidu.tieba.lego.card.view.g jMx;
    private boolean jnF;
    private com.baidu.tieba.frs.aggregation.a jnG;
    private boolean jnH;
    private ab<com.baidu.tieba.frs.aggregation.g> jnI;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.jnN);
        this.aaI = new ArrayList();
        this.mHandler = new Handler();
        this.jMT = true;
        this.jMV = 1;
        this.jnI = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    cb cbVar = new cb();
                    cbVar.setId(str3);
                    cbVar.setTid(str3);
                    cbVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    cbVar.setBaijiahaoData(gVar2.mBaijiahao);
                    cbVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.jMS != null && e.this.jMS != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jMS.stopVideo();
                        }
                        if (e.this.jMS != aVar2) {
                            e.this.jMS = aVar2;
                        }
                        if (e.this.jMS != null) {
                            e.this.jMS.rF(e.this.jMT);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ar arVar = new ar("c12411");
                        arVar.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar);
                        if (e.this.jMS != null && !e.this.jMS.cMi()) {
                            ar a2 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.iAe, false, (String) null, (String) null);
                            if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                                a2.dR("page_source", "newcategory");
                            }
                            com.baidu.tieba.s.c.dMr().b(e.this.mBdUniqueId, a2);
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
                        ar a3 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.iAe, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a3.dR("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dMr().b(e.this.mBdUniqueId, a3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ar arVar4 = new ar("c12412");
                        arVar4.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar4);
                        ar a4 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.iAe, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a4.dR("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dMr().b(e.this.mBdUniqueId, a4);
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
        this.jnG = aVar;
        this.jnH = z;
        this.jMr = cVar;
        this.mFrom = str;
        this.jMs = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eNE = str2;
        this.aaJ = fVar;
        this.jMv = bVar;
        this.jMx = gVar;
    }

    public void rK(boolean z) {
        this.jMU = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jMV) {
            this.jMV = i;
            if (this.jMS != null) {
                this.jnF = true;
                this.jMS.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.jnF) {
                                e.this.jnF = false;
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
    /* renamed from: aX */
    public CardViewHolder<a> e(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.jnH, this.mFrom, this.eNE, this.jMv);
        aVar.c(this.jnI);
        aVar.a(this.jMx);
        this.aaI.add(aVar);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, CardViewHolder<a> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (gVar.bpJ() != null) {
            gVar.bpJ().keyFromHomePage = this.mFrom;
        }
        if (!this.jMU) {
            if (!this.jnF) {
                cardViewHolder.ctb().a(gVar, i, this.jnG);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.qV();
                }
                cardViewHolder.ctb().mPosition = i;
                cardViewHolder.ctb().setOnVideoContainerForegroundClickListener(this.jMr);
            } else {
                cardViewHolder.ctb().c(gVar, i, this.jnG);
            }
        }
        if (cardViewHolder.ctb() instanceof com.baidu.tieba.lego.card.view.h) {
            cardViewHolder.ctb().setCurrentPlayCallBack(this.aaJ);
        }
        String a2 = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        cb cbVar = new cb();
        cbVar.setId(gVar.threadId);
        cbVar.setTid(gVar.threadId);
        cbVar.setBaijiahaoData(gVar.mBaijiahao);
        cbVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        cbVar.setThreadType(40);
        com.baidu.tieba.s.c.dMr().a(this.mBdUniqueId, a2, com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return cardViewHolder.getView();
    }

    public boolean qZ() {
        if (this.jMS != null) {
            return this.jMS.isPlaying();
        }
        return false;
    }

    public boolean cMa() {
        if (this.jMS != null) {
            return this.jMS.cMa();
        }
        return false;
    }

    public void qX() {
        if (this.jMS != null) {
            this.jMS.pauseVideo();
        }
    }

    public void qY() {
        if (this.jMS != null) {
            this.jMS.stopVideo();
        }
    }

    public void cMn() {
        if (this.jMS != null) {
            this.jMS.cMb();
        }
    }

    public void onDestroy() {
        if (this.jMs != null) {
            this.jMs.cMt();
        }
        for (a aVar : this.aaI) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean zf(int i) {
        if (this.jMS == null) {
            return false;
        }
        return this.jMS.zf(i);
    }

    public void cMo() {
        if (this.jMS != null) {
            this.jMS.cMh();
        }
    }
}
