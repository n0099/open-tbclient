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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> XU;
    private com.baidu.tieba.lego.card.view.f XV;
    private String dIK;
    private boolean hGi;
    private com.baidu.tieba.frs.aggregation.a hGj;
    private boolean hGk;
    private aa<com.baidu.tieba.frs.aggregation.g> hGl;
    private c ibK;
    private com.baidu.tieba.frs.videomiddlepage.a.a ibL;
    private b ibO;
    private com.baidu.tieba.lego.card.view.g ibQ;
    private a icl;
    private boolean icm;
    private boolean icn;
    private int ico;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.hGq);
        this.XU = new ArrayList();
        this.mHandler = new Handler();
        this.icm = true;
        this.ico = 1;
        this.hGl = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bu buVar = new bu();
                    buVar.setId(str3);
                    buVar.setTid(str3);
                    buVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    buVar.setBaijiahaoData(gVar2.mBaijiahao);
                    buVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.icl != null && e.this.icl != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.icl.caG();
                        }
                        if (e.this.icl != aVar2) {
                            e.this.icl = aVar2;
                        }
                        if (e.this.icl != null) {
                            e.this.icl.nZ(e.this.icm);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ao aoVar = new ao("c12411");
                        aoVar.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar);
                        if (e.this.icl != null && !e.this.icl.cgk()) {
                            com.baidu.tieba.s.c.dgX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.gUb, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        ao aoVar2 = new ao("c12414");
                        aoVar2.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ao aoVar3 = new ao("c12415");
                        aoVar3.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar3.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar3);
                        com.baidu.tieba.s.c.dgX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.gUb, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ao aoVar4 = new ao("c12412");
                        aoVar4.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar4);
                        com.baidu.tieba.s.c.dgX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.gUb, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        ao aoVar5 = new ao("c12413");
                        aoVar5.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar5.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ao aoVar6 = new ao("c12416");
                        aoVar6.dk("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar6.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hGj = aVar;
        this.hGk = z;
        this.ibK = cVar;
        this.mFrom = str;
        this.ibL = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dIK = str2;
        this.XV = fVar;
        this.ibO = bVar;
        this.ibQ = gVar;
    }

    public void oe(boolean z) {
        this.icn = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.ico) {
            this.ico = i;
            if (this.icl != null) {
                this.hGi = true;
                this.icl.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.hGi) {
                                e.this.hGi = false;
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
        a aVar = new a(this.mPageContext, this.hGk, this.mFrom, this.dIK, this.ibO);
        aVar.c(this.hGl);
        aVar.a(this.ibQ);
        this.XU.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.icn) {
            if (!this.hGi) {
                aVar.bPg().a(gVar, i, this.hGj);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pO();
                }
                aVar.bPg().mPosition = i;
                aVar.bPg().setOnVideoContainerForegroundClickListener(this.ibK);
            } else {
                aVar.bPg().c(gVar, i, this.hGj);
            }
        }
        if (aVar.bPg() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bPg().setCurrentPlayCallBack(this.XV);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bu buVar = new bu();
        buVar.setId(gVar.threadId);
        buVar.setTid(gVar.threadId);
        buVar.setBaijiahaoData(gVar.mBaijiahao);
        buVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        buVar.setThreadType(40);
        com.baidu.tieba.s.c.dgX().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pS() {
        if (this.icl != null) {
            return this.icl.isPlaying();
        }
        return false;
    }

    public boolean cgc() {
        if (this.icl != null) {
            return this.icl.cgc();
        }
        return false;
    }

    public void pQ() {
        if (this.icl != null) {
            this.icl.caF();
        }
    }

    public void pR() {
        if (this.icl != null) {
            this.icl.caG();
        }
    }

    public void cgp() {
        if (this.icl != null) {
            this.icl.cgd();
        }
    }

    public void onDestroy() {
        if (this.ibL != null) {
            this.ibL.cgv();
        }
        for (a aVar : this.XU) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean uR(int i) {
        if (this.icl == null) {
            return false;
        }
        return this.icl.uR(i);
    }

    public void cgq() {
        if (this.icl != null) {
            this.icl.cgj();
        }
    }
}
