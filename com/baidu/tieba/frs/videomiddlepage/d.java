package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Ss;
    private com.baidu.tieba.lego.card.view.f St;
    private String arJ;
    private boolean dQJ;
    private com.baidu.tieba.frs.aggregation.a dQK;
    private boolean dQL;
    private ad<com.baidu.tieba.frs.aggregation.g> dQM;
    private b ehR;
    private com.baidu.tieba.frs.videomiddlepage.controller.a ehS;
    private a eij;
    private boolean eik;
    private boolean eil;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dQR);
        this.Ss = new ArrayList();
        this.mHandler = new Handler();
        this.eik = true;
        this.dQM = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    String str3 = gVar.threadId != null ? gVar.threadId : null;
                    bb bbVar = new bb();
                    bbVar.setId(str3);
                    bbVar.setTid(str3);
                    bbVar.setFid(com.baidu.adp.lib.g.b.d(gVar.forumId, 0L));
                    bbVar.setThreadType(40);
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.eij != null && d.this.eij != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.eij.aEd();
                        }
                        if (d.this.eij != aVar2) {
                            d.this.eij = aVar2;
                        }
                        if (d.this.eij != null) {
                            d.this.eij.hw(d.this.eik);
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                        if (d.this.eij != null && !d.this.eij.aIS()) {
                            com.baidu.tieba.q.c.bCC().b(d.this.mBdUniqueId, com.baidu.tieba.q.a.a(bbVar, "a023", "common_click", 1, gVar.dbk, false, null, null));
                        }
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                        com.baidu.tieba.q.c.bCC().b(d.this.mBdUniqueId, com.baidu.tieba.q.a.a(bbVar, "a023", "common_click", 5, gVar.dbk, false, null, null));
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                        com.baidu.tieba.q.c.bCC().b(d.this.mBdUniqueId, com.baidu.tieba.q.a.a(bbVar, "a023", "common_click", 2, gVar.dbk, false, null, null));
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.aB(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.aB("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.dQK = aVar;
        this.dQL = z;
        this.ehR = bVar;
        this.mFrom = str;
        this.ehS = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.arJ = str2;
        this.St = fVar;
    }

    public void hA(boolean z) {
        this.eil = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.eij != null) {
            this.dQJ = true;
            this.eij.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dQJ) {
                            d.this.dQJ = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dQL, this.mFrom, this.arJ);
        aVar.b(this.dQM);
        this.Ss.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.eil) {
            if (!this.dQJ) {
                aVar.arr().a(gVar, i, this.dQK);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pB();
                }
                aVar.arr().mPosition = i;
                aVar.arr().setOnVideoContainerForegroundClickListener(this.ehR);
            } else {
                aVar.arr().c(gVar, i, this.dQK);
            }
        }
        if (aVar.arr() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.arr().setCurrentPlayCallBack(this.St);
        }
        gVar.dbk = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bb bbVar = new bb();
        bbVar.setId(str);
        bbVar.setTid(str);
        bbVar.setFid(com.baidu.adp.lib.g.b.d(gVar.forumId, 0L));
        bbVar.setThreadType(40);
        com.baidu.tieba.q.c.bCC().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bbVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pF() {
        if (this.eij != null) {
            return this.eij.isPlaying();
        }
        return false;
    }

    public void pD() {
        if (this.eij != null) {
            this.eij.aEc();
        }
    }

    public void pE() {
        if (this.eij != null) {
            this.eij.aEd();
        }
    }

    public void onDestroy() {
        if (this.ehS != null) {
            this.ehS.aJa();
        }
        for (a aVar : this.Ss) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean mI(int i) {
        if (this.eij == null) {
            return false;
        }
        return this.eij.mI(i);
    }
}
