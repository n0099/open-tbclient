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
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> DE;
    private com.baidu.tieba.lego.card.view.f DG;
    private String cOS;
    private c gNM;
    private com.baidu.tieba.frs.videomiddlepage.a.a gNN;
    private b gNQ;
    private com.baidu.tieba.lego.card.view.g gNS;
    private a gOn;
    private boolean gOo;
    private boolean gOp;
    private int gOq;
    private boolean guA;
    private z<com.baidu.tieba.frs.aggregation.g> guB;
    private boolean guy;
    private com.baidu.tieba.frs.aggregation.a guz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.guG);
        this.DE = new ArrayList();
        this.mHandler = new Handler();
        this.gOo = true;
        this.gOq = 1;
        this.guB = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.gOn != null && e.this.gOn != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gOn.bGl();
                        }
                        if (e.this.gOn != aVar2) {
                            e.this.gOn = aVar2;
                        }
                        if (e.this.gOn != null) {
                            e.this.gOn.mi(e.this.gOo);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.gOn != null && !e.this.gOn.bLs()) {
                            com.baidu.tieba.s.c.cKb().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.fMG, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.s.c.cKb().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.fMG, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.cKb().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.fMG, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.guz = aVar;
        this.guA = z;
        this.gNM = cVar;
        this.mFrom = str;
        this.gNN = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.cOS = str2;
        this.DG = fVar;
        this.gNQ = bVar;
        this.gNS = gVar;
    }

    public void mn(boolean z) {
        this.gOp = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.gOq) {
            this.gOq = i;
            if (this.gOn != null) {
                this.guy = true;
                this.gOn.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.guy) {
                                e.this.guy = false;
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
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.guA, this.mFrom, this.cOS, this.gNQ);
        aVar.c(this.guB);
        aVar.a(this.gNS);
        this.DE.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gOp) {
            if (!this.guy) {
                aVar.bvL().a(gVar, i, this.guz);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kN();
                }
                aVar.bvL().mPosition = i;
                aVar.bvL().setOnVideoContainerForegroundClickListener(this.gNM);
            } else {
                aVar.bvL().c(gVar, i, this.guz);
            }
        }
        if (aVar.bvL() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bvL().setCurrentPlayCallBack(this.DG);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.s.c.cKb().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kR() {
        if (this.gOn != null) {
            return this.gOn.isPlaying();
        }
        return false;
    }

    public boolean bLk() {
        if (this.gOn != null) {
            return this.gOn.bLk();
        }
        return false;
    }

    public void kP() {
        if (this.gOn != null) {
            this.gOn.bGk();
        }
    }

    public void kQ() {
        if (this.gOn != null) {
            this.gOn.bGl();
        }
    }

    public void bLx() {
        if (this.gOn != null) {
            this.gOn.bLl();
        }
    }

    public void onDestroy() {
        if (this.gNN != null) {
            this.gNN.bLD();
        }
        for (a aVar : this.DE) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean tf(int i) {
        if (this.gOn == null) {
            return false;
        }
        return this.gOn.tf(i);
    }

    public void bLy() {
        if (this.gOn != null) {
            this.gOn.bLr();
        }
    }
}
