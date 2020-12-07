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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> aaf;
    private com.baidu.tieba.lego.card.view.f aag;
    private String eGn;
    private boolean jaq;
    private com.baidu.tieba.frs.aggregation.a jar;
    private boolean jas;
    private ab<com.baidu.tieba.frs.aggregation.g> jat;
    private c jyS;
    private com.baidu.tieba.frs.videomiddlepage.a.a jyT;
    private b jyW;
    private com.baidu.tieba.lego.card.view.g jyY;
    private a jzt;
    private boolean jzu;
    private boolean jzv;
    private int jzw;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.jay);
        this.aaf = new ArrayList();
        this.mHandler = new Handler();
        this.jzu = true;
        this.jzw = 1;
        this.jat = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    by byVar = new by();
                    byVar.setId(str3);
                    byVar.setTid(str3);
                    byVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    byVar.setBaijiahaoData(gVar2.mBaijiahao);
                    byVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.jzt != null && e.this.jzt != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jzt.cEV();
                        }
                        if (e.this.jzt != aVar2) {
                            e.this.jzt = aVar2;
                        }
                        if (e.this.jzt != null) {
                            e.this.jzt.ra(e.this.jzu);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ar arVar = new ar("c12411");
                        arVar.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar);
                        if (e.this.jzt != null && !e.this.jzt.cLH()) {
                            ar a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.imE, false, (String) null, (String) null);
                            if ("14".equals(e.this.mFrom)) {
                                a2.dY("page_source", "newcategory");
                            }
                            com.baidu.tieba.t.c.dOe().b(e.this.mBdUniqueId, a2);
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        ar arVar2 = new ar("c12414");
                        arVar2.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ar arVar3 = new ar("c12415");
                        arVar3.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar3);
                        ar a3 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.imE, false, (String) null, (String) null);
                        if ("14".equals(e.this.mFrom)) {
                            a3.dY("page_source", "newcategory");
                        }
                        com.baidu.tieba.t.c.dOe().b(e.this.mBdUniqueId, a3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ar arVar4 = new ar("c12412");
                        arVar4.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar4);
                        ar a4 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.imE, false, (String) null, (String) null);
                        if ("14".equals(e.this.mFrom)) {
                            a4.dY("page_source", "newcategory");
                        }
                        com.baidu.tieba.t.c.dOe().b(e.this.mBdUniqueId, a4);
                    } else if (view.getId() == R.id.attention) {
                        ar arVar5 = new ar("c12413");
                        arVar5.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar5.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ar arVar6 = new ar("c12416");
                        arVar6.dY("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jar = aVar;
        this.jas = z;
        this.jyS = cVar;
        this.mFrom = str;
        this.jyT = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eGn = str2;
        this.aag = fVar;
        this.jyW = bVar;
        this.jyY = gVar;
    }

    public void rf(boolean z) {
        this.jzv = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jzw) {
            this.jzw = i;
            if (this.jzt != null) {
                this.jaq = true;
                this.jzt.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.jaq) {
                                e.this.jaq = false;
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
        a aVar = new a(this.mPageContext, this.jas, this.mFrom, this.eGn, this.jyW);
        aVar.c(this.jat);
        aVar.a(this.jyY);
        this.aaf.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bqI() != null) {
            gVar.bqI().keyFromHomePage = this.mFrom;
        }
        if (!this.jzv) {
            if (!this.jaq) {
                aVar.csM().a(gVar, i, this.jar);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.rv();
                }
                aVar.csM().mPosition = i;
                aVar.csM().setOnVideoContainerForegroundClickListener(this.jyS);
            } else {
                aVar.csM().c(gVar, i, this.jar);
            }
        }
        if (aVar.csM() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.csM().setCurrentPlayCallBack(this.aag);
        }
        String a2 = com.baidu.tieba.t.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        by byVar = new by();
        byVar.setId(gVar.threadId);
        byVar.setTid(gVar.threadId);
        byVar.setBaijiahaoData(gVar.mBaijiahao);
        byVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        byVar.setThreadType(40);
        com.baidu.tieba.t.c.dOe().a(this.mBdUniqueId, a2, com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rz() {
        if (this.jzt != null) {
            return this.jzt.isPlaying();
        }
        return false;
    }

    public boolean cLz() {
        if (this.jzt != null) {
            return this.jzt.cLz();
        }
        return false;
    }

    public void rx() {
        if (this.jzt != null) {
            this.jzt.pauseVideo();
        }
    }

    public void ry() {
        if (this.jzt != null) {
            this.jzt.cEV();
        }
    }

    public void cLM() {
        if (this.jzt != null) {
            this.jzt.cLA();
        }
    }

    public void onDestroy() {
        if (this.jyT != null) {
            this.jyT.cLS();
        }
        for (a aVar : this.aaf) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean Ap(int i) {
        if (this.jzt == null) {
            return false;
        }
        return this.jzt.Ap(i);
    }

    public void cLN() {
        if (this.jzt != null) {
            this.jzt.cLG();
        }
    }
}
