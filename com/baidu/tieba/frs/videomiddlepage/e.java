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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Yu;
    private com.baidu.tieba.lego.card.view.f Yv;
    private String dYs;
    private boolean iar;
    private com.baidu.tieba.frs.aggregation.a ias;
    private boolean iat;
    private aa<com.baidu.tieba.frs.aggregation.g> iau;
    private c ivZ;
    private a iwA;
    private boolean iwB;
    private boolean iwC;
    private int iwD;
    private com.baidu.tieba.frs.videomiddlepage.a.a iwa;
    private b iwd;
    private com.baidu.tieba.lego.card.view.g iwf;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.iaz);
        this.Yu = new ArrayList();
        this.mHandler = new Handler();
        this.iwB = true;
        this.iwD = 1;
        this.iau = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bw bwVar = new bw();
                    bwVar.setId(str3);
                    bwVar.setTid(str3);
                    bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bwVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bwVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.iwA != null && e.this.iwA != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iwA.coK();
                        }
                        if (e.this.iwA != aVar2) {
                            e.this.iwA = aVar2;
                        }
                        if (e.this.iwA != null) {
                            e.this.iwA.pk(e.this.iwB);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.iwA != null && !e.this.iwA.cup()) {
                            com.baidu.tieba.s.c.dvJ().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.hmC, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        com.baidu.tieba.s.c.dvJ().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.hmC, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        com.baidu.tieba.s.c.dvJ().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.hmC, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dD("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ias = aVar;
        this.iat = z;
        this.ivZ = cVar;
        this.mFrom = str;
        this.iwa = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dYs = str2;
        this.Yv = fVar;
        this.iwd = bVar;
        this.iwf = gVar;
    }

    public void pp(boolean z) {
        this.iwC = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.iwD) {
            this.iwD = i;
            if (this.iwA != null) {
                this.iar = true;
                this.iwA.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.iar) {
                                e.this.iar = false;
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
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.iat, this.mFrom, this.dYs, this.iwd);
        aVar.c(this.iau);
        aVar.a(this.iwf);
        this.Yu.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bgv() != null) {
            gVar.bgv().keyFromHomePage = this.mFrom;
        }
        if (!this.iwC) {
            if (!this.iar) {
                aVar.ccF().a(gVar, i, this.ias);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.ro();
                }
                aVar.ccF().mPosition = i;
                aVar.ccF().setOnVideoContainerForegroundClickListener(this.ivZ);
            } else {
                aVar.ccF().c(gVar, i, this.ias);
            }
        }
        if (aVar.ccF() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.ccF().setCurrentPlayCallBack(this.Yv);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bw bwVar = new bw();
        bwVar.setId(gVar.threadId);
        bwVar.setTid(gVar.threadId);
        bwVar.setBaijiahaoData(gVar.mBaijiahao);
        bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bwVar.setThreadType(40);
        com.baidu.tieba.s.c.dvJ().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rs() {
        if (this.iwA != null) {
            return this.iwA.isPlaying();
        }
        return false;
    }

    public boolean cuh() {
        if (this.iwA != null) {
            return this.iwA.cuh();
        }
        return false;
    }

    public void rq() {
        if (this.iwA != null) {
            this.iwA.coJ();
        }
    }

    public void rr() {
        if (this.iwA != null) {
            this.iwA.coK();
        }
    }

    public void cuu() {
        if (this.iwA != null) {
            this.iwA.cui();
        }
    }

    public void onDestroy() {
        if (this.iwa != null) {
            this.iwa.cuA();
        }
        for (a aVar : this.Yu) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean xB(int i) {
        if (this.iwA == null) {
            return false;
        }
        return this.iwA.xB(i);
    }

    public void cuv() {
        if (this.iwA != null) {
            this.iwA.cuo();
        }
    }
}
