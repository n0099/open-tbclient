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
    private boolean hMe;
    private com.baidu.tieba.frs.aggregation.a hMf;
    private boolean hMg;
    private aa<com.baidu.tieba.frs.aggregation.g> hMh;
    private c ihM;
    private com.baidu.tieba.frs.videomiddlepage.a.a ihN;
    private b ihQ;
    private com.baidu.tieba.lego.card.view.g ihS;
    private a iin;
    private boolean iio;
    private boolean iip;
    private int iiq;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.hMm);
        this.XM = new ArrayList();
        this.mHandler = new Handler();
        this.iio = true;
        this.iiq = 1;
        this.hMh = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.iin != null && e.this.iin != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iin.cef();
                        }
                        if (e.this.iin != aVar2) {
                            e.this.iin = aVar2;
                        }
                        if (e.this.iin != null) {
                            e.this.iin.oE(e.this.iio);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ap apVar = new ap("c12411");
                        apVar.dn("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar);
                        if (e.this.iin != null && !e.this.iin.cjK()) {
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
        this.hMf = aVar;
        this.hMg = z;
        this.ihM = cVar;
        this.mFrom = str;
        this.ihN = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dOV = str2;
        this.XN = fVar;
        this.ihQ = bVar;
        this.ihS = gVar;
    }

    public void oJ(boolean z) {
        this.iip = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.iiq) {
            this.iiq = i;
            if (this.iin != null) {
                this.hMe = true;
                this.iin.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.hMe) {
                                e.this.hMe = false;
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
        a aVar = new a(this.mPageContext, this.hMg, this.mFrom, this.dOV, this.ihQ);
        aVar.c(this.hMh);
        aVar.a(this.ihS);
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
        if (!this.iip) {
            if (!this.hMe) {
                aVar.bSs().a(gVar, i, this.hMf);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pP();
                }
                aVar.bSs().mPosition = i;
                aVar.bSs().setOnVideoContainerForegroundClickListener(this.ihM);
            } else {
                aVar.bSs().c(gVar, i, this.hMf);
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
        if (this.iin != null) {
            return this.iin.isPlaying();
        }
        return false;
    }

    public boolean cjC() {
        if (this.iin != null) {
            return this.iin.cjC();
        }
        return false;
    }

    public void pR() {
        if (this.iin != null) {
            this.iin.cee();
        }
    }

    public void pS() {
        if (this.iin != null) {
            this.iin.cef();
        }
    }

    public void cjP() {
        if (this.iin != null) {
            this.iin.cjD();
        }
    }

    public void onDestroy() {
        if (this.ihN != null) {
            this.ihN.cjV();
        }
        for (a aVar : this.XM) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean vj(int i) {
        if (this.iin == null) {
            return false;
        }
        return this.iin.vj(i);
    }

    public void cjQ() {
        if (this.iin != null) {
            this.iin.cjJ();
        }
    }
}
