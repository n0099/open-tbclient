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
    private String cOR;
    private c gNA;
    private com.baidu.tieba.frs.videomiddlepage.a.a gNB;
    private b gNE;
    private com.baidu.tieba.lego.card.view.g gNG;
    private a gOb;
    private boolean gOc;
    private boolean gOd;
    private int gOe;
    private boolean gum;
    private com.baidu.tieba.frs.aggregation.a gun;
    private boolean guo;
    private z<com.baidu.tieba.frs.aggregation.g> gup;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.guu);
        this.DE = new ArrayList();
        this.mHandler = new Handler();
        this.gOc = true;
        this.gOe = 1;
        this.gup = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.gOb != null && e.this.gOb != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gOb.bGk();
                        }
                        if (e.this.gOb != aVar2) {
                            e.this.gOb = aVar2;
                        }
                        if (e.this.gOb != null) {
                            e.this.gOb.mi(e.this.gOc);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.gOb != null && !e.this.gOb.bLr()) {
                            com.baidu.tieba.s.c.cKa().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.fMt, false, (String) null, (String) null));
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
                        com.baidu.tieba.s.c.cKa().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.fMt, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cy("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.cKa().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.fMt, false, (String) null, (String) null));
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
        this.gun = aVar;
        this.guo = z;
        this.gNA = cVar;
        this.mFrom = str;
        this.gNB = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.cOR = str2;
        this.DG = fVar;
        this.gNE = bVar;
        this.gNG = gVar;
    }

    public void mn(boolean z) {
        this.gOd = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.gOe) {
            this.gOe = i;
            if (this.gOb != null) {
                this.gum = true;
                this.gOb.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.gum) {
                                e.this.gum = false;
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
        a aVar = new a(this.mPageContext, this.guo, this.mFrom, this.cOR, this.gNE);
        aVar.c(this.gup);
        aVar.a(this.gNG);
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
        if (!this.gOd) {
            if (!this.gum) {
                aVar.bvK().a(gVar, i, this.gun);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kN();
                }
                aVar.bvK().mPosition = i;
                aVar.bvK().setOnVideoContainerForegroundClickListener(this.gNA);
            } else {
                aVar.bvK().c(gVar, i, this.gun);
            }
        }
        if (aVar.bvK() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bvK().setCurrentPlayCallBack(this.DG);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.s.c.cKa().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kR() {
        if (this.gOb != null) {
            return this.gOb.isPlaying();
        }
        return false;
    }

    public boolean bLj() {
        if (this.gOb != null) {
            return this.gOb.bLj();
        }
        return false;
    }

    public void kP() {
        if (this.gOb != null) {
            this.gOb.bGj();
        }
    }

    public void kQ() {
        if (this.gOb != null) {
            this.gOb.bGk();
        }
    }

    public void bLw() {
        if (this.gOb != null) {
            this.gOb.bLk();
        }
    }

    public void onDestroy() {
        if (this.gNB != null) {
            this.gNB.bLC();
        }
        for (a aVar : this.DE) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean tf(int i) {
        if (this.gOb == null) {
            return false;
        }
        return this.gOb.tf(i);
    }

    public void bLx() {
        if (this.gOb != null) {
            this.gOb.bLq();
        }
    }
}
