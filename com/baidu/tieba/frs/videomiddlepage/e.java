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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, CardViewHolder<a>> {
    private List<a> aaO;
    private com.baidu.tieba.lego.card.view.f aaP;
    private String eQd;
    private a jLU;
    private boolean jLV;
    private boolean jLW;
    private int jLX;
    private c jLt;
    private com.baidu.tieba.frs.videomiddlepage.a.a jLu;
    private b jLx;
    private com.baidu.tieba.lego.card.view.g jLz;
    private boolean jmF;
    private com.baidu.tieba.frs.aggregation.a jmG;
    private boolean jmH;
    private aa<com.baidu.tieba.frs.aggregation.g> jmI;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.jmN);
        this.aaO = new ArrayList();
        this.mHandler = new Handler();
        this.jLV = true;
        this.jLX = 1;
        this.jmI = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bz bzVar = new bz();
                    bzVar.setId(str3);
                    bzVar.setTid(str3);
                    bzVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bzVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bzVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.jLU != null && e.this.jLU != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jLU.stopVideo();
                        }
                        if (e.this.jLU != aVar2) {
                            e.this.jLU = aVar2;
                        }
                        if (e.this.jLU != null) {
                            e.this.jLU.rz(e.this.jLV);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.jLU != null && !e.this.jLU.cOM()) {
                            aq a2 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.izb, false, (String) null, (String) null);
                            if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                                a2.dX("page_source", "newcategory");
                            }
                            com.baidu.tieba.s.c.dNY().b(e.this.mBdUniqueId, a2);
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        aq a3 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.izb, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a3.dX("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dNY().b(e.this.mBdUniqueId, a3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        aq a4 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.izb, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a4.dX("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dNY().b(e.this.mBdUniqueId, a4);
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dX("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jmG = aVar;
        this.jmH = z;
        this.jLt = cVar;
        this.mFrom = str;
        this.jLu = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eQd = str2;
        this.aaP = fVar;
        this.jLx = bVar;
        this.jLz = gVar;
    }

    public void rE(boolean z) {
        this.jLW = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jLX) {
            this.jLX = i;
            if (this.jLU != null) {
                this.jmF = true;
                this.jLU.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.jmF) {
                                e.this.jmF = false;
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
        a aVar = new a(this.mPageContext, this.jmH, this.mFrom, this.eQd, this.jLx);
        aVar.c(this.jmI);
        aVar.a(this.jLz);
        this.aaO.add(aVar);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, CardViewHolder<a> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (gVar.btl() != null) {
            gVar.btl().keyFromHomePage = this.mFrom;
        }
        if (!this.jLW) {
            if (!this.jmF) {
                cardViewHolder.cvH().a(gVar, i, this.jmG);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.qX();
                }
                cardViewHolder.cvH().mPosition = i;
                cardViewHolder.cvH().setOnVideoContainerForegroundClickListener(this.jLt);
            } else {
                cardViewHolder.cvH().c(gVar, i, this.jmG);
            }
        }
        if (cardViewHolder.cvH() instanceof com.baidu.tieba.lego.card.view.h) {
            cardViewHolder.cvH().setCurrentPlayCallBack(this.aaP);
        }
        String a2 = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bz bzVar = new bz();
        bzVar.setId(gVar.threadId);
        bzVar.setTid(gVar.threadId);
        bzVar.setBaijiahaoData(gVar.mBaijiahao);
        bzVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bzVar.setThreadType(40);
        com.baidu.tieba.s.c.dNY().a(this.mBdUniqueId, a2, com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return cardViewHolder.getView();
    }

    public boolean rb() {
        if (this.jLU != null) {
            return this.jLU.isPlaying();
        }
        return false;
    }

    public boolean cOE() {
        if (this.jLU != null) {
            return this.jLU.cOE();
        }
        return false;
    }

    public void qZ() {
        if (this.jLU != null) {
            this.jLU.pauseVideo();
        }
    }

    public void ra() {
        if (this.jLU != null) {
            this.jLU.stopVideo();
        }
    }

    public void cOR() {
        if (this.jLU != null) {
            this.jLU.cOF();
        }
    }

    public void onDestroy() {
        if (this.jLu != null) {
            this.jLu.cOX();
        }
        for (a aVar : this.aaO) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean AB(int i) {
        if (this.jLU == null) {
            return false;
        }
        return this.jLU.AB(i);
    }

    public void cOS() {
        if (this.jLU != null) {
            this.jLU.cOL();
        }
    }
}
