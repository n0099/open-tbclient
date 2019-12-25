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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Df;
    private com.baidu.tieba.lego.card.view.f Dg;
    private String cKC;
    private a gIN;
    private boolean gIO;
    private boolean gIP;
    private int gIQ;
    private c gIm;
    private com.baidu.tieba.frs.videomiddlepage.a.a gIn;
    private b gIq;
    private com.baidu.tieba.lego.card.view.g gIs;
    private boolean gpa;
    private com.baidu.tieba.frs.aggregation.a gpb;
    private boolean gpc;
    private z<com.baidu.tieba.frs.aggregation.g> gpd;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.gpi);
        this.Df = new ArrayList();
        this.mHandler = new Handler();
        this.gIO = true;
        this.gIQ = 1;
        this.gpd = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bj bjVar = new bj();
                    bjVar.setId(str3);
                    bjVar.setTid(str3);
                    bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bjVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bjVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.gIN != null && e.this.gIN != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gIN.bDE();
                        }
                        if (e.this.gIN != aVar2) {
                            e.this.gIN = aVar2;
                        }
                        if (e.this.gIN != null) {
                            e.this.gIN.lV(e.this.gIO);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.gIN != null && !e.this.gIN.bIM()) {
                            com.baidu.tieba.r.c.cHo().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.fGK, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.r.c.cHo().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.fGK, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.r.c.cHo().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.fGK, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gpb = aVar;
        this.gpc = z;
        this.gIm = cVar;
        this.mFrom = str;
        this.gIn = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.cKC = str2;
        this.Dg = fVar;
        this.gIq = bVar;
        this.gIs = gVar;
    }

    public void ma(boolean z) {
        this.gIP = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.gIQ) {
            this.gIQ = i;
            if (this.gIN != null) {
                this.gpa = true;
                this.gIN.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.gpa) {
                                e.this.gpa = false;
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
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.gpc, this.mFrom, this.cKC, this.gIq);
        aVar.c(this.gpd);
        aVar.a(this.gIs);
        this.Df.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gIP) {
            if (!this.gpa) {
                aVar.btc().a(gVar, i, this.gpb);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kx();
                }
                aVar.btc().mPosition = i;
                aVar.btc().setOnVideoContainerForegroundClickListener(this.gIm);
            } else {
                aVar.btc().c(gVar, i, this.gpb);
            }
        }
        if (aVar.btc() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.btc().setCurrentPlayCallBack(this.Dg);
        }
        String a = com.baidu.tieba.r.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.r.c.cHo().a(this.mBdUniqueId, a, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kB() {
        if (this.gIN != null) {
            return this.gIN.isPlaying();
        }
        return false;
    }

    public boolean bIE() {
        if (this.gIN != null) {
            return this.gIN.bIE();
        }
        return false;
    }

    public void kz() {
        if (this.gIN != null) {
            this.gIN.bDD();
        }
    }

    public void kA() {
        if (this.gIN != null) {
            this.gIN.bDE();
        }
    }

    public void bIR() {
        if (this.gIN != null) {
            this.gIN.bIF();
        }
    }

    public void onDestroy() {
        if (this.gIn != null) {
            this.gIn.bIW();
        }
        for (a aVar : this.Df) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean sU(int i) {
        if (this.gIN == null) {
            return false;
        }
        return this.gIN.sU(i);
    }

    public void bIS() {
        if (this.gIN != null) {
            this.gIN.bIL();
        }
    }
}
