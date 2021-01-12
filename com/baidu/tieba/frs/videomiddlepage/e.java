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
    private List<a> aaM;
    private com.baidu.tieba.lego.card.view.f aaN;
    private String eLs;
    private c jGN;
    private com.baidu.tieba.frs.videomiddlepage.a.a jGO;
    private b jGR;
    private com.baidu.tieba.lego.card.view.g jGT;
    private a jHo;
    private boolean jHp;
    private boolean jHq;
    private int jHr;
    private boolean jhX;
    private com.baidu.tieba.frs.aggregation.a jhY;
    private boolean jhZ;
    private aa<com.baidu.tieba.frs.aggregation.g> jia;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.jig);
        this.aaM = new ArrayList();
        this.mHandler = new Handler();
        this.jHp = true;
        this.jHr = 1;
        this.jia = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.jHo != null && e.this.jHo != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jHo.stopVideo();
                        }
                        if (e.this.jHo != aVar2) {
                            e.this.jHo = aVar2;
                        }
                        if (e.this.jHo != null) {
                            e.this.jHo.rv(e.this.jHp);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.jHo != null && !e.this.jHo.cKU()) {
                            aq a2 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.iuu, false, (String) null, (String) null);
                            if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                                a2.dW("page_source", "newcategory");
                            }
                            com.baidu.tieba.s.c.dKg().b(e.this.mBdUniqueId, a2);
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        aq a3 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.iuu, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a3.dW("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dKg().b(e.this.mBdUniqueId, a3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        aq a4 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.iuu, false, (String) null, (String) null);
                        if (Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(e.this.mFrom)) {
                            a4.dW("page_source", "newcategory");
                        }
                        com.baidu.tieba.s.c.dKg().b(e.this.mBdUniqueId, a4);
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dW("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jhY = aVar;
        this.jhZ = z;
        this.jGN = cVar;
        this.mFrom = str;
        this.jGO = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eLs = str2;
        this.aaN = fVar;
        this.jGR = bVar;
        this.jGT = gVar;
    }

    public void rA(boolean z) {
        this.jHq = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jHr) {
            this.jHr = i;
            if (this.jHo != null) {
                this.jhX = true;
                this.jHo.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.jhX) {
                                e.this.jhX = false;
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
        a aVar = new a(this.mPageContext, this.jhZ, this.mFrom, this.eLs, this.jGR);
        aVar.c(this.jia);
        aVar.a(this.jGT);
        this.aaM.add(aVar);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, CardViewHolder<a> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (gVar.bpr() != null) {
            gVar.bpr().keyFromHomePage = this.mFrom;
        }
        if (!this.jHq) {
            if (!this.jhX) {
                cardViewHolder.crP().a(gVar, i, this.jhY);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.qX();
                }
                cardViewHolder.crP().mPosition = i;
                cardViewHolder.crP().setOnVideoContainerForegroundClickListener(this.jGN);
            } else {
                cardViewHolder.crP().c(gVar, i, this.jhY);
            }
        }
        if (cardViewHolder.crP() instanceof com.baidu.tieba.lego.card.view.h) {
            cardViewHolder.crP().setCurrentPlayCallBack(this.aaN);
        }
        String a2 = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bz bzVar = new bz();
        bzVar.setId(gVar.threadId);
        bzVar.setTid(gVar.threadId);
        bzVar.setBaijiahaoData(gVar.mBaijiahao);
        bzVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bzVar.setThreadType(40);
        com.baidu.tieba.s.c.dKg().a(this.mBdUniqueId, a2, com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return cardViewHolder.getView();
    }

    public boolean rb() {
        if (this.jHo != null) {
            return this.jHo.isPlaying();
        }
        return false;
    }

    public boolean cKM() {
        if (this.jHo != null) {
            return this.jHo.cKM();
        }
        return false;
    }

    public void qZ() {
        if (this.jHo != null) {
            this.jHo.pauseVideo();
        }
    }

    public void ra() {
        if (this.jHo != null) {
            this.jHo.stopVideo();
        }
    }

    public void cKZ() {
        if (this.jHo != null) {
            this.jHo.cKN();
        }
    }

    public void onDestroy() {
        if (this.jGO != null) {
            this.jGO.cLf();
        }
        for (a aVar : this.aaM) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean yV(int i) {
        if (this.jHo == null) {
            return false;
        }
        return this.jHo.yV(i);
    }

    public void cLa() {
        if (this.jHo != null) {
            this.jHo.cKT();
        }
    }
}
