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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private com.baidu.tieba.lego.card.view.f AA;
    private List<a> Az;
    private String bYk;
    private boolean fAE;
    private com.baidu.tieba.frs.aggregation.a fAF;
    private boolean fAG;
    private ab<com.baidu.tieba.frs.aggregation.g> fAH;
    private c fTN;
    private com.baidu.tieba.frs.videomiddlepage.a.a fTO;
    private b fTR;
    private com.baidu.tieba.lego.card.view.g fTT;
    private a fUn;
    private boolean fUo;
    private boolean fUp;
    private int fUq;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fAM);
        this.Az = new ArrayList();
        this.mHandler = new Handler();
        this.fUo = true;
        this.fUq = 1;
        this.fAH = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bh bhVar = new bh();
                    bhVar.setId(str3);
                    bhVar.setTid(str3);
                    bhVar.setFid(com.baidu.adp.lib.g.b.toLong(gVar2.forumId, 0L));
                    bhVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fUn != null && e.this.fUn != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fUn.bmh();
                        }
                        if (e.this.fUn != aVar2) {
                            e.this.fUn = aVar2;
                        }
                        if (e.this.fUn != null) {
                            e.this.fUn.kI(e.this.fUo);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.fUn != null && !e.this.fUn.brl()) {
                            com.baidu.tieba.q.c.cni().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.eOW, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.q.c.cni().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.eOW, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.q.c.cni().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.eOW, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.fAF = aVar;
        this.fAG = z;
        this.fTN = cVar;
        this.mFrom = str;
        this.fTO = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bYk = str2;
        this.AA = fVar;
        this.fTR = bVar;
        this.fTT = gVar;
    }

    public void kM(boolean z) {
        this.fUp = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fUq) {
            this.fUq = i;
            if (this.fUn != null) {
                this.fAE = true;
                this.fUn.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fAE) {
                                e.this.fAE = false;
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
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.fAG, this.mFrom, this.bYk, this.fTR);
        aVar.d(this.fAH);
        aVar.a(this.fTT);
        this.Az.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.fUp) {
            if (!this.fAE) {
                aVar.baX().a(gVar, i, this.fAF);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kg();
                }
                aVar.baX().mPosition = i;
                aVar.baX().setOnVideoContainerForegroundClickListener(this.fTN);
            } else {
                aVar.baX().c(gVar, i, this.fAF);
            }
        }
        if (aVar.baX() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.baX().setCurrentPlayCallBack(this.AA);
        }
        gVar.eOW = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bh bhVar = new bh();
        bhVar.setId(str);
        bhVar.setTid(str);
        bhVar.setFid(com.baidu.adp.lib.g.b.toLong(gVar.forumId, 0L));
        bhVar.setThreadType(40);
        com.baidu.tieba.q.c.cni().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kk() {
        if (this.fUn != null) {
            return this.fUn.isPlaying();
        }
        return false;
    }

    public boolean brd() {
        if (this.fUn != null) {
            return this.fUn.brd();
        }
        return false;
    }

    public void ki() {
        if (this.fUn != null) {
            this.fUn.bmg();
        }
    }

    public void kj() {
        if (this.fUn != null) {
            this.fUn.bmh();
        }
    }

    public void brp() {
        if (this.fUn != null) {
            this.fUn.bre();
        }
    }

    public void onDestroy() {
        if (this.fTO != null) {
            this.fTO.bru();
        }
        for (a aVar : this.Az) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean qO(int i) {
        if (this.fUn == null) {
            return false;
        }
        return this.fUn.qO(i);
    }

    public void brq() {
        if (this.fUn != null) {
            this.fUn.brk();
        }
    }
}
