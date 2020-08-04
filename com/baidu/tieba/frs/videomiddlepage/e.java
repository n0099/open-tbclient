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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> XM;
    private com.baidu.tieba.lego.card.view.f XN;
    private String dOV;
    private boolean hMg;
    private com.baidu.tieba.frs.aggregation.a hMh;
    private boolean hMi;
    private aa<com.baidu.tieba.frs.aggregation.g> hMj;
    private c ihO;
    private com.baidu.tieba.frs.videomiddlepage.a.a ihP;
    private b ihS;
    private com.baidu.tieba.lego.card.view.g ihU;
    private a iip;
    private boolean iiq;
    private boolean iir;
    private int iis;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.hMo);
        this.XM = new ArrayList();
        this.mHandler = new Handler();
        this.iiq = true;
        this.iis = 1;
        this.hMj = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bv bvVar = new bv();
                    bvVar.setId(str3);
                    bvVar.setTid(str3);
                    bvVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bvVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bvVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.iip != null && e.this.iip != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iip.cef();
                        }
                        if (e.this.iip != aVar2) {
                            e.this.iip = aVar2;
                        }
                        if (e.this.iip != null) {
                            e.this.iip.oE(e.this.iiq);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ap apVar = new ap("c12411");
                        apVar.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar);
                        if (e.this.iip != null && !e.this.iip.cjK()) {
                            com.baidu.tieba.s.c.dkh().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.gZF, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        ap apVar2 = new ap("c12414");
                        apVar2.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ap apVar3 = new ap("c12415");
                        apVar3.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar3.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar3);
                        com.baidu.tieba.s.c.dkh().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.gZF, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ap apVar4 = new ap("c12412");
                        apVar4.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar4);
                        com.baidu.tieba.s.c.dkh().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.gZF, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        ap apVar5 = new ap("c12413");
                        apVar5.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar5.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ap apVar6 = new ap("c12416");
                        apVar6.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar6.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMh = aVar;
        this.hMi = z;
        this.ihO = cVar;
        this.mFrom = str;
        this.ihP = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dOV = str2;
        this.XN = fVar;
        this.ihS = bVar;
        this.ihU = gVar;
    }

    public void oJ(boolean z) {
        this.iir = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.iis) {
            this.iis = i;
            if (this.iip != null) {
                this.hMg = true;
                this.iip.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.hMg) {
                                e.this.hMg = false;
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
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.hMi, this.mFrom, this.dOV, this.ihS);
        aVar.c(this.hMj);
        aVar.a(this.ihU);
        this.XM.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.aYc() != null) {
            gVar.aYc().keyFromHomePage = this.mFrom;
        }
        if (!this.iir) {
            if (!this.hMg) {
                aVar.bSs().a(gVar, i, this.hMh);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pP();
                }
                aVar.bSs().mPosition = i;
                aVar.bSs().setOnVideoContainerForegroundClickListener(this.ihO);
            } else {
                aVar.bSs().c(gVar, i, this.hMh);
            }
        }
        if (aVar.bSs() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bSs().setCurrentPlayCallBack(this.XN);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bv bvVar = new bv();
        bvVar.setId(gVar.threadId);
        bvVar.setTid(gVar.threadId);
        bvVar.setBaijiahaoData(gVar.mBaijiahao);
        bvVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bvVar.setThreadType(40);
        com.baidu.tieba.s.c.dkh().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pT() {
        if (this.iip != null) {
            return this.iip.isPlaying();
        }
        return false;
    }

    public boolean cjC() {
        if (this.iip != null) {
            return this.iip.cjC();
        }
        return false;
    }

    public void pR() {
        if (this.iip != null) {
            this.iip.cee();
        }
    }

    public void pS() {
        if (this.iip != null) {
            this.iip.cef();
        }
    }

    public void cjP() {
        if (this.iip != null) {
            this.iip.cjD();
        }
    }

    public void onDestroy() {
        if (this.ihP != null) {
            this.ihP.cjV();
        }
        for (a aVar : this.XM) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean vj(int i) {
        if (this.iip == null) {
            return false;
        }
        return this.iip.vj(i);
    }

    public void cjQ() {
        if (this.iip != null) {
            this.iip.cjJ();
        }
    }
}
